//  File :  BoardServiceImpl.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 4:28
//  Desc :  

package bitc.aws402.board2.service;

import bitc.aws402.board2.common.FileUtils;
import bitc.aws402.board2.dto.BoardDTO;
import bitc.aws402.board2.dto.FileDTO;
import bitc.aws402.board2.mapper.BoardMapper;
import bitc.aws402.board2.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//  @Service : 스프링프레임워크에 객체 제어 권한을 맡기는 어노테이션, @Component 와 같은 기능
//  컨트롤러에서 비즈니스 연산을 직접하는 것이 아닌 서비스 부분에서 대신 담당하도록 하기 위해서 사용

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

//  데이터베이스 연결 및 제어를 담당하는 인터페이스인 BoardMapper
  private final BoardMapper boardMapper;
//  데이터베이스에 첨부 파일 정보 등록을 담당하는 인터페이스인 FileMapper
  private final FileMapper fileMapper;
//  첨부파일 관련 유틸리티 클래스
  private final FileUtils fileUtils;

  @Override
  public List<BoardDTO> selectBoardList() {
//    BoardMapper 를 사용하여 데이터베이스 접속 후 필요한 정보를 조회함
    List<BoardDTO> boardList = boardMapper.selectBoardList();
    return boardList;
  }

//  첨부파일이 있을 경우 Multipart 타입으로 매개변수를 추가로 받음
//  게시물 등록
  @Override
  public void insertBoard(BoardDTO board, List<MultipartFile> uploadFiles) {

    boardMapper.insertBoard(board);

//    첨부 파일이 있을 경우
    if (uploadFiles != null) {
//      첨부된 파일의 수 만큼 반복 실행
      for (MultipartFile file : uploadFiles) {
        if (file.isEmpty()) {
          continue;
        }

        try {
//          원본 파일 이름 가져오기
          String storedFileName = fileUtils.store(file.getInputStream(), file.getOriginalFilename());

//          file 테이블에 저장하기 위한 FileDTO 타입의 객체 생성
          FileDTO uploadFile = new FileDTO();
//          업로드된 파일 정보를 FileDTO 타입의 객체에 저장
          uploadFile.setBoardIdx(board.getBoardIdx());
          uploadFile.setOriginalFileName(fileUtils.sanitizeFileName(file.getOriginalFilename()));
          uploadFile.setStoredFileName(storedFileName);
          uploadFile.setFileSize((int) file.getSize());

//          mapper 를 사용하여 file 테이블에 저장
          fileMapper.insertFile(uploadFile);
        }
        catch (IOException e) {
          throw new RuntimeException("파일 업로드 실패", e);
        }
      }
    }
  }

//  게시물 상세보기
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) {

//    게시글 조회수 증가 부분 추가
    boardMapper.updateBoardHitCnt(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

//  게시물 수정
  public void updateBoard(BoardDTO board) {
    boardMapper.updateBoard(board);
  }

//  게시물 삭제
  @Override
  public void deleteBoard(int boardIdx) {
    boardMapper.deleteBoard(boardIdx);
  }

  @Override
  public List<FileDTO> selectFileList(int boardIdx) {

    return fileMapper.selectFileList(boardIdx);
  }

  @Override
  public FileDTO selectFileDetail(int fileIdx) {

    return fileMapper.selectFileDetail(fileIdx);
  }
}











