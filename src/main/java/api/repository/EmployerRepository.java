package api.repository;

import api.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Employer findById(int id);

    Employer findByEmployerEmail(String email);
}
