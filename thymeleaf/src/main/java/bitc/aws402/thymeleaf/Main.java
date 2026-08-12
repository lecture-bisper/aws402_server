//  File :  Main.java
//  User :  it
//  Date :  2026-08-12
//  Time :  오전 9:27
//  Desc :  

package bitc.aws402.thymeleaf;

public class Main {

  public static void main(String[] args) {

    CoffeeMaker coffeeMaker = new CoffeeMaker();
    coffeeMaker.makeCoffee();
//    자식 클래스 타입인 DripCoffeeMachine 의 객체를 매개변수로 사용하여 의존성을 주입함
    coffeeMaker.setCoffeeMachine(new DripCoffeeMachine());
    coffeeMaker.makeCoffee();
//    자식 클래스 타입인 EspressoMachine 의 객체를 매개변수로 사용하여 의존성을 주입함
    coffeeMaker.setCoffeeMachine(new EspressoMachine());
    coffeeMaker.makeCoffee();
  }
}











