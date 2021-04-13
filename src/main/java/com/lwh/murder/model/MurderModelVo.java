package com.lwh.murder.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lwh
 * @date 2021/4/13 10:13
 */
@Data
public class MurderModelVo {

    @ApiModelProperty("客户名字")
    private String userName;

    @ApiModelProperty("客户id")
    private String userId;
}
