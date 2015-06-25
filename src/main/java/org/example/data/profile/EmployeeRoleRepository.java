package org.example.data.profile;

import org.example.data.ModelRepository;
import org.example.domain.profile.EmployeeRole;
import org.example.domain.profile.EmployeeRoleEnum;

/**
 * Contract for data access operations on {@link EmployeeRole}.
 */
public interface EmployeeRoleRepository extends ModelRepository<EmployeeRole>
{
  /**
   * Finds an employee role by its name.
   *
   * @param name The employee role name to find.
   * @return An {@link EmployeeRole}.
   */
  EmployeeRole findByName(EmployeeRoleEnum name);
}
