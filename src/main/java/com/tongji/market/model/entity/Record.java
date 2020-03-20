package com.tongji.market.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record implements Serializable {
    @ApiModelProperty(hidden = true)
    private Long id;

    private Long customerId;
    private Long commodityId;
    private Integer quantity;
    private Long totalPrice;
    private Integer degree;

    @ApiModelProperty(hidden = true)
    @TableLogic
    @TableField(select = false)
    private Boolean isActive;
}
