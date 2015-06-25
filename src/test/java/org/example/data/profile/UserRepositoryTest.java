package org.example.data.profile;

import org.example.data.DataTest;
import org.example.domain.profile.Person;
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
import java.util.List;

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
    john.setPerson(new Person("John", "Doe"));

    userRepository.saveAndFlush(john);
  }

  @Test
  public void testFindAll()
  {
    final List<User> users = userRepository.findAll();

    Assert.assertFalse(users.isEmpty());

    users.forEach(user -> {
      Assert.assertNotNull(user.getID());
      Assert.assertNotNull(user.getName());
      Assert.assertNotNull(user.getPerson());
      Assert.assertNotNull(user.getPerson().getFirstName());
      Assert.assertNotNull(user.getPerson().getLastName());
      Assert.assertEquals(user, user.getPerson().getUser());
      Assert.assertNotNull(user.getRoles());
      Assert.assertNotEquals(0, user.getRoles().size());

      user.getRoles().forEach(role -> {
        Assert.assertNotNull(role.getID());
        Assert.assertNotNull(role.getName());
      });
    });
  }
}
