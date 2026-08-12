package bitc.aws402.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  @SpringBootApplication : 스프링부트의 핵심 어노테이션, 현재 프로젝트가 스프링부트 프로젝트임을 알려주는 어노테이션, @EnableAutoConfiguration, @ComponentScan, @Configuration 어노테이션이 합쳐진 것
//  @EnableAutoConfiguration : 스프링의 다양한 설정을 자동으로 진행
//  @ComponentScan : 사용자가 입력한 빈 클래스를 자동으로 검색하여 프로젝트에 등록
//  @Configuration : 해당 클래스가 설정 파일임을 알려주는 어노테이션
@SpringBootApplication
public class Test2Application {

  public static void main(String[] args) {
//    SpringApplication.run() : 스프링부트 웹 어플리케이션을 동작시킴
    SpringApplication.run(Test2Application.class, args);
  }

}
