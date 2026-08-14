//  File :  BreadStoreServiceImpl.java
//  User :  it
//  Date :  2026-08-14
//  Time :  오후 2:26
//  Desc :  

package bitc.aws402.basic.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreadStoreServiceImpl implements BreadStoreService {

  @Override
  public List<String> getBreadStoreList(String area) {

    List<String> breadStoreList = new ArrayList<String>();

    switch (area) {
      case "서울":
        breadStoreList.add("김영모 과자점");
        breadStoreList.add("리치몬드 과자점");
        breadStoreList.add("태극당");
        breadStoreList.add("나폴레옹 과자점");
        break;

      case "대전":
        breadStoreList.add("성심당");
        breadStoreList.add("베이커리 하모니");
        breadStoreList.add("화이트리에");
        breadStoreList.add("더 베이커");
        break;

      case "부산":
        breadStoreList.add("옵스(OPS)");
        breadStoreList.add("베이크백");
        breadStoreList.add("허대빵");
        breadStoreList.add("초량온당");
        break;
    }

    return breadStoreList;
  }
}











