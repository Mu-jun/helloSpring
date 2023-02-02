package hello.helloSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.helloSpring.service.MemberService;

@Controller
public class MemberController {
  private final MemberService memberService;

  /**
   * 생성자에 @Autowired 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입한다.
   * 생성자가 1개만 있으면 @Autowired 는 생략할 수 있다.
   */
  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }  
}
