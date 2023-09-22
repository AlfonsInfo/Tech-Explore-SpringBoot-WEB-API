package belajar.springboot._04Rest.controller;


import belajar.springboot._04Rest.entity.student.DummyStudent;
import belajar.springboot._04Rest.entity.student.StaticDummyStudent;
import belajar.springboot._04Rest.entity.student.Student;
import belajar.util.exception.EntityNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    DummyStudent dummyStudent;


    List<Student> LoadOnceStudents = new ArrayList<>();
    @PostConstruct
    public void loadData(){
        LoadOnceStudents.addAll(this.dummyStudent.generateDummy(10));
        LoadOnceStudents.addAll(StaticDummyStudent.listStudent);

    }

    @GetMapping("/dummyStudent")
    public List<Student> getDummyStudent()
    {
        return this.dummyStudent.generateDummy(5);
    }

    @GetMapping("/dummyStudent/{studentId}")
    public Student getStudentById(@PathVariable int studentId)
    {
        List<Student> listStudent = StaticDummyStudent.listStudent;
        if(listStudent.size() >= studentId){
            return listStudent.get(studentId);
        }else{
            //Override default exception
            throw new EntityNotFoundException("Data tidak ditemukan");
        }
    }


    @GetMapping("/dummyall")
    public List<Student> getAllDummy()
    {
        return LoadOnceStudents;
    }


    @GetMapping("/dummyall/{studentId}")
    public Student getAllDummy(@PathVariable("studentId") int id)
    {
        try{
            return LoadOnceStudents.get(id);
        }catch (Exception e)
        {
            throw new EntityNotFoundException("Data tidak ditemukan");
        }
    }

    //We can add here exception handling, but better use global exception handling (rest controller advice)
}
