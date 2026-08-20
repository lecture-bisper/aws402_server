//  File :  BoardApiController.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 4:54
//  Desc :  

package bitc.aws402.board4.controller;

import bitc.aws402.board4.dto.BoardDTO;
import bitc.aws402.board4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  REST API : REST 방식과 동일한 형태로 HTTP 프로토콜을 사용하지만, 클라이언트로 전달하는 데이터가 View를 제외한 순수 데이터만 전달하는 방식
//  예전에는 클라이언트가 컴퓨터 밖에 없었기 때문에 웹 브라우저 혹은 전용 프로그램이 클라이언트의 기능을 모두 담당함
//  서버의 기능 중 웹 서버의 기능만 주로 사용되어 클라이언트로 전달되는 데이터가 View 와 Model 이 모두 필요했음
//  현재는 클라이언트가 다양한 디바이스로 동작하기 때문에 View 부분이 반드시 웹 브라우저일 필요가 없기 때문에 데이터만 전달하는 방식으로 변경되었음

//  @RestController : @Controller + @ResponseBody 어노테이션이 하나로 합쳐진 어노테이션
//  @Controller 의 기능인 지정한 클래스가 Controller 임을 클라이언트에서 접속하는 URL 과 메소드를 연결하는 기능과 @ResponseBody 의 기능인 클라이언트에게 View 없이 데이터만 전달하는 기능이 합쳐진 어노테이션
//  @Controller 어노테이션을 사용하고, @ResponseBody 어노테이션을 따로 사용해도 @RestController 와 동일한 효과
//  안드로이드 나 리액트 사용 시 프론트엔드 부분과 백엔 부분이 완전히 분리되는 형태이기 때문에 데이터만 주고 받기 위해서 REST API 방식을 사용함

@RequiredArgsConstructor
@RestController
public class BoardApiController {

  private final BoardService boardService;

//  게시판 목록
  @GetMapping("/api/board")
  public Object selectBoardList() {

    List<BoardDTO> boardList = boardService.selectBoardList();

    return boardList;
  }

//  게시판 상세
  @GetMapping("/api/board/{boardIdx}")
  public Object selectBoardDetail(@PathVariable("boardIdx") int boardIdx) {

    BoardDTO board = boardService.selectBoardDetail(boardIdx);

    return board;
  }

//  게시판 글 등록
  @PostMapping("/api/board/write")
  public void insertBoard(@RequestBody BoardDTO board) {

    boardService.insertBoard(board);
  }

//  게시판 글 수정
  @PutMapping("/api/board/{boardIdx}")
  public void updateBoard(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardDTO board) {

    board.setBoardIdx(boardIdx);
    boardService.updateBoard(board);
  }

//  게시판 글 삭제
  @DeleteMapping("/api/board/{boardIdx}")
  public void deleteBoard(@PathVariable("boardIdx") int boardIdx) {

    boardService.deleteBoard(boardIdx);
  }
}











