//  File :  bitc.aws402.board3.mapper.MemberMapper.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 4:20
//  Desc :  

package bitc.aws402.board3.mapper;

import bitc.aws402.board3.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

  int isSignup(@Param("memberId") String memberId);

  void insertMember(MemberDTO member);

  int isLogin(@Param("memberId") String memberId, @Param("memberPw") String memberPw);

  MemberDTO selectMember(@Param("memberId") String memberId);
}











