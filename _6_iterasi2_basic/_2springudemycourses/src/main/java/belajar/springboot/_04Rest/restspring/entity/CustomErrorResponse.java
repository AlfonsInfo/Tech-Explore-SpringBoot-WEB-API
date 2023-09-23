package belajar.springboot._04Rest.restspring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {
    private String status;
    private String message;
    private Long timeStamp;
}
