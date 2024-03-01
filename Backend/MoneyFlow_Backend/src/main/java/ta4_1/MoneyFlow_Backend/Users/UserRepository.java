package ta4_1.MoneyFlow_Backend.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Onur Onal
 */

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    List<User> findByType(String type);

    @Transactional
    void deleteById(UUID id);
}
