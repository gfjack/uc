package com.edu.uc.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("用户角色关系表")
@Data
@Entity
@Table(name = "t_user_relation")
public class UserRoleRelation {

  @ApiModelProperty("主键id")
  @Id
  private Integer id;

  @ApiModelProperty("用户id")
  private Long userId;

  @ApiModelProperty("角色id")
  private Integer roleId;

}
