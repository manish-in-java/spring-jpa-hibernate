package org.example.data.profile;

import org.example.data.ModelRepository;
import org.example.domain.profile.Person;

import java.util.List;

/**
 * Contract for data access operations on {@link Person}.
 */
public interface PersonRepository extends ModelRepository<Person>
{
  /**
   * Finds all persons having a specified first name.
   *
   * @param firstName The first name to find.
   * @return A {@link List} of {@link Person}s.
   */
  List<Person> findAllByFirstName(String firstName);
}
