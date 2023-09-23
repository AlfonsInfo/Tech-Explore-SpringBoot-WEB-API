package belajar.springboot._04Rest.restspring.entity.student;

import java.util.List;


public class StaticDummyStudent {

    public static List<Student> listStudent = List.of(
            new Student("Alfons","Setiawan"),
            new Student("Ucup","Surucup"),
            new Student("Donald","Bebek"),
            new Student("Kwik","Bebek"),
            new Student("Kwek","Bebek"),
            new Student("Kwak","Bebek")
    );
}
