//  File :  TestController.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오전 10:11
//  Desc :  

package com.example.test1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  localhost : 네트워크 상에서 자신을 의미하는 DNS 주소, IP 번호로 127.0.0.1 과 같음
//  127.0.0.1 : 네트워크 상에서는 네트워크에 접속하는 리소스를 IP 번호로 구분함, 127.0.0.1 은 해당 네트워크에 접속한 자신을 의미하는 IP 번호
//  DNS : 네크워크 상의 IP 번호와 영어 단어로 되어 있는 URL 주소를 매칭시켜 놓은 서버, 컴퓨터는 IP 번호만 가지고 모든 네크워크 상의 서버에 접속하는 것이 가능함, 사람은 숫자를 잘 기억하지 못함

//  해당 클래스가 Rest 컨트롤러 기능을 수행하도록 설정
@RestController
public class TestController {

//  웹 브라우저의 url 창에 입력한 주소와 아래의 메소드를 연동함
  @RequestMapping("/")
  public String hello() {
//    클라이언트로 return 값을 전달함
    return "Hello World!";
  }
}











