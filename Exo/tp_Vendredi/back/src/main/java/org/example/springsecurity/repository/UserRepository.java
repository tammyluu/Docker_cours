package org.example.springsecurity.repository;

import org.example.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // optional eviter nullpointer
    Optional<User> findByEmail(String email);

}
