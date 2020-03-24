package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.PositionsMapper;
import com.tongji.market.model.entity.Positions;
import com.tongji.market.service.IPositionsService;
import org.springframework.stereotype.Service;

@Service
public class PositionsServiceImpl extends ServiceImpl<PositionsMapper, Positions>
        implements IPositionsService {
}
