package org.example.data.profile;

import org.example.data.DataTest;
import org.example.domain.profile.RoleEnum;
import org.example.domain.profile.User;
import org.example.domain.profile.UserRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserRepositoryTest extends DataTest
{
  @Autowired
  private UserRepository     userRepository;
  @Autowired
  private UserRoleRepository userRoleRepository;

  @Before
  public void setup()
  {
    Arrays.asList(RoleEnum.values()).forEach(role -> userRoleRepository.saveAndFlush(new UserRole(role)));

    final User john = new User("john");
    john.addRole(userRoleRepository.findByName(RoleEnum.ADMIN));

    userRepository.saveAndFlush(john);
  }

  @Test
  public void testFindAll()
  {
    Assert.assertFalse(userRepository.findAll().isEmpty());
  }
}
