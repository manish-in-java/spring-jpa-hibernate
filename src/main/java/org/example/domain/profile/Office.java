package org.example.domain.profile;

import org.example.domain.Model;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an office for an organization.
 */
@Entity
@Table(name = "office")
public class Office extends Model
{
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "office", orphanRemoval = true)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Employee> employees;

  @Column(name = "name", unique = true)
  @NotNull
  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "office", orphanRemoval = true)
  @Fetch(value = FetchMode.SUBSELECT)
  List<OfficeWorkday> workdays;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Office()
  {
    super();
  }

  /**
   * Creates an office with a specified name.
   *
   * @param name The office name.
   */
  public Office(final String name)
  {
    this();

    this.name = name.trim();
  }

  /**
   * Adds an employee to this office.
   *
   * @param employee The employee to add.
   */
  public void addEmployee(final Employee employee)
  {
    if (employees == null)
    {
      employees = new ArrayList<>();
    }

    employees.add(employee);
  }

  /**
   * Adds a work day for this office.
   *
   * @param workday The work day to add.
   */
  public void addWorkday(final OfficeWorkday workday)
  {
    if (workdays == null)
    {
      workdays = new ArrayList<>();
    }

    workdays.add(workday);
  }

  /**
   * Gets the employees working at this office.
   *
   * @return A {@link List} of {@link Employee}s.
   */
  public List<Employee> getEmployees()
  {
    return employees;
  }

  /**
   * Gets the office name.
   *
   * @return The office name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the work days for the office.
   *
   * @return A {@link List} of {@link OfficeWorkday}s.
   */
  public List<OfficeWorkday> getWorkdays()
  {
    return workdays;
  }
}
