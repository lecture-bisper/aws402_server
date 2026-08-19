//  File :  bitc.aws402.login.service.UserService.java
//  User :  it
//  Date :  2026-08-19
//  Time :  오후 12:08
//  Desc :  

package bitc.aws402.login.service;

import bitc.aws402.login.dto.UserDTO;

public interface UserService {

  int isLogin(String userId, String userPw);

  UserDTO selectUserInfo(String userId);
}











