package com.edu.uc.model.entity;

import com.edu.uc.constants.enums.UserRole;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@ApiModel("角色")
@Entity
@Table(name = "t_role")
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Data
public class Role extends BasePo {

  @ApiModelProperty("id")
  @Id
  private Integer id;

  @ApiModelProperty("角色")
  @Type(type = "json")
  private UserRole role;

}
