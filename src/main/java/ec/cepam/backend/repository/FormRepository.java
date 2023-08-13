package ec.cepam.backend.repository;

import ec.cepam.backend.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, Integer>{

    List<Form> findByAreaId(Integer id);
}
