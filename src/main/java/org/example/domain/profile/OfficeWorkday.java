package org.example.domain.profile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents an official work day defined for an office.
 */
@Entity
@Table(name = "office_workday")
public class OfficeWorkday extends Workday
{
  @JoinColumn(name = "office_id")
  @ManyToOne(fetch = FetchType.EAGER)
  @NotNull
  private Office office;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  OfficeWorkday()
  {
    super();
  }

  /**
   * Creates a work day for a specified day of the week and a given
   * start and end time for an office.  A break with a given start
   * and end time is also added.
   *
   * @param office         The office for which the work day is being
   *                       defined.
   * @param dayOfWeek      The day of the week for the work day.
   * @param startTime      The time of the day when the work day starts.
   * @param endTime        The time of the day when the work day ends.
   * @param breakStartTime The time of the day when the common break starts.
   * @param breakEndTime   The time of the day when the common break ends.
   */
  public OfficeWorkday(final Office office
      , final DayOfWeek dayOfWeek
      , final LocalTime startTime
      , final LocalTime endTime
      , final LocalTime breakStartTime
      , final LocalTime breakEndTime)
  {
    super(dayOfWeek, startTime, endTime, breakStartTime, breakEndTime);

    this.office = office;
  }

  /**
   * Gets the office for which the work day has been defined.
   *
   * @return The office for which the work day has been defined.
   */
  public Office getOffice()
  {
    return office;
  }
}
