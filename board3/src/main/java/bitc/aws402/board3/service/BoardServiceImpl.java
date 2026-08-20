//  File :  BoardServiceImpl.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오전 9:23
//  Desc :  

package bitc.aws402.board3.service;

import bitc.aws402.board3.dto.BoardDTO;
import bitc.aws402.board3.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() {
    return boardMapper.selectBoardList();
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) {
    boardMapper.updateHitCnt(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

  @Override
  public void insertBoard(BoardDTO board) {
    boardMapper.insertBoard(board);
  }

  @Override
  public void updateBoard(int boardIdx, String title, String contents, String memberId) {

    BoardDTO board = new BoardDTO();
    board.setBoardIdx(boardIdx);
    board.setTitle(title);
    board.setContents(contents);
    board.setUpdateId(memberId);

    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) {
    boardMapper.deleteBoard(boardIdx);
  }
}











