package uz.avazbek.assignmentsubmissionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avazbek.assignmentsubmissionapp.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    public Optional<User> findByUsername(String username);
}
