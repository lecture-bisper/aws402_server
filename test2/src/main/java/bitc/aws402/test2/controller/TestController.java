//  File :  TestController.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오전 11:27
//  Desc :  

package bitc.aws402.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  스프링 MVC : 웹 애플리케이션의 구조를 Model, View, Controller 의 3단계로 나누어서 개발하는 형태
//  Model : 데이터를 의미함
//  View : 사용자에게 보여줄 html 템플릿
//  Controller : View 와 Model 사이에서 필요한 연산 및 데이터 처리를 진행, 웹브라우저를 통한 사용자의 요청을 받고 View 를 사용자에게 제공하는 역할

//  Service : 사용자 요청을 처리하기 위한 비즈니스 로직을 수행하는 영역, 인터페이스로 구현
//  DAO : Data Access Object 의 약자로 데이터베이스에 접속하여 비즈니스 로직에서 필요한 SQL 쿼리 호출
@RestController
public class TestController {

  @RequestMapping("/")
  public String index() {
    return "Hello World!!";
  }
}











