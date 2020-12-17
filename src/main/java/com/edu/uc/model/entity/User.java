package com.edu.uc.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("用户")
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user")
@Data
public class User extends BasePo {

  @ApiModelProperty("用户名")
  @Id
  private Long userId;

  @ApiModelProperty("用户密码")
  private String password;

}
