package com.edu.uc.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户注册")
public class RegisterVo {

  @ApiModelProperty("用户id")
  private Long userId;

  @ApiModelProperty("用户密码")
  private String password;

}
