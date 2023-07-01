package dev.galiev.notificationsystem.repository;

import dev.galiev.notificationsystem.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionsRep extends JpaRepository<Subscription, Long> {
}
