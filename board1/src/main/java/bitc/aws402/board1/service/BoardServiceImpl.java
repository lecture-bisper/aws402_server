//  File :  BoardServiceImpl.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오후 4:23
//  Desc :  

package bitc.aws402.board1.service;

import bitc.aws402.board1.dto.BoardDTO;
import bitc.aws402.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() {
    List<BoardDTO> boardList = boardMapper.selectBoardList();
    return boardList;
  }
}











