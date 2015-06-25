package org.example.data.profile;

import org.example.data.DataTest;
import org.example.domain.profile.Employee;
import org.example.domain.profile.Office;
import org.example.domain.profile.OfficeWorkday;
import org.example.domain.profile.Person;
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
public class OfficeRepositoryTest extends DataTest
{
  @Autowired
  private OfficeRepository officeRepository;

  /**
   * Adds an office for the tests to run.
   */
  @Before
  public void setup()
  {
    final Office office = new Office(getString());

    Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)
        .forEach(day -> office.addWorkday(new OfficeWorkday(office
            , day
            , LocalTime.MIDNIGHT.plusHours(8)
            , LocalTime.MIDNIGHT.plusHours(18)
            , LocalTime.NOON
            , LocalTime.NOON.plusHours(1))));

    IntStream.range(0, getInt()).forEach(i -> {
      office.addEmployee(new Employee(office, new Person(getString(), getString()), getString()));
    });

    officeRepository.saveAndFlush(office);
  }

  /**
   * Tests that offices can be loaded successfully.
   */
  @Test
  public void testFindAll()
  {
    final List<Office> offices = officeRepository.findAll();

    Assert.assertFalse(offices.isEmpty());

    offices.forEach(office -> {
      Assert.assertNotNull(office.getID());
      Assert.assertNotNull(office.getName());
      Assert.assertNotEquals(0, office.getEmployees().size());
      Assert.assertNotEquals(0, office.getWorkdays().size());

      office.getWorkdays().forEach(day -> {
        Assert.assertNotNull(day.getBreakEndTime());
        Assert.assertNotNull(day.getBreakStartTime());
        Assert.assertNotNull(day.getDayOfWeek());
        Assert.assertNotNull(day.getEndTime());
        Assert.assertNotNull(day.getID());
        Assert.assertNotNull(day.getOffice());
        Assert.assertNotNull(day.getStartTime());
      });
    });
  }
}
