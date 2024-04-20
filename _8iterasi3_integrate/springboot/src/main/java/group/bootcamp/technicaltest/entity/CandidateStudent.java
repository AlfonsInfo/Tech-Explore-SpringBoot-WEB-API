package group.bootcamp.technicaltest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateStudent {
    private String name;
    private Integer age;
    private String gender;
    private String religion;
}
