package dev.galiev.notificationsystem.repository;

import dev.galiev.notificationsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRep extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
