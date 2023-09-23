package belajar.springboot._04Rest.restspring.repository;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeStudentRepository extends JpaRepository<CollegeStudent,String> {

}
