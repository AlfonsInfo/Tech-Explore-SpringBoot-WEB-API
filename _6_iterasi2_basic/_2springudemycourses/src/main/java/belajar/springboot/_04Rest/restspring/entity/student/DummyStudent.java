package belajar.springboot._04Rest.restspring.entity.student;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DummyStudent {


    @Autowired
    private  Faker faker;


    public  List<Student> generateDummy(int totalDummy){
        List<Student> students = new ArrayList<>();
        for(int i=0;i<totalDummy;i++){
            students.add(new Student(faker.name().firstName(),faker.name().lastName()));
        }
        return students;
    }
}
