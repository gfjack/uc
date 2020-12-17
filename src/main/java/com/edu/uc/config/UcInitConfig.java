package com.edu.uc.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UcInitConfig {

  @RequestMapping("/")
  public ModelAndView index() {
    return new ModelAndView("index");
  }

}
