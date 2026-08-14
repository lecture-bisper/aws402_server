//  File :  BoardDTO.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 3:56
//  Desc :  

package bitc.aws402.board2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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











