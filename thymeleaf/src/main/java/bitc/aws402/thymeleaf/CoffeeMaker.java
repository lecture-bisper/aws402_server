//  File :  CoffeeMaker.java
//  User :  it
//  Date :  2026-08-12
//  Time :  오전 9:24
//  Desc :  

package bitc.aws402.thymeleaf;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMaker {

//  EspressoMachine 클래스에 종속적임
//  private EspressoMachine espressoMachine;
//
//  public CoffeeMaker() {
//    this.espressoMachine = new EspressoMachine();
//  }
//
//  public void makeCoffee() {
//    System.out.println(espressoMachine.brew());
//  }


//  Drip 커피를 마시고 싶을 경우 CoffeeMaker 의 내용을 모두 변경해야 함
//  이러한 형태를 단단한 결합이라고 함
//  private DripCoffeeMachine dripCoffeeMachine;
//
//  public CoffeeMaker() {
//    this.dripCoffeeMachine = new DripCoffeeMachine();
//  }
//
//  public void makeCoffee() {
//    System.out.println(dripCoffeeMachine.brew());
//  }


//  이러한 형태로 구성된 것을 느슨한 결합이라고 함
//  이러한 느슨한 결합을 이용하여 필요 시 의존성이 있는 클래스의 객체를 외부에서 생성하여 주입하는 것을 '의존성 주입' 이라고 함
//  CoffeeMaker 의 멤버변수로 CoffeeMachine 인터페이스 타입의 변수를 사용
  @Qualifier("dripCoffeeMachine")
  @Autowired
  private CoffeeMachine coffeeMachine;

  public CoffeeMaker() {
//    기본값으로 EspressoMachine의 객체를 사용
    this.coffeeMachine = new EspressoMachine();
  }

//  언제든지 자식 객체의 타입을 변경할 수 있도록 setter 제공
  public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
    this.coffeeMachine = coffeeMachine;
  }

  @PostConstruct
  public void makeCoffee() {
    System.out.println(coffeeMachine.brew());
  }
}











