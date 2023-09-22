package belajar.springboot._03hibernate.dao;

import belajar.springboot._03hibernate.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentDAO {
    void save(Student student);


    List<Student> readAll();

    void update(Student student);


    void delete(Student student);

}
