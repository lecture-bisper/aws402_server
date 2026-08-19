//  File :  AuthController.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 2:31
//  Desc :  

package bitc.aws402.board3.controller;

import bitc.aws402.board3.dto.MemberDTO;
import bitc.aws402.board3.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AuthController {

  private final MemberService memberService;

//  회원 가입(view)
  @RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
  public String signup() {

    return "auth/signup";
  }

//  회원 가입(process)
  @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
  public String signup(@ModelAttribute MemberDTO member) {

    boolean result = memberService.insertMember(member);

    if (result) {
      return "redirect:/auth/signin";
    }
    else {
      return "redirect:/auth/signup";
    }
  }

//  로그인(view)
  @RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
  public String signin() {

    return "auth/signin";
  }

//  로그인(process)
  @RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
  public String signin(
      @RequestParam("userId") String userId,
      @RequestParam("userPw") String userPw,
      HttpSession session
  ) {

    int result = memberService.isLogin(userId, userPw);

    if (result == 1) {
      MemberDTO member = memberService.selectMember(userId);

      session.setAttribute("userId", member.getMemberId());
      session.setAttribute("userName", member.getMemberName());
      session.setAttribute("userEmail", member.getMemberEmail());
      session.setAttribute("userPhone", member.getMemberPhone());

      session.setMaxInactiveInterval(60 * 5);

      return "redirect:/board/list";
    }
    else {
      return "redirect:/auth/signin";
    }
  }

//  로그아웃
  @RequestMapping(value = "/auth/signout", method = RequestMethod.GET)
  public String signOut(HttpSession session) {

    session.removeAttribute("userId");
    session.removeAttribute("userName");
    session.removeAttribute("userPhone");
    session.removeAttribute("userEmail");

    session.invalidate();

    return "auth/signout";
  }
}











