package com.tongji.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongji.market.mapper.CustomerFactorMapper;
import com.tongji.market.model.entity.CustomerFactor;
import com.tongji.market.service.ICustomerFactorService;
import org.springframework.stereotype.Service;

@Service
public class CustomerFactorServiceImpl extends ServiceImpl<CustomerFactorMapper, CustomerFactor>
        implements ICustomerFactorService {
}
