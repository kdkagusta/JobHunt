package api.repository;

import api.entities.PreliminaryExplanation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreliminaryExplanationRepository extends JpaRepository<PreliminaryExplanation, Integer> {
    List<PreliminaryExplanation> findAllByCv_Id(int id);
}
