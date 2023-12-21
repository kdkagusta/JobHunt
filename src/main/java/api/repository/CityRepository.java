package api.repository;

import api.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findByCityName(String name);

    City findById(int id);
}
