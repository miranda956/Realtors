package com.managers.app.repository;

import com.managers.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndIsActive(String username, boolean isActive);

    User findByEmail(String email);

    User findByUsernameAndPasswordHash(String username, String passwordHash);

    List<User> findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(String username, String email);
}
