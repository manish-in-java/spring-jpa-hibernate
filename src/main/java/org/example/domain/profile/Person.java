package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  Person()
  {
    super();
  }

  public Person(final String firstName, final String lastName)
  {
    this();

    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public User getUser()
  {
    return user;
  }

  void setUser(final User user)
  {
    this.user = user;
  }
}
