//  File :  bitc.aws402.board4.mapper.BoardMapper.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 3:02
//  Desc :  

package bitc.aws402.board4.mapper;

import bitc.aws402.board4.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

//  게시물 목록
  List<BoardDTO> selectBoardList();

//  게시물 상세
  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx);

//  게시물 조회수 증가
  void updateHitCnt(@Param("boardIdx") int boardIdx);

//  게시물 등록
  void insertBoard(BoardDTO board);

//  게시물 수정
  void updateBoard(BoardDTO board);

//  게시물 삭제
  void deleteBoard(@Param("boardIdx") int boardIdx);
}











