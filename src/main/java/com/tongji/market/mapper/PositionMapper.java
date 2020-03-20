package com.tongji.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongji.market.model.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PositionMapper extends BaseMapper<Position> {
}
