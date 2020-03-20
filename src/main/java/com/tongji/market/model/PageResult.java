package com.tongji.market.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageResult {
    private Long total;
    private Object rows;
}
