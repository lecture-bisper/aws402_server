package bitc.aws402.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//  의존성 주입(DI) : Dependency Injection 의 줄임말, 특정 클래스를 사용하는데 필요한 의존성 클래스를 주입하여 사용하는 것, 스프링에서는 자바의 인터페이스를 사용하여 구현
//  제어의 역전(IoC) : Inversion of Control 의 줄임말, 의존성 주입을 사용자가 직접 진행하는 것이 아니라 스프링 프레임워크가 대신하는 것, xml 방식과 어노테이션 방식이 있으며 현재는 어노테이션 방식을 많이 사용함

//  스프링부트의 @SpringBootApplication 는 내부에 @ComponentScan 어노테이션이 포함되어 있어서 프로그램 시작 시 @Component 로 등록된 모든 컴포넌트를 검색하여 객체로 만들고 @Autowired 로 설정된 인터페이스 타입의 변수에 의존성 객체를 주입함

//  @Component : 스프링프레임워크에서 사용자가 직접 생성한 클래스를 스프링 프레임워크가 제어할 수 있도록 스프링 빈으로 만드는 어노테이션, 선언 시 스프링 프레임워크에서 사용할 객체의 이름을 직접 지정할 수 있음
//  @Autowired : 스프링 프레임워크에서 컴포넌트로 등록된 객체를 주입받는 대상으로 설정하는 어노테이션
//  @PostConstruct : 객체 생성 후(해당 클래스의 생성자 실행 후) 자동 실행할 메소드로 설정하는 어노테이션
//  @Primary : 특정 컴포넌트를 의존성 주입을 진행할 객체로 등록할 경우 동일한 대상에 대해서 2개 이상의 클래스가 의존성 주입의 대상이 될 경우 어떤 클래스를 우선 주입할 것인지 설정하는 어노테이션
//  @Qualifier : 등록된 컴포넌트의 이름을 사용하여 의존성 주입 클래스 객체로 사용하는 어노테이션

//@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class ThymeleafApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThymeleafApplication.class, args);
  }

}
