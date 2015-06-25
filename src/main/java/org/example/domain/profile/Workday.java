package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents a general work day.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "workday")
public abstract class Workday extends Model
{
  @Column(name = "break_end_time")
  @NotNull
  private LocalTime breakEndTime;

  @Column(name = "break_start_time")
  @NotNull
  private LocalTime breakStartTime;

  @Column(name = "day_of_week")
  @Enumerated(EnumType.STRING)
  @NotNull
  private DayOfWeek dayOfWeek;

  @Column(name = "end_time")
  @NotNull
  private LocalTime endTime;

  @Column(name = "start_time")
  @NotNull
  private LocalTime startTime;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Workday()
  {
    super();
  }

  /**
   * Creates a work day for a specified day of the week and a given
   * start and end time.  A break with a given start and end time is
   * also added.
   *
   * @param dayOfWeek      The day of the week for the work day.
   * @param startTime      The time of the day when the work day starts.
   * @param endTime        The time of the day when the work day ends.
   * @param breakStartTime The time of the day when the common break starts.
   * @param breakEndTime   The time of the day when the common break ends.
   */
  protected Workday(final DayOfWeek dayOfWeek
      , final LocalTime startTime
      , final LocalTime endTime
      , final LocalTime breakStartTime
      , final LocalTime breakEndTime)
  {
    this();

    this.breakEndTime = breakEndTime;
    this.breakStartTime = breakStartTime;
    this.dayOfWeek = dayOfWeek;
    this.endTime = endTime;
    this.startTime = startTime;
  }

  /**
   * Gets the time of the day when the common break ends.
   *
   * @return The time of the day when the common break ends.
   */
  public LocalTime getBreakEndTime()
  {
    return breakEndTime;
  }

  /**
   * Gets the time of the day when the common break starts.
   *
   * @return The time of the day when the common break starts.
   */
  public LocalTime getBreakStartTime()
  {
    return breakStartTime;
  }

  /**
   * Gets the day of the week (Monday, Tuesday, etc.) for which
   * this workday has been defined.
   *
   * @return A day of the week.
   */
  public DayOfWeek getDayOfWeek()
  {
    return dayOfWeek;
  }

  /**
   * Gets the time of the day when the work day ends.
   *
   * @return The time of the day when the work day ends.
   */
  public LocalTime getEndTime()
  {
    return endTime;
  }

  /**
   * Gets the time of the day when the work day starts.
   *
   * @return The time of the day when the work day starts.
   */
  public LocalTime getStartTime()
  {
    return startTime;
  }
}
