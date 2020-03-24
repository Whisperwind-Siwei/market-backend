package com.tongji.market.model.vo;

import lombok.Data;

@Data
public class CommodityVo {
    private Long id;
    private String code;
    private String name;
    private String positionName;
    private Integer price;
    private Integer inventory;
    private String unitName;
    private String description;
    private Long typeId;
}
