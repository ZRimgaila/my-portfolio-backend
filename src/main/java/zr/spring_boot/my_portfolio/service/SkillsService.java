package zr.spring_boot.my_portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.repository.ImageDataRepository;
import zr.spring_boot.my_portfolio.repository.SkillsRepository;
import zr.spring_boot.my_portfolio.model.Skill;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    SkillsRepository repo;

    public String uploadSkill(MultipartFile file) throws IOException {
        Skill skill = repo.save(Skill.builder()
                .name(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(file.getBytes())
                .build()
        );

        if(skill != null){
            return "Image file uploaded successfully: " + file.getOriginalFilename();
        } else {
            return "Something wrong with upload";
        }
    }

    public List<Skill> getAllSkills() {
        return repo.findAll();
    }

    public Optional<Skill> getSkillById(int id) {
        return repo.findById(id);
    }

    public String updateSkillById(MultipartFile file) throws IOException {
        Skill skill = repo.save(Skill.builder()
                .name(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(file.getBytes())
                .build()
        );

        if(skill != null){
            return "Skill updated successfully: " + file.getOriginalFilename();
        } else {
            return "Something wrong with update";
        }
    }

    public void deleteSkillById(int id) {
        repo.deleteById(id);
    }
}
