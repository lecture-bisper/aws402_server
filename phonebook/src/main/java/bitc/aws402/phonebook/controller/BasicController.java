//  File :  BasicController.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오후 12:08
//  Desc :  

package bitc.aws402.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

//  사용자가 접속할 URL 을 {"주소1", "주소2", ...} 형식으로 입력 가능
  @RequestMapping({"", "/", "/phonebook"})
  public String index() {
    return "redirect:/phonebook/list";
  }
}











