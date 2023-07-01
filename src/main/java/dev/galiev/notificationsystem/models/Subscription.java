package dev.galiev.notificationsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "subscriptions")
public class Subscription {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;
        private String name;
        private String description;
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
}
