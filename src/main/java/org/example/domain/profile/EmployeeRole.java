package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a role that can be assigned to an employee.
 */
@Entity
@Table(name = "employee_role")
public class EmployeeRole extends Model
{
  @Column(name = "name")
  @Enumerated(EnumType.STRING)
  @NotNull
  private EmployeeRoleEnum name;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  EmployeeRole()
  {
    super();
  }

  /**
   * Creates an employee role with a specified name.
   *
   * @param name The employee role name.
   */
  public EmployeeRole(final EmployeeRoleEnum name)
  {
    this();

    this.name = name;
  }

  /**
   * Gets the employee role name.
   *
   * @return The employee role name.
   */
  public EmployeeRoleEnum getName()
  {
    return name;
  }
}
