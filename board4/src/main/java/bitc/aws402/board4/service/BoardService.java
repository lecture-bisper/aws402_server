//  File :  bitc.aws402.board4.service.BoardService.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 3:01
//  Desc :  

package bitc.aws402.board4.service;

import bitc.aws402.board4.dto.BoardDTO;

import java.util.List;

public interface BoardService {

//  게시물 목록
  List<BoardDTO> selectBoardList();

//  게시물 상세
  BoardDTO selectBoardDetail(int boardIdx);

//  게시물 등록
  void insertBoard(BoardDTO board);

//  게시물 수정
  void updateBoard(BoardDTO board);

//  게시물 삭제
  void deleteBoard(int boardIdx);
}











