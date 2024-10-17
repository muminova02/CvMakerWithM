package uz.doublem.testsecurityspring.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplate {
    private String message;
    private Boolean success;
    private Object data;
}
