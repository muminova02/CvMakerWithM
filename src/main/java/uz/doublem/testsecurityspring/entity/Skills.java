package uz.doublem.testsecurityspring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String skill;
    private String proficiency;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    @ToString.Exclude
    private Cv cv;
}
