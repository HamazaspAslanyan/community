package org.communityconnectionapp.repository;

import org.communityconnectionapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsUserByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsUserByEmail(String email);

}
