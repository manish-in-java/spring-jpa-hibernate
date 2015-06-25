package org.example.data.profile;

import org.example.data.DataTest;
import org.example.domain.profile.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Integration tests for {@link EmployeeRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class EmployeeRepositoryTest extends DataTest
{
  @Autowired
  private EmployeeRepository     employeeRepository;
  @Autowired
  private EmployeeRoleRepository employeeRoleRepository;

  /**
   * Adds an employee for the tests to run.
   */
  @Before
  public void setup()
  {
    Arrays.asList(EmployeeRoleEnum.values()).forEach(role -> employeeRoleRepository.saveAndFlush(new EmployeeRole(role)));

    final Office office = new Office(getString());

    final Employee employee = new Employee(office, new Person("John", "Doe"), getString());
    Arrays.stream(EmployeeRoleEnum.values()).forEach(role -> employee.addRole(employeeRoleRepository.findByName(role)));

    Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)
        .forEach(day -> employee.addWorkday(new EmployeeWorkday(employee
            , day
            , LocalTime.MIDNIGHT.plusHours(8)
            , LocalTime.MIDNIGHT.plusHours(18)
            , LocalTime.NOON
            , LocalTime.NOON.plusHours(1))));

    employeeRepository.saveAndFlush(employee);
  }

  /**
   * Tests that employee can be loaded successfully.
   */
  @Test
  public void testFindAll()
  {
    final List<Employee> employees = employeeRepository.findAll();

    Assert.assertFalse(employees.isEmpty());

    employees.forEach(employee -> {
      Assert.assertNotNull(employee.getID());
      Assert.assertNotNull(employee.getCode());
      Assert.assertNotNull(employee.getOffice());
      Assert.assertNotNull(employee.getPerson());
      Assert.assertNotNull(employee.getPerson().getFirstName());
      Assert.assertNotNull(employee.getPerson().getLastName());
      Assert.assertNotNull(employee.getRoles());
      Assert.assertNotEquals(0, employee.getRoles().size());
      Assert.assertNotEquals(0, employee.getWorkdays().size());

      employee.getRoles().forEach(role -> {
        Assert.assertNotNull(role.getID());
        Assert.assertNotNull(role.getName());
      });

      employee.getWorkdays().forEach(day -> {
        Assert.assertNotNull(day.getBreakEndTime());
        Assert.assertNotNull(day.getBreakStartTime());
        Assert.assertNotNull(day.getDayOfWeek());
        Assert.assertNotNull(day.getEmployee());
        Assert.assertNotNull(day.getEndTime());
        Assert.assertNotNull(day.getID());
        Assert.assertNotNull(day.getStartTime());
      });
    });
  }
}
