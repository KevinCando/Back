package ec.cepam.backend.repository;

import ec.cepam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameAndPass(String name, String pass);
}
