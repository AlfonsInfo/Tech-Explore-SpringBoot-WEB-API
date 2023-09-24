package belajar.springboot._04Rest.restspring.entity.CollegeStudent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQuery;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "suc_college_student")
@NamedNativeQuery(
        name = "CollegeStudent.getFiltered",
        query = "SELECT * FROM suc_college_student " +
                "WHERE (:nomorIndukMahasiswa IS NULL OR nomor_induk_mahasiswa = :nomorIndukMahasiswa) " +
                "AND (:namaDepan IS NULL OR nama_depan = :namaDepan) " +
                "AND (:namaBelakang IS NULL OR nama_belakang = :namaBelakang) " +
                "AND (:jurusan IS NULL OR jurusan = :jurusan) " +
                "AND (:angkatan IS NULL OR angkatan = :angkatan) ",
        resultClass = CollegeStudent.class
)
//todo cari alternatif-alternatif pembuatan query
@Builder
public class CollegeStudent {


    @jakarta.persistence.Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name="custom-id",strategy = "belajar.util.generator.CustomIdGenerator")
    private String nomorIndukMahasiswa;
    private String namaDepan;
    private String namaBelakang;
    private String namaLengkap;
    private Integer angkatan;
    private String jurusan;


}
