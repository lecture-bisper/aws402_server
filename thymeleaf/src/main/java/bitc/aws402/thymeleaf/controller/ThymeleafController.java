//  File :  ThymeleafController.java
//  User :  it
//  Date :  2026-08-12
//  Time :  오전 11:05
//  Desc :  

package bitc.aws402.thymeleaf.controller;

import bitc.aws402.thymeleaf.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  @Controller : 스프링 MVC에서 해당 클래스가 MVC 패턴 중 Controller 부분이라는 의미의 어노테이션
@RequestMapping("/basic")
@Controller
public class ThymeleafController {
//  @RequestMapping : 클라이언트가 접속할 URI 를 지정하는 어노테이션
//  클래스와 메소드에 사용할 수 있음
//  클래스에 사용 시 기본 URI 로 설정, 메소드에 사용 시 상세 URI 를 설정함
//  RequestMethod 옵션을 추가하여 GET, POST, PUT, DELETE 방식을 사용할 수 있음
//  메소드에는 @RequestMapping 어노테이션을 대신 사용하는 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 이 존재함

//  클래스에 @Controller 어노테이션을 사용하고, 멤버 메소드에 @RequestMapping 어노테이션을 사용하여 클라이언트가 접속할 URI 를 설정할 수 있음
//  지정한 메소드의 반환 타입이 String 일 경우 View 파일의 경로를 의미함
//  index.html 파일은 웹의 기본 파일이기 때문에 파일명을 입력하지 않아도 자동으로 인식됨
  @RequestMapping("/")
  public String index() {
//    resources 의 templates 폴더 아래에 있는 index.html 을 의미함
    return "index";
  }

  @RequestMapping("/thymeleaf")
  public String thymeleaf() {
//  html 파일의 기본 폴더인 templates 폴더의 하위 폴더로 thymeleaf 가 있고 그 안에 index.html 파일을 의미함
    return "thymeleaf/index";
  }

  @RequestMapping("/thymeleaf/study01")
  public ModelAndView study01() {
//    ModelAndView : 스프링 프레임워크에서 제공하는 클래스로 데이터와 뷰 파일이 함께 포함된 클래스
//    해당 클래스의 객체를 반환하면 지정한 view 파일(html 파일)을 데이터와 함께 클라이언트에게 전달
    ModelAndView mav = new ModelAndView("thymeleaf/study01");

//    view 파일에 데이터 전달하기
//    addObject(이름, 데이터) : ModelAndView 클래스 타입의 객체에 데이터를 추가하는 명령
//    첫번째 매개변수가 html 파일에서 변수 이름으로 사용됨
    mav.addObject("value01", "안녕하세요");
    mav.addObject("value02", 100);
    mav.addObject("value03", 200);
//    utext 라는 이름으로 일반 문자열과 html 태그를 혼합하여 클라이언트로 전달
    mav.addObject("utext", "문자열과 <strong>html 태그</strong>가 혼합된 문자열");
    mav.addObject("idx", 5);

    return mav;
  }

  @RequestMapping("/thymeleaf/parameter")
  public ModelAndView parameter(@RequestParam("idx") int idx, @RequestParam("text") String text) {
    ModelAndView mav = new ModelAndView("thymeleaf/parameter");

    mav.addObject("idx", idx);
    mav.addObject("text", text);

    return mav;
  }


  @RequestMapping("/thymeleaf/study02")
  public ModelAndView study02() {
    ModelAndView mav = new ModelAndView("thymeleaf/study02");

    MemberDTO member = new MemberDTO();
    member.setId("iu");
    member.setName("아이유");
    member.setPass("1234");
    member.setRegiDate("2026.08.12");

    mav.addObject("member", member);

    mav.addObject("str1", "첫번째");
    mav.addObject("str2", "두번째");
    mav.addObject("str3", null);

    return mav;
  }

  @RequestMapping("/thymeleaf/study03")
  public ModelAndView study03() {
    ModelAndView mav = new ModelAndView("thymeleaf/study03");

//    ModelAndView 타입의 객체에 문자열 데이터 저장
    mav.addObject("str1", "첫번째");
    mav.addObject("str2", "두번째");
//    ModelAndView 타입의 객체에 null 을 저장
    mav.addObject("str3", null);

//    ModelAndView 타입의 객체에 정수 데이터 저장
    mav.addObject("num1", 100);
    mav.addObject("num2", 200);
    mav.addObject("num3", 11);

    return mav;
  }

  @RequestMapping("/thymeleaf/study04")
  public ModelAndView study04() {
    ModelAndView mav = new ModelAndView("thymeleaf/study04");

    mav.addObject("num", 11);

    mav.addObject("nullData", null);

    mav.addObject("grade", "C");

    String[] strArray = {"첫번째", "두번째", "세번째", "네번째", "다섯번째"};
    List<String> strList = Arrays.asList(strArray);

    mav.addObject("itemArray", strArray);
    mav.addObject("itemList", strList);

    MemberDTO member1 = new MemberDTO();
    member1.setId("iu");
    member1.setName("아이유");
    member1.setPass("1234");
    member1.setRegiDate("2026.08.12 16:30:00");

    MemberDTO member2 = new MemberDTO();
    member2.setId("inna");
    member2.setName("유인나");
    member2.setPass("1234");
    member2.setRegiDate("2026.08.12 16:31:00");

    MemberDTO member3 = new MemberDTO();
    member3.setId("karina");
    member3.setName("카리나");
    member3.setPass("1234");
    member3.setRegiDate("2026.08.12 16:32:00");

    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(member1);
    memberList.add(member2);
    memberList.add(member3);

    mav.addObject("memberList", memberList);

    return mav;
  }

//  반환 타입을 String 으로 설정하여 실제로 반환하는 데이터를 View 파일의 경로로 설정
//  매개변수로 Model 인터페이스를 받아서 View 파일에 전달할 데이터를 저장
//  ModelAndView 를 사용하는 것과 동일한 방식
  @RequestMapping("/thymeleaf/study05")
  public String study05(Model model) {

//    addAttribute() : ModelAndView 클래스의 객체에 데이터를 저장하는 addObject() 와 동일한 역할을 하는 메소드
    model.addAttribute("checkedVal", true);
    model.addAttribute("multipleVal", true);
    model.addAttribute("selectedVal", true);
    model.addAttribute("disabledVal", true);
    model.addAttribute("readonlyVal", true);

    return "thymeleaf/study05";
  }

  @RequestMapping("/thymeleaf/study06")
  public String study06() {
    return "thymeleaf/study06";
  }
}











