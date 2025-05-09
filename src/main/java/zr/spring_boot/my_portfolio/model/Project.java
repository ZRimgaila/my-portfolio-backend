package zr.spring_boot.my_portfolio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class Project {

    @Id
    private int id;
    private int priority;
    private String name;
    @Column(length = 1000)
    private String description;
    private String linkToProject;

    @ManyToMany
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonManagedReference
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "project_images",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    @JsonManagedReference
    private Set<ImageData> images = new HashSet<>();
}
