package belajar.springboot._03hibernate.service;

import belajar.springboot._03hibernate.dao.StudentDAO;
import belajar.springboot._03hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private FakerService fakerService;


    @Autowired
    private BufferedReader reader;
    public void createRandomStudent()
    {
        log.info("Creating a New Student");
        String email = fakerService.getFaker().internet().emailAddress().toUpperCase();
        String firstName;
        String lastName = "";
        if(email.contains(".")){
            String[] emailSplit = email.split("\\.",2);
            firstName = emailSplit[0];
            lastName = emailSplit[1].split("@")[0];
        }else{
            firstName = email.split("@")[0];
        }
        Student student = Student.
                builder().email(email)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        log.info("Success Creating student "+ "[" + student.toString() + "]");

        try{
            log.info("Saving a new Student");
            studentDAO.save(student);
            log.info("Success saving student " + student.getId());
        }catch (Exception e)
        {
            log.info("Fail :" + e.getMessage());
        }
    }

    public void readAllStudent(){
        List<Student> listStudent = studentDAO.readAll();
        for(int i = 0 ;i<listStudent.size();i++){
            System.out.println(i+1 +" " + listStudent.get(i).toString().toLowerCase());
        }
    }

    public void cleanBuffer() throws IOException {
        reader.readLine();
    };


    public void update(int nomor) throws IOException {

        //get List
        List<Student> studentList = studentDAO.readAll();
        //then get list base on nomor
        Student selectedStudent = studentList.get(nomor);

        System.out.println("nama depan baru : "); String newNamaDepan = reader.readLine();
        System.out.println("nama belakang baru : "); String newNamaBelakang = reader.readLine();
        System.out.println("email baru : "); String newEmail = reader.readLine();

        // Mengosongkan buffer
        cleanBuffer();

        selectedStudent.setFirstName(newNamaDepan.toUpperCase());
        selectedStudent.setLastName(newNamaBelakang.toUpperCase());
        selectedStudent.setEmail(newEmail.toUpperCase());

        try{
            studentDAO.update(selectedStudent);
        }catch (Exception e)
        {
            log.warn("FAIL : " + e.getMessage());
        }
    }


    public void delete(int nomor)
    {

        //get List
        List<Student> studentList = studentDAO.readAll();
        //then get list base on nomor
        Student selectedStudent = studentList.get(nomor);
        try{
            studentDAO.delete(selectedStudent);
        }catch (Exception e)
        {
            log.warn("FAIL : " + e.getMessage());
        }
    }

}
