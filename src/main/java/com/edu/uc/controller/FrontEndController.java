package com.edu.uc.controller;

import com.edu.uc.model.vo.RegisterVo;
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
@Api(tags = "前端接口", description = "用于前端进行用户登录验证, 注册信息等")
@RestController
@RequestMapping("")
public class FrontEndController {

  // todo 后续最好通过mq来实现服务组件和授权组件用户的同步性, 此接口仅做降级备用处理
  @ApiOperation("创建用户")
  @RequestMapping(value = "/v1/register", method = RequestMethod.POST)
  public RegisterVo register() {
    return null;
  }

  @ApiOperation("登录接口")
  @RequestMapping(value = "/v1/login", method = RequestMethod.POST)
  public Status logIn() {
    return null;
  }

  @ApiOperation("注销登录")
  @RequestMapping(value = "/v1/logout", method = RequestMethod.POST)
  public Status logOut() {
    return null;
  }

}
