package zr.spring_boot.my_portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
@Builder
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imageType;
    @Column(name = "image_data", length=1000)
    private byte[] imageData;

    @ManyToMany(mappedBy = "skills")
    @JsonBackReference
    private Set<Project> projects = new HashSet<>();
}
