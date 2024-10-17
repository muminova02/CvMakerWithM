package uz.doublem.testsecurityspring.payload;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.doublem.testsecurityspring.entity.Cv;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EducationDto {
    private String universityName;
    private String fieldStudy;
    private String degree;
    private String fromYear;
    private String toYear;
}
