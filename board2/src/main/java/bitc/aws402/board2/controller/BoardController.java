//  File :  BoardController.java
//  User :  it
//  Date :  2026-08-13
//  Time :  오후 2:18
//  Desc :  

package bitc.aws402.board2.controller;

import bitc.aws402.board2.common.FileUtils;
import bitc.aws402.board2.dto.BoardDTO;
import bitc.aws402.board2.dto.FileDTO;
import bitc.aws402.board2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

//  요즘에는 @Autowired 보다 @RequiredArgsConstructor 를 사용하는 추세임
//  @Autowired 순환 참조가 발생할 가능성이 있어서 @RequiredArgsConstructor 로 변경됨
//  @Autowired
  private final BoardService boardService;
  private final FileUtils fileUtils;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  게시판 목록 페이지
  @RequestMapping("/board/boardList")
  public String selectBoardList(Model model) {

//    서비스를 이용하여 연산된 데이터 가져오기
    List<BoardDTO> boardList = boardService.selectBoardList();

//    가져온 데이터를 모델에 추가하여 View로 전달
    model.addAttribute("boardList", boardList);

//    사용자가 요청한 url 에 해당하는 view 파일 설정
    return "board/boardList";
  }

//  게시판 상세 보기 페이지
  @RequestMapping("/board/boardDetail")
  public String selectBoardDetail(@RequestParam("boardIdx") int boardIdx, Model model) {

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
//    첨부파일 목록 가져오기
    List<FileDTO> fileList = boardService.selectFileList(boardIdx);

    model.addAttribute("board", board);
//    가져온 첨부파일 목록 모델에 추가하기
    model.addAttribute("fileList", fileList);

    return "board/boardDetail";
  }

//  게시판 글 등록 페이지(단순 view 페이지)
  @RequestMapping(value = "/board/boardWrite", method = RequestMethod.GET)
  public String boardWrite() {

    return "board/boardWrite";
  }

//  첨부파일이 있을 경우 Multipart 타입으로 매개변수를 추가로 받음
//  게시판 글 등록 실행
  @RequestMapping("/board/insertBoard")
  public String insertBoard(
      @ModelAttribute BoardDTO board,
//      클라이언트에서 전달받은 첨부파일 형식 지정, 첨부파일은 MultipartFile 타입으로 전달받음
      @RequestParam(value = "files", required = false) List<MultipartFile> uploadFiles)
  {

//  첨부 파일 처리를 위해서 서비스로 Multipart 타입의 데이터를 전달
    boardService.insertBoard(board, uploadFiles);

//    리다이렉트 : 클라이언트의 요청에 서버가 응답 시 리다이렉트 명령으로 응답을 하면, 클라이언트는 서버가 지정한 주소로 다시 접속함
    return "redirect:/board/boardList";
  }

//  게시판 글 수정 실행
  @RequestMapping("/board/updateBoard")
  public String updateBoard(@ModelAttribute BoardDTO board) {

    boardService.updateBoard(board);

    return "redirect:/board/boardList";
  }

//  게시판 글 삭제 실행
  @RequestMapping("/board/deleteBoard")
  public String deleteBoard(@RequestParam("boardIdx") int boardIdx) {

    boardService.deleteBoard(boardIdx);

    return "redirect:/board/boardList";
  }

  @RequestMapping("/board/download")
  public ResponseEntity<Resource> download(@RequestParam("fileIdx") int fileIdx) throws MalformedURLException {

    FileDTO file = boardService.selectFileDetail(fileIdx);
    if (file == null) {
      return ResponseEntity.notFound().build();
    }

    Path filePath = fileUtils.resolve(file.getStoredFileName());
    Resource resource = new UrlResource(filePath.toUri());

    if (!resource.exists() || !resource.isReadable()) {
      return ResponseEntity.notFound().build();
    }

    String fileName = URLEncoder.encode(file.getOriginalFileName(), StandardCharsets.UTF_8).replace("+", "%20");

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"; filename*=UTF-8''" + fileName)
        .body(resource);
  }
}











