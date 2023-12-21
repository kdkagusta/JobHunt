package api.repository;


import api.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findById(int Id);

    JobSeeker findByNationalIdentity(String nationalIdentity);
}
