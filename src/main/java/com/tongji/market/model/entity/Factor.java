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
public class Factor implements Serializable {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String name;

    @ApiModelProperty(hidden = true)
    @TableLogic
    @TableField(select = false)
    private Boolean isActive;
}
