package com.tongji.market.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tongji.market.common.util.PearsonCorrelation;
import com.tongji.market.mapper.CommodityMapper;
import com.tongji.market.model.ApiResult;
import com.tongji.market.model.entity.Commodity;
import com.tongji.market.model.entity.Customer;
import com.tongji.market.model.entity.Record;
import com.tongji.market.model.vo.CommodityVo;
import com.tongji.market.service.ICommodityService;
import com.tongji.market.service.ICustomerService;
import com.tongji.market.service.IRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = {"商品相关接口"})
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    private CommodityMapper commodityMapper;
    private ICommodityService iCommodityService;
    private ICustomerService iCustomerService;
    private IRecordService iRecordService;

    @Autowired
    public CommodityController(CommodityMapper commodityMapper,
                               ICommodityService iCommodityService,
                               ICustomerService iCustomerService,
                               IRecordService iRecordService) {
        this.commodityMapper = commodityMapper;
        this.iCommodityService = iCommodityService;
        this.iCustomerService = iCustomerService;
        this.iRecordService = iRecordService;
    }

    @ApiOperation("查询商品信息")
    @GetMapping("/{id}")
    public ApiResult get(@PathVariable("id") Long commodityId) {
        return new ApiResult().success(commodityMapper.getOne(commodityId));
    }

    @ApiOperation("查询商品信息")
    @GetMapping("/search")
    public ApiResult search(@RequestParam String words) {
        return new ApiResult().success(commodityMapper.search(words));
    }

    @ApiOperation("获取推荐")
    @GetMapping("/recommend")
    public ApiResult getRecommend(@RequestParam Long customerId) {
        List<Long> recommendList = recommend(customerId);
        List<CommodityVo> commodityVoList = recommendList.stream().map(i -> commodityMapper.getOne(i))
                    .collect(Collectors.toList());
        return new ApiResult().success(commodityVoList);
    }

    private List<Long> recommend(Long customerId) {

        List<Record> recordList = iRecordService.list();
        List<Customer> customers = iCustomerService.list();
        List<Commodity> commodities = iCommodityService.list();
        double[][] fullMatrix = new double[commodities.size()][customers.size()];
        TreeMap<Long, Long> boughtCount = new TreeMap<>((o1, o2) -> (int) (o1 - o2));
        double[][] relation = new double[commodities.size()][commodities.size()];
        List<Long> customerBoughtId = new ArrayList<>();
        List<Integer> customerBoughtNumber = new ArrayList<>();

        for (Record record : recordList) {
            fullMatrix[record.getCommodityId().intValue()][record.getCustomerId().intValue()] =
                    record.getDegree().doubleValue();
            if (boughtCount.containsKey(record.getCommodityId())) {
                boughtCount.put(record.getCommodityId(), boughtCount.get(record.getCommodityId()) +
                            record.getDegree().longValue());
            } else {
                boughtCount.put(record.getCommodityId(), record.getDegree().longValue());
            }
            if (record.getCustomerId().equals(customerId)) {
                customerBoughtId.add(record.getCommodityId());
                customerBoughtNumber.add(record.getDegree());
            }
        }

        for (int i = 0; i < commodities.size(); i++) {
            for (int j = 0; j < commodities.size(); j++) {
                if (relation[i][j] != 0) {
                    continue;
                }
                if (i == j) {
                    relation[i][j] = 1;
                    continue;
                }
                List<Double> iVector = new ArrayList<>();
                List<Double> jVector = new ArrayList<>();
                for (int z = 0; z < customers.size(); z++) {
                    iVector.add(fullMatrix[i][z]);
                    jVector.add(fullMatrix[j][z]);
                }
                relation[i][j] = PearsonCorrelation.getPearsonCorrelationScore(iVector, jVector);
                relation[j][i] = relation[i][j];
            }
        }
        TreeMap<Long, Double> preList = new TreeMap<>((o1, o2) -> (int) (o1 - o2));
        for (int i = 0; i < commodities.size(); i++) {
            if (fullMatrix[i][customerId.intValue()] != 0) {
                continue;
            }
            double numerator = 0.0;
            double denominator = 0.0;
            for (int j = 0; j < customerBoughtId.size(); j++) {
                numerator += relation[i][customerBoughtId.get(j).intValue()] * customerBoughtNumber.get(j);
                denominator += relation[i][customerBoughtId.get(j).intValue()];
            }
            if (denominator != 0) {
                preList.put((long) i, numerator / denominator);
            }
        }
        List<Long> recommendedList = new ArrayList<>();
        for (Long aLong : preList.keySet()) {
            if (recommendedList.size() == 2) {
                break;
            }
            recommendedList.add(aLong);
        }
        for (Long aLong : boughtCount.keySet()) {
            if (recommendedList.size() == 2) {
                break;
            }
            if (!recommendedList.contains(aLong) && !customerBoughtId.contains(aLong)) {
                recommendedList.add(aLong);
            }
        }
        return recommendedList;
    }
}
