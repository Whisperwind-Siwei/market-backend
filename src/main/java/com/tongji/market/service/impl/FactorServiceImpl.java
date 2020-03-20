package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.FactorMapper;
import com.tongji.market.model.entity.Factor;
import com.tongji.market.service.IFactorService;
import org.springframework.stereotype.Service;

@Service
public class FactorServiceImpl extends ServiceImpl<FactorMapper, Factor>
        implements IFactorService {
}
