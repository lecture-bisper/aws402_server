//  File :  bitc.aws402.board2.service.BoardService.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 4:27
//  Desc :  

package bitc.aws402.board2.service;

import bitc.aws402.board2.dto.BoardDTO;
import bitc.aws402.board2.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

  List<BoardDTO> selectBoardList();

  public void insertBoard(BoardDTO board, List<MultipartFile> uploadFiles);

//  게시물 상세 보기
  public BoardDTO selectBoardDetail(int boardIdx);

//  게시물 수정
  public void updateBoard(BoardDTO board);

//  게시물 삭제
  public void deleteBoard(int boardIdx);

  public List<FileDTO> selectFileList(int boardIdx);

  public FileDTO selectFileDetail(int fileIdx);
}











