package zr.spring_boot.my_portfolio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Builder
public class ContactInformation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description;
    private String content;
    private String imageType;
    @Column(name = "image_data", length=1000)
    private byte[] imageData;
}
