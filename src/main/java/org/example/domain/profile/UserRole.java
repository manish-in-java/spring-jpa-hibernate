package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_role")
public class UserRole extends Model
{
  @Column(name = "name")
  @Enumerated(EnumType.STRING)
  @NotNull
  private RoleEnum name;

  UserRole()
  {
    super();
  }

  public UserRole(final RoleEnum name)
  {
    this();

    this.name = name;
  }

  public RoleEnum getName()
  {
    return name;
  }
}
