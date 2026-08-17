package com.example.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

Optional<User> findByEmail(String email);
boolean existsByEmail(String email);
}

public record UserResponse(Long id, String email, String name) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getName());
    }
}
