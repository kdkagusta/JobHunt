package api.repository;

import api.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    List<Link> findAllByCv_Id(int id);
}
