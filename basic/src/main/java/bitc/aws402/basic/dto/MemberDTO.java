//  File :  MemberDTO.java
//  User :  it
//  Date :  2026-08-14
//  Time :  오전 10:48
//  Desc :  

package bitc.aws402.basic.dto;

//  DTO : Data Transfer Object 의 줄임말, 데이터 전송용 객체, VO(Value Object) 라고 불리기도 함, 데이터베이스의 데이터 타입과 자바의 데이터 타입이 일치하지 않기 때문에 데이터베이스의 데이터를 자바로 가져올 경우 자바 클래스를 통해서 데이터 타입을 맞춰주기 위해서 사용, 클라이언트 - 서버 관계에서 데이터를 전송 시 여러개의 데이터를 따로 전송하는 것이 아니라 DTO 를 통해서 한번에 여러가지의 데이터를 전송하기 위해서 사용
//  DAO : Data Access Object 의 줄임말, 데이터베이스에 접속하여 데이터를 컨트롤하기 위한 객체, 데이터베이스 접속 메소드 및 조회, 수정, 삭제, 삽입 에 대한 메소드를 등록하여 사용하는 클래스
//  스프링프레임워크에서는 주로 Mybatis 나 JPA 를 사용함

//  Lombok : 자바 프로젝트 시 거의 필수로 사용되는 라이브러리, DTO 클래스의 Getter/Setter 메소드를 자동으로 생성해주는 라이브러리
//  @Data : 롬복 라이브러리에서 제공하는 어노테이션, Getter/Setter/toString 메소드를 자동으로 생성하는 어노테이션
//  @Getter : 롬복 라이브러리에서 제공하는 Getter 메소드를 자동 생성하는 어노테이션
//  @Setter : 롬복 라이브러리에서 제공하는 Setter 메소드를 자동 생성하는 어노테이션
//  @NoArgsConstructor : 매개변수가 없는 기본 생성자를 자동으로 생성하는 어노테이션
//  @AllArgsConstructor : 해당 클래스의 모든 필드(멤버 변수)에 대한 매개변수가 있는 생성자를 자동 생성하는 어노테이션
//  @RequiredArgsConstructor : 의존성 주입을 위해서 사용하는 @Autiwired 대신 사용하는 어노테이션
//    현재 스프링 웹 프로젝트에서는 @Autowired 보다 @RequiredArgsConstructor 사용을 권장함
//  @Builder : 클래스의 객체 생성 시 빌더 패턴을 사용할 수 있도록 하는 어노테이션

import lombok.Data;

@Data
public class MemberDTO {

  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String userPhone;
  private String userAddr;

}











