//  File :  BoardDTO.java
//  User :  it
//  Date :  2026-08-20
//  Time :  오후 2:58
//  Desc :  

package bitc.aws402.board4.dto;

import lombok.Data;

@Data
public class BoardDTO {

  private int boardIdx;
  private String boardTitle;
  private String boardContents;
  private String boardCreateId;
  private String boardCreateDate;
  private String boardUpdateId;
  private String boardUpdateDate;
  private int boardHitCnt;
}











