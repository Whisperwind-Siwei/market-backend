package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.PositionMapper;
import com.tongji.market.model.entity.Position;
import com.tongji.market.service.IPositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
        implements IPositionService {
}
