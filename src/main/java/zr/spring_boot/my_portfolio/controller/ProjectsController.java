package zr.spring_boot.my_portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.Project;
import zr.spring_boot.my_portfolio.service.ProjectsService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ProjectsController {

    @Autowired
    private ProjectsService service;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return service.getAllProjects();
    }

//    @GetMapping("/projects/{id}")
//    public Project getProjectById(@PathVariable int id){
//        return service.getProjectById(id);
//    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project){
        return service.addProject(project);
    }

    @PutMapping("projects/{id}")
    public ResponseEntity<Project> updateProjectbyId(@PathVariable int id, @RequestBody Project project){
        Project newProject = service.updateProjectById(id, project);

        if(newProject != null){
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(project, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("projects/{id}")
    public ResponseEntity<Project> getProjectWithSkills(@PathVariable Long id){
        return service.getProjectWithSkills(id);
    }
}
