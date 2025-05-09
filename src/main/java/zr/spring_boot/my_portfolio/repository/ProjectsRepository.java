package zr.spring_boot.my_portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zr.spring_boot.my_portfolio.model.Project;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {
}
