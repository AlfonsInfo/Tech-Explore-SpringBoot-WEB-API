package belajar.springboot._04Rest.restspring.dto.request;

import lombok.Data;

@Data
public class UpdateCollegeStudentRequest {
    private String namaDepan;
    private String namaBelakang;
    private String namaLengkap;
    private Integer angkatan;
    private String jurusan;
}

