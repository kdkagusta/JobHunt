package api.repository;


import api.entities.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceRepository extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> findByCv_Id(int id);
}
