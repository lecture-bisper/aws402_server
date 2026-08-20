//  File :  BoardMapper.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오전 9:25
//  Desc :  

package bitc.aws402.board3.mapper;

import bitc.aws402.board3.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

  List<BoardDTO> selectBoardList();

  void updateHitCnt(@Param("boardIdx") int boardIdx);

  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx);

  void insertBoard(BoardDTO board);

  void updateBoard(BoardDTO board);

  void deleteBoard(@Param("boardIdx") int boardIdx);
}











