//  File :  bitc.aws402.board2.mapper.FileMapper.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오후 3:29
//  Desc :  

package bitc.aws402.board2.mapper;

import bitc.aws402.board2.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {

//  첨부파일 등록
  void insertFile(FileDTO file);

//  첨부파일 목록
  List<FileDTO> selectFileList(@Param("boardIdx") int boardIdx);

//  첨부파일 상세 정보
  FileDTO selectFileDetail(@Param("fileIdx") int fileIdx);
}











