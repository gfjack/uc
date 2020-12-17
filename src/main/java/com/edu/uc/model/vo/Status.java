package com.edu.uc.model.vo;

import com.edu.uc.constants.enums.UserRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("状态")
@Data
public class Status {

  @ApiModelProperty("用户token")
  private String token;

  @ApiModelProperty(value = "用户名", reference = "仅当用户验证通过后, 才会有信息")
  private String userName;

  @ApiModelProperty(value = "用户角色", reference = "仅当用户验证通过后, 才会有信息")
  private UserRole userRole;

  @ApiModelProperty("是否验证通过")
  private boolean pass;

}
