package belajar.springboot._04Rest.restspring.entity.CollegeStudent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "suc_college_student")
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
