package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents a person.
 */
@Entity
@Table(name = "person")
public class Person extends Model
{
  @Column(name = "first_name")
  @NotNull
  private String firstName;

  @Column(name = "last_name")
  @NotNull
  private String lastName;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Person()
  {
    super();
  }

  /**
   * Creates a person with specified first and last names.
   *
   * @param firstName The first name for the person.
   * @param lastName  The last name for the person.
   */
  public Person(final String firstName, final String lastName)
  {
    this();

    this.firstName = firstName.trim();
    this.lastName = lastName.trim();
  }

  /**
   * Gets the first name for the person.
   *
   * @return The first name for the person.
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Gets the last name for the person.
   *
   * @return The last name for the person.
   */
  public String getLastName()
  {
    return lastName;
  }
}
