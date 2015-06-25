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
import java.util.stream.IntStream;

/**
 * Integration tests for {@link OfficeRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class WorkdayRepositoryTest extends DataTest
{
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private OfficeRepository   officeRepository;
  @Autowired
  private WorkdayRepository  workdayRepository;

  /**
   * Adds some employees and offices with work days for the tests to run.
   */
  @Before
  public void setup()
  {
    final List<DayOfWeek> weekdays = Arrays.asList(DayOfWeek.MONDAY
        , DayOfWeek.TUESDAY
        , DayOfWeek.WEDNESDAY
        , DayOfWeek.THURSDAY
        , DayOfWeek.FRIDAY);

    IntStream.range(0, getInt()).forEach(i -> {
      final Office office = new Office(getString());

      weekdays.forEach(day -> office.addWorkday(new OfficeWorkday(office
          , day
          , LocalTime.MIDNIGHT.plusHours(8)
          , LocalTime.MIDNIGHT.plusHours(18)
          , LocalTime.NOON
          , LocalTime.NOON.plusHours(1))));

      final Employee employee = new Employee(office, new Person(getString(), getString()), getString());

      weekdays.forEach(day -> employee.addWorkday(new EmployeeWorkday(employee
          , day
          , LocalTime.MIDNIGHT.plusHours(8)
          , LocalTime.MIDNIGHT.plusHours(18)
          , LocalTime.NOON
          , LocalTime.NOON.plusHours(1))));

      officeRepository.saveAndFlush(office);
    });
  }

  /**
   * Tests that the number of work days can be determined
   * correctly, even though {@link Workday} is an {@code abstract}
   * class.
   */
  @Test
  public void testCount()
  {
    Assert.assertNotEquals(0, workdayRepository.count());
  }
}
