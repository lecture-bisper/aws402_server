//  File :  BoardController.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 2:31
//  Desc :  

package bitc.aws402.board3.controller;

import bitc.aws402.board3.dto.BoardDTO;
import bitc.aws402.board3.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

  private final BoardService boardService;

//  게시글 목록
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {

    List<BoardDTO> boardList = boardService.selectBoardList();
    model.addAttribute("boardList", boardList);

    return "board/list";
  }

//  게시글 상세
  @RequestMapping(value = "/detail", method = RequestMethod.GET)
  public String detail(@RequestParam("boardIdx") int boardIdx, Model model) {

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    model.addAttribute("board", board);

    return "board/detail";
  }

//  게시글 등록(view)
  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public String write(HttpSession session, Model model) {

    if (session.getAttribute("userId") == null) {
      return alert("로그인이 필요한 서비스입니다", "/auth/signin", model);
    }

    return "board/write";
  }

//  게시글 등록(process)
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public String write(@ModelAttribute BoardDTO board, HttpSession session) {

    board.setCreateId(session.getAttribute("userId").toString());
    boardService.insertBoard(board);

    return "redirect:/board/list";
  }

//  게시글 수정
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(
      @RequestParam("boardIdx") int boardIdx,
      @RequestParam("title") String title,
      @RequestParam("contents") String contents,
      HttpSession session
  ) {

    String memberId = (String) session.getAttribute("userId");
    boardService.updateBoard(boardIdx, title, contents, memberId);

    return "redirect:/board/list";
  }

//  게시글 삭제
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(@RequestParam("boardIdx") int boardIdx) {

    boardService.deleteBoard(boardIdx);

    return "redirect:/board/list";
  }

//  화면에 자바스크립트의 alert 창을 출력
  private String alert(String msg, String url, Model model) {

    model.addAttribute("msg", msg);
    model.addAttribute("url", url);

    return "common/alert";
  }
}











