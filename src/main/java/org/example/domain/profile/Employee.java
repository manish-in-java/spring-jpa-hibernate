package org.example.domain.profile;

import org.example.domain.Model;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents an employee within an organization.
 */
@Entity
@Table(name = "employee")
public class Employee extends Model
{
  @Column(name = "code")
  @NotNull
  private String code;

  @JoinColumn(name = "office_id")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @NotNull
  private Office office;

  @OneToOne(cascade = CascadeType.ALL)
  @NotNull
  private Person person;

  @JoinTable(inverseJoinColumns = { @JoinColumn(name = "employee_role_id") }
      , joinColumns = { @JoinColumn(name = "employee_id") }
      , name = "employee_employee_role")
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<EmployeeRole> roles;

  @Fetch(value = FetchMode.SUBSELECT)
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee", orphanRemoval = true)
  List<EmployeeWorkday> workdays;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Employee()
  {
    super();
  }

  /**
   * Creates an employee with a specified employee code.
   *
   * @param office The office where the employee works.
   * @param person The person who is the employee.
   * @param code   The employee code.
   */
  public Employee(final Office office, final Person person, final String code)
  {
    this();

    this.code = code.trim();
    this.office = office;
    this.person = person;
  }

  /**
   * Adds a role for this employee.
   *
   * @param role The role to add.
   */
  public void addRole(final EmployeeRole role)
  {
    if (roles == null)
    {
      roles = new HashSet<>();
    }

    roles.add(role);
  }

  /**
   * Adds a work day for this employee.
   *
   * @param workday The work day to add.
   * @throws IllegalArgumentException if {@code workday} is defined for a different
   *                                  employee.
   */
  public void addWorkday(final EmployeeWorkday workday)
  {
    if (workdays == null)
    {
      workdays = new ArrayList<>();
    }

    workdays.add(workday);
  }

  /**
   * Gets the employee code.
   *
   * @return The employee code.
   */
  public String getCode()
  {
    return code;
  }

  /**
   * Gets the office where the employee works.
   *
   * @return The office where the employee works.
   */
  public Office getOffice()
  {
    return office;
  }

  /**
   * Gets the person who is the employee.
   *
   * @return The person who is the employee.
   */
  public Person getPerson()
  {
    return person;
  }

  /**
   * Gets the roles assigned to the employee.
   *
   * @return A {@link Set} of {@link EmployeeRole}s.
   */
  public Set<EmployeeRole> getRoles()
  {
    return roles;
  }

  /**
   * Gets the work days for the employee.
   *
   * @return A {@link List} of {@link EmployeeWorkday}s.
   */
  public List<EmployeeWorkday> getWorkdays()
  {
    return workdays;
  }
}
