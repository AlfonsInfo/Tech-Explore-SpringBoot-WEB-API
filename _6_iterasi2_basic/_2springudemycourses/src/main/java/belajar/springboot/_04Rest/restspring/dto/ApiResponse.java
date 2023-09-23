package belajar.springboot._04Rest.restspring.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>{
    private T responseData;
    private ErrorSchema errorSchema;

}
