//  File :  bitc.aws402.board3.service.BoardService.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오전 9:23
//  Desc :  

package bitc.aws402.board3.service;

import bitc.aws402.board3.dto.BoardDTO;

import java.util.List;

public interface BoardService {

  List<BoardDTO> selectBoardList();

  BoardDTO selectBoardDetail(int boardIdx);

  void insertBoard(BoardDTO board);

  void updateBoard(int boardIdx, String title, String contents, String memberId);

  void deleteBoard(int boardIdx);
}











