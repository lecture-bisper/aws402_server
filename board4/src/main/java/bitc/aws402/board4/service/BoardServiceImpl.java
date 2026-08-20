//  File :  BoardServiceImpl.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 3:01
//  Desc :  

package bitc.aws402.board4.service;

import bitc.aws402.board4.dto.BoardDTO;
import bitc.aws402.board4.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;

//  게시물 목록
  @Override
  public List<BoardDTO> selectBoardList() {
    return boardMapper.selectBoardList();
  }

//  게시물 상세
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) {
    boardMapper.updateHitCnt(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

  //  게시물 등록
  @Override
  public void insertBoard(BoardDTO board) {

    boardMapper.insertBoard(board);
  }

  //  게시물 수정
  @Override
  public void updateBoard(BoardDTO board) {

    boardMapper.updateBoard(board);
  }


//  게시물 삭제
  @Override
  public void deleteBoard(int boardIdx) {

    boardMapper.deleteBoard(boardIdx);
  }
}











