package com.lwh.murder.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lwh
 * @date 2021/4/12 19:36
 */
@Data
@ApiModel(description = "剧本杀管理系统")
@TableName("murder_user")
public class MurderModel {

    @ApiModelProperty("客户id")
    @TableField("id")
    private int id;

    @ApiModelProperty("客户姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("客户所玩剧本杀名称")
    @TableField("murder_name")
    private String murderName;

    @ApiModelProperty("客户id")
    @TableField("user_id")
    private String userId;
}
