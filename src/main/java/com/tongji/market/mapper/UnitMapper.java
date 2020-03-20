package com.tongji.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongji.market.model.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UnitMapper extends BaseMapper<Unit> {
}
