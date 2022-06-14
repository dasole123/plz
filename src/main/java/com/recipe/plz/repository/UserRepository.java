package com.recipe.plz.repository;

import com.recipe.plz.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    //Optional<Users> findByEmail(String email);

}