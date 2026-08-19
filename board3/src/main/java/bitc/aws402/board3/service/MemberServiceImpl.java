//  File :  MemberServiceImpl.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 4:20
//  Desc :  

package bitc.aws402.board3.service;

import bitc.aws402.board3.dto.MemberDTO;
import bitc.aws402.board3.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberMapper memberMapper;

  //  회원 가입 가능 여부
  public int isSignup(String memberId) {

    return memberMapper.isSignup(memberId);
  }

  @Override
  public boolean insertMember(MemberDTO member) {

    int result = isSignup(member.getMemberId());

    if (result == 0) {
      memberMapper.insertMember(member);
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public int isLogin(String userId, String userPw) {
    return memberMapper.isLogin(userId, userPw);
  }

  @Override
  public MemberDTO selectMember(String userId) {
    return memberMapper.selectMember(userId);
  }
}











