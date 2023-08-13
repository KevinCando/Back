package ec.cepam.backend.repository;

import ec.cepam.backend.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    Area findByName(String name);
}
