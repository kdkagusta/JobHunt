package api.repository;

import api.entities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {
    @Query(name = "SELECT c FROM Cv c WHERE c.jobSeeker_id = ?1", nativeQuery = true)
    List<Cv> findByJobSeekerId(int id);
}
