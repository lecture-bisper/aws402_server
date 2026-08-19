//  File :  bitc.aws402.board3.service.MemberService.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 4:19
//  Desc :  

package bitc.aws402.board3.service;

import bitc.aws402.board3.dto.MemberDTO;

public interface MemberService {

//  회원 가입
  boolean insertMember(MemberDTO memberDTO);

//  로그인 가능 여부
  int isLogin(String userId, String userPw);

//  회원 정보 가져오기
  MemberDTO selectMember(String userId);
}











