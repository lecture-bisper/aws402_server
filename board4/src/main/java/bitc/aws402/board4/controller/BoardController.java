//  File :  BoardController.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 2:05
//  Desc :  

package bitc.aws402.board4.controller;

import bitc.aws402.board4.dto.BoardDTO;
import bitc.aws402.board4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST 이란 ? URL을 리소스의 이름으로 구분하여 해당 리소스의 정보를 주고 받는 방식
//  HTTP URI 를 통해서 리소스를 명시하고, HTTP Method(GET, POST, PUT, DELETE) 를 통해 리소스에 대한 CRUD 명령을 적용하는 방식

//  URI : Uniform Resource Identifier 의 줄임말, 자원 식별자
//  URL : Uniform Resource Locator 의 줄임말, 자원의 위치
//  현재는 거의 동일한 의미로 사용됨

//  REST 방식은 데이터를 전송하는 방법을 지정하여 사용
//  HttpMethod 를 사용하여 GET(조회, select), POST(입력, insert), PUT(수정, update), DELETE(삭제, delete) 로 구분해서 사용함

//  전체 URL 설정 방법
//  서버URL:포트번호/기본주소/추가주소/게시물번호

//  게시물 목록        :   /board/list     =>    /board              GET
//  게시물 작성 화면   :   /board/write    =>    /board/write        GET
//  게시물 작성 처리   :   /board/insert   =>    /board/write        POST
//  게시물 상세 화면   :   /board/detail   =>    /board/게시물번호   GET
//  게시물 수정        :   /board/update   =>    /board/게시물번호   PUT
//  게시물 삭제        :   /board/delete   =>    /board/게시물번호   DELETE

//  @RequestMapping 어노테이션 사용 시 URI 를 value 속성을 사용하여 설정, method 속성을 사용하여 GET, POST, PUT, DELETE 를 설정
//  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 어노테이션을 따로 제공함

//  주의사항
//  Spring Framework 의 기본 설정 사용 시 GET, POST 만 사용 가능
//  application.properties 설정 파일에 spring.mvc.hiddenmethod.filter.enabled=true 를 추가하여 사용
//  Html 에서는 기본적으로 GET, POST 방식만 사용하기 때문에 PUT, DELETE 방식을 인식하기 위해서 input 태그에 type="hidden" 을 설정하고, name 속성에 name=_method 로 설정하여 데이터 전송 방식을 변경함


//@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

  private final BoardService boardService;

//  게시물 목록
  @GetMapping("/board")
  public String selectBoardList(Model model) {

    List<BoardDTO> boardList = boardService.selectBoardList();
    model.addAttribute("boardList", boardList);

    return "board/list";
  }

//  게시물 상세
  @GetMapping("/board/{boardIdx}")
  public String selectBoardDetail(@PathVariable("boardIdx") int boardIdx, Model model) {

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    model.addAttribute("board", board);

    return "board/detail";
  }

//  @GetMapping : 클라이언트에서 서버로 데이터 전송 시 데이터 전송 방식을 GET 으로 설정한 URL 만 접속하는 어노테이션
//  @RequestMapping(method = RequestMethod.GET) 과 동일한 방식
//  게시물 등록(view)
  @GetMapping("/board/write")
  public String insertBoard() {

    return "board/write";
  }

//  @PostMapping : 클라이언트에서 서버로 데이터 전송 시 데이터 전송 방식을 POST 로 설정한 URL 만 접속하는 어노테이션
//  @RequestMapping(method = RequestMethod.POST) 과 동일한 방식
//  게시물 등록(process)
  @PostMapping("/board/write")
  public String insertBoard(@ModelAttribute BoardDTO board) {

    boardService.insertBoard(board);

    return "redirect:/board";
  }

//  @PutMapping : 클라이언트에서 서버로 데이터 전송 시 데이터 전송 방식을 PUT 로 설정한 URL 만 접속하는 어노테이션
//  @RequestMapping(method = RequestMethod.PUT) 과 동일한 방식
//  게시물 수정
  @PutMapping("/board/{boardIdx}")
  public String updateBoard(@PathVariable("boardIdx") int boardIdx, @ModelAttribute BoardDTO board) {

    board.setBoardIdx(boardIdx);
    boardService.updateBoard(board);

    return "redirect:/board";
  }

//  @DeleteMapping : 클라이언트에서 서버로 데이터 전송 시 데이터 전송 방식을 DELETE 로 설정한 URL 만 접속하는 어노테이션
//  @RequestMapping(method = RequestMethod.DELETE) 과 동일한 방식
//  @PathVariable : @RequestParam 과 동일한 역할을 하는 어노테이션, REST 방식 사용 시 URI 에 {} 로 지정한 리소스 값을 받아오는 어노테이션
//  게시물 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) {

    boardService.deleteBoard(boardIdx);

    return "redirect:/board";
  }
}











