//  File :  FileDTO.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오후 3:25
//  Desc :  

package bitc.aws402.board2.dto;

import lombok.Data;

@Data
public class FileDTO {

//  파일 번호
  private int fileIdx;
//  게시글 번호
  private int boardIdx;
//  원본 파일명
  private String originalFileName;
//  서버의 디스크에 저장된 파일명
  private String storedFileName;
//  원본 파일의 크기
  private int fileSize;
}











