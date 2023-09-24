package belajar.springboot._04Rest.restspring.dto.response;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReadCollegeStudentResponse {
    List<CollegeStudent> data = new ArrayList<>();
}
