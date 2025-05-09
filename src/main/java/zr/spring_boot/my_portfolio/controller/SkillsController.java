package zr.spring_boot.my_portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.service.ImageDataService;
import zr.spring_boot.my_portfolio.service.SkillsService;
import zr.spring_boot.my_portfolio.model.Skill;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SkillsController {

    @Autowired
    SkillsService service;

    @PostMapping("/skills")
    public ResponseEntity<?> addSkill(@RequestParam("skills") MultipartFile file) throws IOException {
        String uploadImage = service.uploadSkill(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<byte[]> getSkillById(@PathVariable int id){
        Optional<Skill> skillOptional = service.getSkillById(id);
        if(skillOptional.isPresent()){
            Skill skill = skillOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(skill.getImageType()))
                    .body(skill.getImageData());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkills(){
        return service.getAllSkills();
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable int id, @RequestParam("skills") MultipartFile file) throws IOException {
        Optional<Skill> skill = service.getSkillById(id);
        if(skill.isPresent()){
            service.deleteSkillById(id);
            String updatedSkill = service.updateSkillById(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedSkill);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Skill with such id not found");
        }
    }

}
