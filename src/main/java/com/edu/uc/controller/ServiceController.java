package com.edu.uc.controller;

import com.edu.uc.model.vo.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jack
 * @date 2020-12-17
 */
@Api(tags = "服务端接口", description = "用于服务端的验证等等")
@RestController
@RequestMapping("")
public class ServiceController {

  @ApiOperation("验证token")
  @RequestMapping(value = "/v1/verify_token", method = RequestMethod.POST)
  public Status verifyToken() {
    return null;
  }

}
