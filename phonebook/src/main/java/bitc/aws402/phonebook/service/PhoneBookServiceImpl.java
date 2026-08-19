//  File :  PhoneBookServiceImpl.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오전 10:12
//  Desc :  

package bitc.aws402.phonebook.service;

import bitc.aws402.phonebook.dto.PhoneBookDTO;
import bitc.aws402.phonebook.mapper.PhoneBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

  private final PhoneBookMapper phoneBookMapper;

//  전화번호 목록
  @Override
  public List<PhoneBookDTO> selectPhoneBookList() {

//    1. mapper 를 이용하여 데이터베이스에서 목록 가져옴
    return phoneBookMapper.selectPhoneBookList();
  }

//  전화번호 등록
  @Override
  public void insertPhoneBook(PhoneBookDTO phonebook) {

    phoneBookMapper.insertPhoneBook(phonebook);
  }

  @Override
  public PhoneBookDTO selectPhoneBookDetail(int seq) {

    return phoneBookMapper.selectPhoneBookDetail(seq);
  }

  @Override
  public void updatePhoneBook(PhoneBookDTO phoneBook) {

    phoneBookMapper.updatePhoneBook(phoneBook);
  }

  @Override
  public void deletePhoneBook(int seq) {

    phoneBookMapper.deletePhoneBook(seq);
  }

}











