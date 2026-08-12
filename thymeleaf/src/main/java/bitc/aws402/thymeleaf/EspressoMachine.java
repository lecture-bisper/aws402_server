//  File :  Espressomachine.java
//  User :  it
//  Date :  2026-08-12
//  Time :  오전 9:24
//  Desc :  

package bitc.aws402.thymeleaf;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//  CoffeeMachine 인터페이스를 상속받아 구현한 EspressoMachine 클래스
@Primary
@Component
public class EspressoMachine implements CoffeeMachine {

//  상속받은 추상메소드를 오버라이딩함
  @Override
  public String brew() {
    return "Brewing coffee with Espresso Machine";
  }
}











