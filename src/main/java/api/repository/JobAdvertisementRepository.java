package api.repository;


import api.entities.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {
    @Query("From JobAdvertisement where isActive=true")
    List<JobAdvertisement> findByIsActive();

    JobAdvertisement findById(int advertisement);
}
