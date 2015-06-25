package org.example.domain.profile;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Model
{
  @Column(name = "name")
  @NotNull
  private String name;

  @JoinTable(inverseJoinColumns = { @JoinColumn(name = "user_role_id") }, joinColumns = { @JoinColumn(name = "user_id") }, name = "user_user_role")
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<UserRole> roles;

  User()
  {
    super();
  }

  public User(final String name)
  {
    this();

    this.name = name;
  }

  public void addRole(final UserRole role)
  {
    if (roles == null)
    {
      roles = new HashSet<>();
    }

    roles.add(role);
  }

  public String getName()
  {
    return name;
  }

  public Set<UserRole> getRoles()
  {
    return roles;
  }
}
