//  File :  BoardController.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오후 4:12
//  Desc :  

package bitc.aws402.board1.controller;

import bitc.aws402.board1.dto.BoardDTO;
import bitc.aws402.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/boardList")
  public ModelAndView boardList() {

    ModelAndView mav = new ModelAndView("boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mav.addObject("boardList", boardList);

    return mav;
  }
}











