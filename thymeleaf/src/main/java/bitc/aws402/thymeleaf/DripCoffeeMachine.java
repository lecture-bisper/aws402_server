//  File :  DripCoffeeMachine.java
//  User :  it
//  Date :  2026-08-12
//  Time :  오전 9:33
//  Desc :  

package bitc.aws402.thymeleaf;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//  CoffeeMachine 인터페이스를 상속받아 구현한 DripCoffeeMachine 클래스
@Component("dripCoffeeMachine")
public class DripCoffeeMachine implements CoffeeMachine {

//  상속받아 오버라이딩한 brew() 메소드
  @Override
  public String brew() {
    return "Brewing coffee with Drip Coffee Machine";
  }
}











