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

# 요약
- ```@AfterEach```
> ```@AfterEach```를 사용하면 각 테스트가
종료될 때 마다 이 기능을 실행한다.

- ```@BeforeEach```
> ```@BeforeEach```를 사용하면 각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 
의존관계도 새로 맺어준다

- ```@Autowired```
> 생성자에 ```@Autowired```가 있으면 스프링 부트(```@SpringBootApplication```)가 패키지 내에 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.

- ```@Component```
  - ```@Controller```
  - ```@Service```
  - ```@Repository```
> ```@Component``` 애노테이션이 있으면 스프링 빈으로 자동 등록된다.