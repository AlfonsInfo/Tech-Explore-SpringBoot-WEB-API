package belajar.springboot._04Rest.restspring.repository;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CollegeStudentRepository extends JpaRepository<CollegeStudent,String> {

    List<CollegeStudent> getFiltered(
            @Param("nomorIndukMahasiswa") String nomorIndukMahasiswa,
            @Param("namaDepan") String namaDepan,
            @Param("namaBelakang") String namaBelakang,
            @Param("jurusan") String jurusan,
            @Param("angkatan") Integer angkatan
    );


//    @Query("SELECT m FROM CollegeStudent m WHERE SUBSTRING(m.nim, 1, 2) = ?1 AND SUBSTRING(m.nim, 3, 2) = '20' ORDER BY SUBSTRING(m.nim, 5) DESC")
    @Query("SELECT m FROM CollegeStudent m WHERE SUBSTRING(m.nim, 1, 2) = :kodeJurusan  ORDER BY RIGHT(m.nomor_induk_mahasiswa, 5) DESC LIMIT 1")
    Optional<CollegeStudent> getListStudentGroupByJurusan(@Param("kodeJurusan") int kodeJurusan);



}
