package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.CommodityFactorMapper;
import com.tongji.market.model.entity.CommodityFactor;
import com.tongji.market.service.ICommodityFactorService;
import org.springframework.stereotype.Service;

@Service
public class CommodityFactorServiceImpl extends ServiceImpl<CommodityFactorMapper, CommodityFactor>
        implements ICommodityFactorService {
}
