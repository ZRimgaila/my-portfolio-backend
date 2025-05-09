package zr.spring_boot.my_portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zr.spring_boot.my_portfolio.model.Skill;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, Integer> {
}
