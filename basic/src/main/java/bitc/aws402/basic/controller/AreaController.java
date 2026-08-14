//  File :  AreaController.java
//  User :  it
//  Date :  2026-08-14
//  Time :  오후 12:35
//  Desc :  

package bitc.aws402.basic.controller;

import bitc.aws402.basic.service.BreadStoreService;
import bitc.aws402.basic.service.BreadStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AreaController {

//  스프링 프레임워크가 @Service 어노테이션을 사용한 클래스의 객체를 대신 객체로 생성함
//  @Autowired 어노테이션을 사용한 인터페이스 변수에 대신 의존성을 주입함
//  스프링 프레임워크가 모든 컴포넌트를 대신 제어함
  @Autowired
  private BreadStoreService breadStoreService;

//  GET 방식 접속 : 웹 브라우저의 주소창에 URL 입력하여 접속, html 태그의 a 태그를 통해서 링크 이동
//  단순 VIEW 페이지 출력
  @RequestMapping(value = "/area", method = RequestMethod.GET)
  public String area() {
    return "area/area";
  }

//  get 방식으로 접속하여 클라이언트에게 전달된 area.html 에서 서버로 데이터를 post 방식으로 전달
  @RequestMapping(value = "/area", method = RequestMethod.POST)
  public String area(@RequestParam("area") String area, Model model) {

//    복잡한 연산 진행, controller 의 메소드에서 직접 연산
    List<String> breadStoreList = new ArrayList<String>();

    switch (area) {
      case "서울":
        breadStoreList.add("김영모 과자점");
        breadStoreList.add("리치몬드 과자점");
        breadStoreList.add("태극당");
        breadStoreList.add("나폴레옹 과자점");
        break;

      case "대전":
        breadStoreList.add("성심당");
        breadStoreList.add("베이커리 하모니");
        breadStoreList.add("화이트리에");
        breadStoreList.add("더 베이커");
        break;

      case "부산":
        breadStoreList.add("옵스(OPS)");
        breadStoreList.add("베이크백");
        breadStoreList.add("허대빵");
        breadStoreList.add("초량온당");
        break;
    }

//    모델에 데이터 저장
    model.addAttribute("area", area);
    model.addAttribute("breadStoreList", breadStoreList);

//    템플릿을 클라이언트로 전달
    return "area/areaResult";
  }


  @GetMapping("area2")
  public String area2() {
    return "area/area2";
  }

  @PostMapping("area2")
  public String area2(@RequestParam(required = false, defaultValue = "부산", value = "area") String area, Model model) {

//    서비스객체를 직접 생성
//    BreadStoreService breadStoreService = new BreadStoreServiceImpl();

//    복잡한 연산이 발생되는 비즈니스 로직을 서비스 부분으로 넘김
//    컨트롤러의 메소드 내용은 간략해 짐
    List<String> breadStoreList = breadStoreService.getBreadStoreList(area);

    model.addAttribute("area", area);
    model.addAttribute("breadStoreList", breadStoreList);

    return "area/areaResult2";
  }
}











