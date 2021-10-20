package com.poletaiev.security.repo;

import com.poletaiev.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    User save(User user);
    List<User> findAll();
}
