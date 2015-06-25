package org.example.data.profile;

import org.example.data.ModelRepository;
import org.example.domain.profile.RoleEnum;
import org.example.domain.profile.UserRole;

public interface UserRoleRepository extends ModelRepository<UserRole>
{
  UserRole findByName(RoleEnum name);
}
