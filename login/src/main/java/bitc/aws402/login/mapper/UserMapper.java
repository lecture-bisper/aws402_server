//  File :  UserMapper.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 12:07
//  Desc :  

package bitc.aws402.login.mapper;

import bitc.aws402.login.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  int isLogin(@Param("userId") String userId, @Param("userPw") String userPw);

  UserDTO selectUserInfo(@Param("userId") String userId);
}











