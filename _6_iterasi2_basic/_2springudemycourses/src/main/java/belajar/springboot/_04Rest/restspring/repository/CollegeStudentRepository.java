package belajar.springboot._04Rest.restspring.repository;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollegeStudentRepository extends JpaRepository<CollegeStudent,String> {

    List<CollegeStudent> getFiltered(
            @Param("nomorIndukMahasiswa") String nomorIndukMahasiswa,
            @Param("namaDepan") String namaDepan,
            @Param("namaBelakang") String namaBelakang,
            @Param("jurusan") String jurusan,
            @Param("angkatan") Integer angkatan
    );




}
