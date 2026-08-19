//  File :  LoginController.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오전 9:34
//  Desc :  

package bitc.aws402.login.controller;

import bitc.aws402.login.dto.UserDTO;
import bitc.aws402.login.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//  세션 : 웹은 각각의 페이지가 서로 독립적으로 동작하기 때문에 서로 데이터를 공유하지 않음
//  세션은 웹 상에서 데이터를 저장하기 위한 공간
//  세션은 데이터를 서버에 저장, 사용자는 세션 정보를 확인할 수 없음
//  보안성이 높음, 서버의 자원만큼 저장할 수 있는 용량이 늘어남,
//  자바 객체를 그대로 저장, 로그인 시 주로 사용함

//  스프링에서는 HttpSession 클래스 타입의 객체를 생성하여 세션을 사용함
//  HttpServletRequest 를 통해서 HttpSession 객체를 얻어와서 사용함

//  thymeleaf 에서는 session 객체를 미리 제공하고 있음
//  ${session.key명} 형태로 사용함

//  세션의 주요 메소드
//  setAttribute(key, value) : 세션에 데이터 저장, 이미 저장된 key 가 있으면 수정
//  getAttribute(key) : 세션에 저장된 데이터 출력
//  removeAttribute(key) : 세션에 저장된 데이터 삭제
//  invalidate() : 세션에 저장된 모든 정보 삭제
//  getId() : 세션 ID 가져오기
//  setMaxInactiveInterval(sec) : 세션 정보가 서버에서 유지되는 시간 설정, 해당 시간 초과 시 세션 정보 모두 삭제
//  getMaxInactiveInterval() : 현재 세션의 유지 시간 확인


@RequiredArgsConstructor
@Controller
public class LoginController {

  private final UserService userService;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  아무나 접속 가능한 페이지
  @RequestMapping(value = "/main", method = RequestMethod.GET)
  public String main() {
    return "login/main";
  }

//  로그인 정보를 입력하는 페이지
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginForm() {
    return "login/login";
  }

//  로그인 처리 페이지, 로그인 성공 시 세션에 데이터 저장, loginOK로 이동
//  로그인 실패 시 저장되는 데이터는 없고, loginFail로 이동
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public String loginProcess(
      @RequestParam("userId") String userId,
      @RequestParam("userPw") String userPw,
      HttpServletRequest request
  ) {

//    if (userId.equals("aws402") && userPw.equals("1234")) {
////      Request 를 통해서 세션 정보를 가져옴
//      HttpSession session = request.getSession();
////      세션 영역에 데이터 저장
//      session.setAttribute("userId", userId);
//      session.setAttribute("userName", "테스터1");
////      세션 유지 시간 설정
//      session.setMaxInactiveInterval(60 * 1);
//
//      return "redirect:/loginOk";
//    }
//    else {
//      return "redirect:/loginFail";
//    }

    int result = userService.isLogin(userId, userPw);

    if (result == 1) {
      UserDTO user = userService.selectUserInfo(userId);

      HttpSession session = request.getSession();
      session.setAttribute("userId", user.getUserId());
      session.setAttribute("userName", user.getUserName());

      session.setMaxInactiveInterval(60 * 5);

      return "redirect:/loginOk";
    }
    else {
      return "redirect:/loginFail";
    }
  }

//  로그인 성공 후 접속하는 페이지
  @RequestMapping(value = "/loginOk", method = RequestMethod.GET)
  public String loginOk() {
    return "login/loginOk";
  }

//  로그인 실패 페이지
  @RequestMapping(value = "/loginFail", method = RequestMethod.GET)
  public String loginFail() {
    return "login/loginFail";
  }

//  로그아웃 페이지
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
//  public String logout(HttpServletRequest request) {
//  매개변수로 HttpServletRequest 대신 HttpSession 을 사용 시 스프링 프레임워크가 자동으로 세션 객체를 생성해줌
  public String logout(HttpSession session) {

//    HttpSession session = request.getSession();
//    현재 세션에 저장된 데이터 삭제
    session.removeAttribute("userId");
    session.removeAttribute("userName");

//    현재 세션에 저장된 모든 데이터 삭제
    session.invalidate();

    return "login/logout";
  }
}











