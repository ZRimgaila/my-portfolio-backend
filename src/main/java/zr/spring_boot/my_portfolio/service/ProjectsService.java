package zr.spring_boot.my_portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.ImageData;
import zr.spring_boot.my_portfolio.model.Project;
import zr.spring_boot.my_portfolio.repository.ImageDataRepository;
import zr.spring_boot.my_portfolio.repository.ProjectsRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    private ProjectsRepository repo;

    public List<Project> getAllProjects(){
        return (List<Project>) repo.findAll();
    }

    public Project getProjectById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Project addProject(Project project) {
        return repo.save(project);
    }

    public Project updateProjectById(int id, Project project) {
        return repo.save(project);
    }

    public ResponseEntity<Project> getProjectWithSkills(Long id) {
        return repo.findById(Math.toIntExact(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
