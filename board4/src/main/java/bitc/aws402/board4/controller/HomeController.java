//  File :  HomeController.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 2:05
//  Desc :  

package bitc.aws402.board4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping({"", "/"})
  public String index() {
    return "index";
  }
}











