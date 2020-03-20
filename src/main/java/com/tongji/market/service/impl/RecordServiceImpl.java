package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.RecordMapper;
import com.tongji.market.model.entity.Record;
import com.tongji.market.service.IRecordService;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
        implements IRecordService {
}
