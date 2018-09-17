package com.huawei.eurekaclientprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaSampleController {

  @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
  public String hello(){
    return "hello, huawei. There is cse";
  }
}
