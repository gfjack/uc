package com.edu.uc.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@ApiModel(description = "PO基类")
public abstract class BasePo implements Serializable {

  @ApiModelProperty("创建者")
  @Column(name = "create_by")
  protected Long createBy;

  @ApiModelProperty("创建时间")
  @Column(name = "create_time")
  protected Date createTime;

  @ApiModelProperty("更新者")
  @Column(name = "update_by")
  protected Long updateBy;

  @ApiModelProperty("更新时间")
  @Column(name = "update_time")
  protected Date updateTime;

  @PrePersist
  protected void onPrePersist() {
    // 新建时候允许传入固定值
    if (this.createBy == null) {
      this.createBy = 0L;
    }
    if (this.createTime == null) {
      this.createTime = new Date();
    }
    this.updateBy = this.createBy;
    this.updateTime = this.createTime;
  }

  @PreUpdate
  protected void onPreUpdate() {
    // 更新时候强制修改 传值无效
    this.updateBy = 0L;
    this.updateTime = new Date();
  }
}