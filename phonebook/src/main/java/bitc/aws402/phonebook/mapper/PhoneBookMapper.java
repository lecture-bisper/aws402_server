//  File :  bitc.aws402.phonebook.mapper.PhoneBookMapper.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오전 10:15
//  Desc :  

package bitc.aws402.phonebook.mapper;

import bitc.aws402.phonebook.dto.PhoneBookDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhoneBookMapper {

  List<PhoneBookDTO> selectPhoneBookList();

  void insertPhoneBook(PhoneBookDTO phonebook);

  PhoneBookDTO selectPhoneBookDetail(@Param("seq") int seq);

  void updatePhoneBook(PhoneBookDTO phoneBook);

  void deletePhoneBook(@Param("seq") int seq);
}











