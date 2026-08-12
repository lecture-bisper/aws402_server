//  File :  BoardDTO.java
//  User :  it
//  Date :  2026-08-07
//  Time :  오후 4:17
//  Desc :  

package bitc.aws402.board1.dto;

import lombok.Data;

//@Data
public class BoardDTO {

  private int boardIdx;
  private String boardTitle;
  private String boardContents;
  private String boardCreateId;
  private String boardCreateDate;
  private String boardUpdateId;
  private String boardUpdateDate;
  private int boardHitCnt;
  private String deletedYn;

  public int getBoardIdx() {
    return boardIdx;
  }

  public void setBoardIdx(int boardIdx) {
    this.boardIdx = boardIdx;
  }

  public String getBoardTitle() {
    return boardTitle;
  }

  public void setBoardTitle(String boardTitle) {
    this.boardTitle = boardTitle;
  }

  public String getBoardContents() {
    return boardContents;
  }

  public void setBoardContents(String boardContents) {
    this.boardContents = boardContents;
  }

  public String getBoardCreateId() {
    return boardCreateId;
  }

  public void setBoardCreateId(String boardCreateId) {
    this.boardCreateId = boardCreateId;
  }

  public String getBoardCreateDate() {
    return boardCreateDate;
  }

  public void setBoardCreateDate(String boardCreateDate) {
    this.boardCreateDate = boardCreateDate;
  }

  public String getBoardUpdateId() {
    return boardUpdateId;
  }

  public void setBoardUpdateId(String boardUpdateId) {
    this.boardUpdateId = boardUpdateId;
  }

  public String getBoardUpdateDate() {
    return boardUpdateDate;
  }

  public void setBoardUpdateDate(String boardUpdateDate) {
    this.boardUpdateDate = boardUpdateDate;
  }

  public int getBoardHitCnt() {
    return boardHitCnt;
  }

  public void setBoardHitCnt(int boardHitCnt) {
    this.boardHitCnt = boardHitCnt;
  }

  public String getDeletedYn() {
    return deletedYn;
  }

  public void setDeletedYn(String deletedYn) {
    this.deletedYn = deletedYn;
  }
}











