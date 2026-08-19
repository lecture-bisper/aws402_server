//  File :  bitc.aws402.phonebook.service.PhoneBookService.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오전 10:11
//  Desc :  

package bitc.aws402.phonebook.service;

import bitc.aws402.phonebook.dto.PhoneBookDTO;

import java.util.List;

public interface PhoneBookService {

  List<PhoneBookDTO> selectPhoneBookList();

  void insertPhoneBook(PhoneBookDTO phoneBook);

  PhoneBookDTO selectPhoneBookDetail(int seq);

  void updatePhoneBook(PhoneBookDTO phoneBook);

  void deletePhoneBook(int seq);
}











