package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQueryCondition {
    @ApiModelProperty("用户名(@ApiModelProperty)")
    private String username;
    private String password;
    private String test;
}
