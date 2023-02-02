package hello.helloSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
// import org.springframework.stereotype.Component;

// @Component
@Aspect
public class TimeTraceAop {

  /**
   * SpringConfig에 Bean으로 등록할 때는
   * TimeTraceAop의 AOP 대상을 지정하는 @Around 코드를 보면, SpringConfig의 timeTraceAop() 메서드도 AOP로 처리하게 된다.
   * 그런데 이게 바로 자기 자신인 TimeTraceAop를 생성하는 코드인 것이지요.
   * 그래서 순환참조 문제가 발생한다.
   * 
   * 반면에 컴포넌트 스캔(@Component)을 사용할 때는 AOP의 대상이 되는 이런 코드 자체가 없기 때문에 문제가 발생하지 않는다.
   * 
   * SpringConfig에 AOP를 등록하게되면 다른 사람이 프로젝트를 파악하기 쉬워진다.
   */
  @Around("execution(* hello.helloSpring..*(..)) && !target(hello.helloSpring.SpringConfig)") // 순환참조 해결법
  // @Around("execution(* hello.helloSpring..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("START: " + joinPoint.toString());
    try {
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
    }
  }
}