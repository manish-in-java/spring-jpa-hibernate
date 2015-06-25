package org.example.domain.profile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents an official work day defined for an employee.
 */
@Entity
@Table(name = "employee_workday")
public class EmployeeWorkday extends Workday
{
  @JoinColumn(name = "employee_id")
  @ManyToOne(fetch = FetchType.EAGER)
  @NotNull
  private Employee employee;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  EmployeeWorkday()
  {
    super();
  }

  /**
   * Creates a work day for a specified day of the week and a given
   * start and end time for an employee.  A break with a given start
   * and end time is also added.
   *
   * @param employee       The employee for whom the work day is being
   *                       defined.
   * @param dayOfWeek      The day of the week for the work day.
   * @param startTime      The time of the day when the work day starts.
   * @param endTime        The time of the day when the work day ends.
   * @param breakStartTime The time of the day when the common break starts.
   * @param breakEndTime   The time of the day when the common break ends.
   */
  public EmployeeWorkday(final Employee employee
      , final DayOfWeek dayOfWeek
      , final LocalTime startTime
      , final LocalTime endTime
      , final LocalTime breakStartTime
      , final LocalTime breakEndTime)
  {
    super(dayOfWeek, startTime, endTime, breakStartTime, breakEndTime);

    this.employee = employee;
  }

  /**
   * Gets the employee for whom the work day has been defined.
   *
   * @return The employee for whom the work day has been defined.
   */
  public Employee getEmployee()
  {
    return employee;
  }
}
