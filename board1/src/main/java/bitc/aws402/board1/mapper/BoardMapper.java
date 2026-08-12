//  File :  bitc.aws402.board1.mapper.BoardMapper.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오후 4:26
//  Desc :  

package bitc.aws402.board1.mapper;

import bitc.aws402.board1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

  public List<BoardDTO> selectBoardList();
}











