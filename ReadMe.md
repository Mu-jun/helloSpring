# 목표
- 인프런 김영한님의 스프링 입문 강의를 보며 스프링을 익힌다.
- 출처 : https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard

# 개발환경
- OS : Windows 10
- IDE : VSCode
  - Extention
    - Extension Pack for java
    - Gradle for java
    - Generator Junit File : 테스트파일 생성 도구
    - Colonize : 세미콜론 자동 추가 줄넘김 도구

## start.spring.io
- Language : java 11
- Build tool : Gradle - Groovy
- Packaging : Jar
- Framwork : Spring Boot 2.7.8
- Dependencies
  - Spring Web
  - Thymeleaf

<br>

# 빌드하고 실행
- cmd> gradlew build
- cmd> java -jar ./build/src/hello-spring-0.0.1-SNAPSHOT.jar
> 이전 빌드때문에 현재 빌드에 문제가 생긴다면 ```gradlew clean ```을 하면 이전 빌드가 삭제된다.
```gradlew clean build```를 하면 자동으로 이전 빌드를 지우고 새로 빌드하게 된다.

<br>

# 가상의 비즈니스 요구사항
- 데이터: 회원ID, 이름
- 기능: 회원 등록, 조회
- 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)

<br>

# 애노테이션 기능 요약
- ```@AfterEach```
> ```@AfterEach```를 사용하면 각 테스트가
종료될 때 마다 이 기능을 실행한다.

- ```@BeforeEach```
> ```@BeforeEach```를 사용하면 각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 
의존관계도 새로 맺어준다

- ```@Autowired```
> 생성자에 ```@Autowired```가 있으면 스프링 부트(```@SpringBootApplication```)가 패키지 내에 연관된 객체(Bean 등록 객체)를 스프링 컨테이너에서 찾아서 넣어준다.

- ```@Component```
  - ```@Controller```
  - ```@Service```
  - ```@Repository```
> ```@Component``` 애노테이션이 있으면 스프링 빈으로 자동 등록된다.

- 자바 코드로 직접 스프링 빈 등록
> 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록하는 게 좋다.

- ```@SpringBootTest``` : 스프링 컨테이너와 테스트를 함께 실행한다.
- ```@Transactional``` : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 
테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지
않는다.
  - 실제 프로덕션에서 이 애노테이션이 있으면 커밋하여 DB에 데이터가 저장된다.

<br>

# 이후 공부방향
- 스프링의 핵심원리를 이해하고, 문제가 발생했을 때 대략 어디쯤부터 찾아들어가면 될지, 필요한 부분을 찾아서 사용할 수 있도록 한다.
- 실무 트렌드를 알아 볼 것.

## 스프링 핵심 기술
- 기능보다 스프링 컨테이너가 **왜 나왔고 왜 쓰느냐?**

## 스프링 웹 MVC
- 웹 MVC 메커니즘(서블릿 기반 기술)
- 필터, 인터셉터
- 실무에서의 예외처리

## ***스프링 DB 접근 기술***
- 트랜잭션, 예외처리
- 스프링 추상화해 놓은 예외
- DB 커넥션, 풀

## 스프링 부트
- 기본 메커니즘
- 실무에서 필요한 모니터링, 프로파일
- 스프링을 편하게 사용하기 위한 기술로 실무 위주로 공부할 것