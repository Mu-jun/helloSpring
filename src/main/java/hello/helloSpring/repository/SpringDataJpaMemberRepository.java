package hello.helloSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.helloSpring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

  /* 스프링 JPA 메서드 명명 규칙에 따라 메서드를 만들면
   * 스프링 JPA가 알아서 메서드 이름만으로 조회 기능을 제공한다.
   * findByNameAndId(String name, Long id) -> namer과 id로 조회
   * findByNameOrId -> namer 또는 id로 조회
   * 
   * 프록시 기술을 이용하여 만들어짐
   */
  Optional<Member> findByName(String name);
}
