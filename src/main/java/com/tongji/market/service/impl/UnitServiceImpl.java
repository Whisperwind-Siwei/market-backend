package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.UnitMapper;
import com.tongji.market.model.entity.Unit;
import com.tongji.market.service.IUnitService;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
        implements IUnitService {
}
