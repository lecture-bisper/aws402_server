//  File :  BasicController.java
//  User :  it
//  Date :  2026-08-14
//  Time :  오전 9:17
//  Desc :  

package bitc.aws402.basic.controller;

import bitc.aws402.basic.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//  스프링의 컨트롤러는 사용자의 요청에 대한 응답을 처리하는 곳
//  응답 처리 시 접속할 URL 주소와 사용자가 전달하는 데이터를 입력받는 부분도 함께 있어야 함
//  데이터를 전달받는 부분이 없을 경우 사용자가 전달하는 데이터를 처리할 수 없음

//  서버에서는 사용자에 대한 응답 처리를 2가지 형태로 처리함
//  1. 단순 View 페이지 출력
//  2. 사용자가 전달한 데이터를 받아서 내부 연산 처리

@Controller
public class BasicController {


  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  단순 view 페이지 출력
  @RequestMapping("/calculator")
  public String calculator() {
    return "calculator";
  }

//  사용자가 전달한 데이터를 입력받아서 내부 연산 처리 및 응답을 진행
//  @RequestParam : 스프링프레임워크에서 제공하는 어노테이션으로 사용자가 서버로 전달한 데이터를 가져옴
//  RequestParam 의 추가 옵션 :
//  value : 클라이언트에서 전달하는 데이터의 이름을 지정, input 태그의 name 속성값, 단독으로만 사용 시 value 속성명을 입력하지 않아도 상관없음
//  required : 기본값 true, 전달받은 데이터가 없을 경우 오류 출력 여부, false 사용 시 무시
//  defaultValue : required 속성이 false 이고, 전달받은 데이터가 없을 경우 지정된 기본값을 사용
  @RequestMapping("/result")
  public String result(@RequestParam(value = "num1", required = false, defaultValue = "100") int num1, @RequestParam("num2") int num2, Model model) {
//    전달받은 데이터로 연산 진행
    int result = num1 + num2;

//    연산 처리된 데이터를 View 에 포함
    model.addAttribute("result", result);
    model.addAttribute("num1", num1);
    model.addAttribute("num2", num2);

    return "result";
  }

//  회원 가입 정보를 입력받기 위한 단순 View 페이지
  @RequestMapping("/signup")
  public String signup() {
    return "signup";
  }

//  입력받은 회원 정보를 처리하기 위한 process 페이지
  @RequestMapping("/signupProcess")
  public String signupProcess(
      @RequestParam("userId") String userId,
      @RequestParam("userPw") String userPw,
      @RequestParam("userName") String userName,
      @RequestParam("userEmail") String userEmail,
      @RequestParam("userPhone") String userPhone,
      @RequestParam("userAddr") String userAddr
  ) {

    System.out.println("\n ----- 입력받은 데이터 -----\n");
    System.out.println("userId : " + userId);
    System.out.println("userPw : " + userPw);
    System.out.println("userName : " + userName);
    System.out.println("userEmail : " + userEmail);
    System.out.println("userPhone : " + userPhone);
    System.out.println("userAddr : " + userAddr);

    return "signup";
  }

  @RequestMapping("/signup2")
  public String signup2() {
    return "signup2";
  }

//  @ModelAttribute : 클라이언트에서 서버로 전달하는 데이터를 지정한 클래스 타입의 객체로 한번에 입력받는 어노테이션
//  클라이언트에서 서버로 데이터 전달 시 서버에서 DTO 타입으로 데이터를 전달받을 경우 DTO 타입의 필드명과 input 태그의 name 속성값이 같아야함
//  DTO 클래스에서 제공하는 필드의 Getter/Setter 를 사용하여 데이터를 가져오고 입력하기 때문에 input 태그의 name 속성값과 DTO 타입의 필드명이 반드시 일치해야함(Getter/Setter 필수)
  @RequestMapping("/signupProcess2")
  public String signupProcess2(@ModelAttribute MemberDTO member) {

    System.out.println("\n ----- MemberDTO 타입으로 입력받기 -----\n");
    System.out.println("userId : " + member.getUserId());
    System.out.println("userPw : " + member.getUserPw());
    System.out.println("userName : " + member.getUserName());
    System.out.println("userEmail : " + member.getUserEmail());
    System.out.println("userPhone : " + member.getUserPhone());
    System.out.println("userAddr : " + member.getUserAddr());

    return "signup2";
  }

//  @RequestMapping : 클라이언트에서 서버로 접속 시 서버에서 제공하는 URL 주소와 메소드를 연동하는 어노테이션, 클래스와 메소드에 사용 가능
//  클래스에 사용 시 기본 주소를 설정할 수 있음
//  RequestMethod 속성을 추가하여 통신 방식을 설정할 수 있음
//  GET, POST, PUT, DELETE 를 설정하여 클라이언트에서 접속하는 통신 방식을 설정할 수 있음
//  접속 URL 이 같아도 통신 방식이 다를 경우 연동되는 메소드를 다르게 처리할 수 있음
//  RequestMethod 속성을 추가하지 않을 경우 스프링 프레임워크에서 자동 처리함
//  RequestMethod 사용 시 url 입력을 위한 value 속성이 필수

//  스프링프레임워크에서 RequestMethod 속성을 사용을 내부적으로 강제하는 어노테이션이 존재함
//  RequestMethod 속성을 사용하지 않음
//  GetMapping() : 클라이언트와 통신 방식이 GET 방식으로 고정된 어노테이션
//  PostMapping() : 클라이언트와 통신 방식이 Post 방식으로 고정된 어노테이션
//  PutMapping() : 클라이언트와 통신 방식이 Put 방식으로 고정된 어노테이션
//  DeleteMapping() : 클라이언트와 통신 방식이 Delete 방식으로 고정된 어노테이션

  @RequestMapping("/get_post_test")
  public String get_post_test() {
    return "get_post_test";
  }

  @RequestMapping(value = "/signup3", method = RequestMethod.GET)
  public String signup31() {

    System.out.println("\n ----- GET 방식으로 통신 -----\n");

    return "get_post_test";
  }

  @RequestMapping(value = "/signup3", method = RequestMethod.POST)
  public String signup32() {

    System.out.println("\n ----- POST 방식으로 통신 -----\n");

    return "get_post_test";
  }
}











