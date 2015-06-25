package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Intercepts method calls on Spring Data JPA repository interfaces.
 */
@Aspect
@Component
public class RepositoryInterceptionAdvice
{
  private static final Queue<JoinPoint> INTERCEPTIONS = new LinkedList<>();

  /**
   * Intercepts method calls on Spring Data JPA repository interfaces
   * and queues information on the called methods to an internal
   * queue that can be polled from outside.
   *
   * @param joinPoint The joinpoint corresponding to the method call.
   */
  @Before("execution(* org.example.data.*Repository+.*(..))")
  public void intercept(final JoinPoint joinPoint)
  {
    INTERCEPTIONS.add(joinPoint);
  }

  /**
   * Pops the element at the top of the queue holding information on
   * called methods.
   *
   * @return The joinpoint corresponding to the most recent method call
   * intercepted by this advice.
   */
  public static JoinPoint pop()
  {
    return INTERCEPTIONS.poll();
  }
}
