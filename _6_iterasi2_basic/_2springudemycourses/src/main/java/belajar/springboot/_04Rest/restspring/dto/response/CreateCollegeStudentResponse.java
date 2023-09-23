package belajar.springboot._04Rest.restspring.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCollegeStudentResponse {
    private String nomorIndukMahasiswa;
    private String namaDepan;
    private String namaBelakang;
    private String namaLengkap;
    private Integer angkatan;
    private String jurusan;
}
