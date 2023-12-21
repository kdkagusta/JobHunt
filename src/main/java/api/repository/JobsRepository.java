package api.repository;

import api.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {
    Jobs findByExplanation(String explanation);
}
