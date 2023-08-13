package ec.cepam.backend.repository;

import ec.cepam.backend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findByNamesAndSurnames(String names, String surnames);
}
