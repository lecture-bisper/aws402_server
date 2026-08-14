//  File :  BoardServiceImpl.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 4:28
//  Desc :  

package bitc.aws402.board2.service;

import bitc.aws402.board2.dto.BoardDTO;
import bitc.aws402.board2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//  @Service : 스프링프레임워크에 객체 제어 권한을 맡기는 어노테이션, @Component 와 같은 기능
//  컨트롤러에서 비즈니스 연산을 직접하는 것이 아닌 서비스 부분에서 대신 담당하도록 하기 위해서 사용

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

//  데이터베이스 연결 및 제어를 담당하는 인터페이스인 BoardMapper
  private final BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() {
//    BoardMapper 를 사용하여 데이터베이스 접속 후 필요한 정보를 조회함
    List<BoardDTO> boardList = boardMapper.selectBoardList();
    return boardList;
  }

//  게시물 등록
  @Override
  public void insertBoard(BoardDTO board) {
    boardMapper.insertBoard(board);
  }

//  게시물 상세보기
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) {

    return boardMapper.selectBoardDetail(boardIdx);
  }

//  게시물 수정
  public void updateBoard(BoardDTO board) {
    boardMapper.updateBoard(board);
  }

//  게시물 삭제
  @Override
  public void deleteBoard(int boardIdx) {
    boardMapper.deleteBoard(boardIdx);
  }
}











