package belajar.springboot._04Rest.restspring.repository;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollegeStudentRepository extends JpaRepository<CollegeStudent,String> {

    List<CollegeStudent> getFiltered(
            @Param("nomorIndukMahasiswa") String nomorIndukMahasiswa,
            @Param("namaDepan") String namaDepan,
            @Param("namaBelakang") String namaBelakang,
            @Param("jurusan") String jurusan,
            @Param("angkatan") Integer angkatan
    );


//    @Query("SELECT m FROM CollegeStudent m WHERE SUBSTRING(m.nim, 1, 2) = ?1 AND SUBSTRING(m.nim, 3, 2) = '20' ORDER BY SUBSTRING(m.nim, 5) DESC")
    //entity already mapping
    @Query("SELECT m FROM suc_college_student m WHERE SUBSTRING(m.nomorIndukMahasiswa, 1, 2) = :kodeJurusan  ORDER BY RIGHT(m.nomorIndukMahasiswa, 5) DESC LIMIT 1")
    Optional<CollegeStudent> findStudentByKodeJurusan(@Param("kodeJurusan") String kodeJurusan);



}
