package uz.doublem.testsecurityspring.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CvDto {
    private Integer id;
    private String photoName;
    private String fullName;
    private String jobTitle;
}
