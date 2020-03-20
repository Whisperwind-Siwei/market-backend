package com.tongji.market.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.tongji.market.common.constant.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String code;
    private String name;
    private Gender gender;

    @ApiModelProperty(hidden = true)
    @TableLogic
    @TableField(select = false)
    private Boolean isActive;
}
