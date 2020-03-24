package com.codegym.ungdungspringbootwebservice.repository;

import com.codegym.ungdungspringbootwebservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
