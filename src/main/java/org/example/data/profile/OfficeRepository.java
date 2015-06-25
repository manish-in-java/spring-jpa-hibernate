package org.example.data.profile;

import org.example.data.ModelRepository;
import org.example.domain.profile.Office;

/**
 * Contract for data access operations on {@link Office}.
 */
public interface OfficeRepository extends ModelRepository<Office>
{
  /**
   * Finds an office by its name.
   *
   * @param name The name of the office to find.
   * @return An {@link Office}.
   */
  Office findByName(String name);
}
