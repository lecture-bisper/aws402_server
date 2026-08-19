//  File :  bitc.aws402.board2.mapper.BoardMapper.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 3:53
//  Desc :  

package bitc.aws402.board2.mapper;

import bitc.aws402.board2.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//  @Mapper : Mybatis 에서 제공하는 어노테이션
//  xml 파일과 연동되어 실제 데이터베이스에 대한 연결 및 제어를 진행
//  서비스 계층에 데이터베이스에 사용 방법을 제공함

@Mapper
public interface BoardMapper {

//  게시글 목록
  List<BoardDTO> selectBoardList();

//  @Param : 1:1로 연동된 xml 파일의 태그에서 사용할 이름 설정
//  게시글 상세
  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx);

//  게시글 등록
  void insertBoard(BoardDTO board);

//  게시글 수정
  void updateBoard(BoardDTO board);

//  게시글 삭제
  void deleteBoard(@Param("boardIdx") int boardIdx);

//  게시글 조회수 증가
  void updateBoardHitCnt(@Param("boardIdx") int boardIdx);
}











