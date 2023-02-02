package hello.helloSpring;

// import javax.persistence.EntityManager;
// import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import hello.helloSpring.repository.JdbcTemplateMemberRepository;
// import hello.helloSpring.repository.JpaMemberRepository;
import hello.helloSpring.repository.MemberRepository;
// import hello.helloSpring.repository.MemoryMemberRepository;
import hello.helloSpring.service.MemberService;

@Configuration
public class SpringConfig {

  // // Jdbc
  // private final DataSource dataSource;

  // public SpringConfig(DataSource dataSource) {
  // this.dataSource = dataSource;
  // }

  // // JPA
  // private EntityManager em;

  // public SpringConfig(EntityManager em) {
  // this.em = em;
  // }

  // Spring JPA
  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    // return new MemberService(memberRepository());
    return new MemberService(memberRepository);
  }

  // @Bean
  // public MemberRepository memberRepository() {
  //   // return new MemoryMemberRepository();
  //   // return new JdbcTemplateMemberRepository(dataSource);
  //   // return new JpaMemberRepository(em);
  // }
}
