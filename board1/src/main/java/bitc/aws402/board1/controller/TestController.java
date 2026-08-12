//  File :  TestController.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오후 3:27
//  Desc :  

package bitc.aws402.board1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TestController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }
}











