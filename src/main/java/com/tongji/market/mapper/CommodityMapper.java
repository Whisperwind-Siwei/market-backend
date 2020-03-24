package com.tongji.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.tongji.market.model.entity.Commodity;
import com.tongji.market.model.vo.CommodityBriefVo;
import com.tongji.market.model.vo.CommodityVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    CommodityVo getOne(Long commodityId);

    List<CommodityBriefVo> search(String words);
}