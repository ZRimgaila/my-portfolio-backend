package zr.spring_boot.my_portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zr.spring_boot.my_portfolio.model.ImageData;
import zr.spring_boot.my_portfolio.model.Skill;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {
}
