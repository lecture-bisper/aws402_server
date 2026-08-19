//  File :  PhonebookController.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오전 9:21
//  Desc :  

package bitc.aws402.phonebook.controller;

import bitc.aws402.phonebook.dto.PhoneBookDTO;
import bitc.aws402.phonebook.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/phonebook")
@Controller
public class PhoneBookController {

  private final PhoneBookService phoneBookService;

//  전화번호 목록 페이지
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {

//    1. 서비스를 이용해서 전화번호 목록 가져오기
    List<PhoneBookDTO> phoneBookList = phoneBookService.selectPhoneBookList();
//    2. 가져온 목록을 model 에 저장
    model.addAttribute("phoneBookList", phoneBookList);

//    3. view 페이지와 연동
    return "phonebook/list";
  }

//  전화번호 등록 페이지(단순 뷰)
  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public String write() {
    return "phonebook/write";
  }

//  전화번호 등록 페이지(프로세스)
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public String insert(@ModelAttribute PhoneBookDTO phonebook) {

    phoneBookService.insertPhoneBook(phonebook);
    return "redirect:/phonebook/list";
  }

//  전화번호 상세 페이지
  @RequestMapping(value = "/detail", method = RequestMethod.GET)
  public String detail(@RequestParam("seq") int seq, Model model) {

    PhoneBookDTO phoneBook = phoneBookService.selectPhoneBookDetail(seq);
    model.addAttribute("phoneBook", phoneBook);

    return "phonebook/detail";
  }

//  전화번호 수정
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@ModelAttribute PhoneBookDTO phonebook) {

    phoneBookService.updatePhoneBook(phonebook);
    return "redirect:/phonebook/list";
  }

//  전화번호 삭제
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(@RequestParam("seq") int seq) {

    phoneBookService.deletePhoneBook(seq);
    return "redirect:/phonebook/list";
  }

}











