package hello.helloSpring;

import javax.persistence.EntityManager;
// import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import hello.helloSpring.repository.JdbcTemplateMemberRepository;
import hello.helloSpring.repository.JpaMemberRepository;
import hello.helloSpring.repository.MemberRepository;
// import hello.helloSpring.repository.MemoryMemberRepository;
import hello.helloSpring.service.MemberService;

@Configuration
public class SpringConfig {

  // private final DataSource dataSource;

  // public SpringConfig(DataSource dataSource) {
  // this.dataSource = dataSource;
  // }

  private EntityManager em;

  public SpringConfig(EntityManager em) {
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    // return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }
}
