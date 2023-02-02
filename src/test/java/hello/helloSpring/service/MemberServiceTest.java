package hello.helloSpring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemoryMemberRepository;

public class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;

  /**
   * 아래 주석과 같은 구조로 클래스를 설계하면 memberService에서 참조하는 repository와 memberRepository가 같지
   * 않다.
   * DI를 사용하여 문제해결해야 함.
   */
  // MemberService memberService = new MemberService();
  // MemoryMemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * @BeforeEach : 각 테스트 실행 전에 호출된다.
   *             테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어준다.
   */
  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();

    // DI(Dependency Injection; 의존성 주입)를 해주어야 service가 같은 repository를 쓰게 됨.
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

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
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    // try {
    // memberService.join(member2);
    // fail();
    // } catch (IllegalStateException e) {
    // assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    // }

    // then
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
