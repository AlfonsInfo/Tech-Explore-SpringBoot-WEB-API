package belajar.springboot._04Rest.restspring.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCollegeStudentRequest {
    @NotNull
    private String namaDepan;
    private String namaBelakang;
    @NotNull
    private Integer angkatan;
    @NotNull
    private String jurusan;
}
