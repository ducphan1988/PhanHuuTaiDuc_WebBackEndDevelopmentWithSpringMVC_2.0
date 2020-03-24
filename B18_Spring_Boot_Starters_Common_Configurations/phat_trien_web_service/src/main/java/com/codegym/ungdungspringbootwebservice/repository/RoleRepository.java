package com.codegym.ungdungspringbootwebservice.repository;

import com.codegym.ungdungspringbootwebservice.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
