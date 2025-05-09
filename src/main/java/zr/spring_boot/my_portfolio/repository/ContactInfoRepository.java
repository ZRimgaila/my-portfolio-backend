package zr.spring_boot.my_portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zr.spring_boot.my_portfolio.model.ContactInformation;

public interface ContactInfoRepository extends JpaRepository<ContactInformation, String> {
}
