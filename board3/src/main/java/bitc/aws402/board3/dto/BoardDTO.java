//  File :  BoardDTO.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오전 9:17
//  Desc :  

package bitc.aws402.board3.dto;

import lombok.Data;

@Data
public class BoardDTO {

  private int boardIdx;
  private String title;
  private String contents;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
  private int hitCnt;
  private int likes;
}











