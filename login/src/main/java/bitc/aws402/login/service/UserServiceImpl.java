//  File :  UserServiceimpl.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 12:09
//  Desc :  

package bitc.aws402.login.service;

import bitc.aws402.login.dto.UserDTO;
import bitc.aws402.login.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  @Override
  public int isLogin(String userId, String userPw) {
    return userMapper.isLogin(userId, userPw);
  }

  @Override
  public UserDTO selectUserInfo(String userId) {
    return userMapper.selectUserInfo(userId);
  }
}











