package hello.helloSpring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.helloSpring.domain.Member;

public class MemorymemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  /**
   * "@AfterEach"를 사용하면 각 테스트가 종료될 때마다 이 기능을 실행한다.
   * 
   * 한 번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남는다.
   * 이렇게 되면 다음 테스트가 이전 테스트 때문에 실패할 가능성이 있다.
   * 여기서는 메모리 DB에 저장된 데이터를 삭제한다.
   * 
   * 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
   */
  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring1");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);
  }
}
