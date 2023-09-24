package belajar.springboot._04Rest.restspring.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadCollegeStudentRequest {
//    @JsonProperty("nomor_induk_mahasiswa")
    private String nomorIndukMahasiswa;
//    @JsonProperty("nama_depan")
    private String namaDepan;
//    @JsonProperty("nama_belakang")
    private String namaBelakang;
    private Integer angkatan;
//    @JsonProperty("jurusan")
    private String jurusan;
}
