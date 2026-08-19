//  File :  BoardController.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 2:31
//  Desc :  

package bitc.aws402.board3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

//  게시글 목록
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list() {
    return "board/list";
  }

//  게시글 상세

//  게시글 등록(view)

//  게시글 등록(process)

//  게시글 수정

//  게시글 삭제
}











