package api.repository;

import api.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    List<Skill> findAllByCv_Id(int id);
}
