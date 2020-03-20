package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.CommodityMapper;
import com.tongji.market.model.entity.Commodity;
import com.tongji.market.service.ICommodityService;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity>
        implements ICommodityService {
}
