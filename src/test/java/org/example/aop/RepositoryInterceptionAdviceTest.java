package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.example.data.profile.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for {@link RepositoryInterceptionAdvice}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class RepositoryInterceptionAdviceTest
{
  @Autowired
  private PersonRepository personRepository;

  /**
   * Tests that repository method calls are intercepted correctly.
   */
  @Test
  public void testInterception()
  {
    // Invoke a repository method.
    personRepository.findAllByFirstName(getClass().getName());

    final JoinPoint joinPoint = RepositoryInterceptionAdvice.pop();

    Assert.assertEquals("PersonRepository", joinPoint.getSignature().getDeclaringType().getSimpleName());
    Assert.assertEquals("findAllByFirstName", joinPoint.getSignature().getName());
  }
}
