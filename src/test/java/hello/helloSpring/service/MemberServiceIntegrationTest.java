package hello.helloSpring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void 회원가입() {
    // given
    Member member = new Member();
    member.setName("hello");

    // when
    Long saveId = memberService.join(member);

    
    // then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    // given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    // when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    // then
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }

  @Test
  void 전체_회원_조회() {
    // given
    Member member1 = new Member();
    member1.setName("spring1");
    memberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("spring1");
    memberRepository.save(member2);

    // when
    List<Member> findMembers = memberService.findMembers();

    // then
    assertThat(findMembers.size()).isEqualTo(2);
  }

  @Test
  void 회원_1명_조회() {
    // given
    Member member = new Member();
    member.setName("spring");
    memberRepository.save(member);

    // when
    Member findMember = memberService.findOne(member.getId()).get();

    // then
    assertThat(member.getId()).isEqualTo(findMember.getId());
  }
}