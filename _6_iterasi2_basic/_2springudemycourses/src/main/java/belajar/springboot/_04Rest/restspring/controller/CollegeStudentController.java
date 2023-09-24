package belajar.springboot._04Rest.restspring.controller;


import belajar.springboot._04Rest.restspring.dto.ApiResponse;
import belajar.springboot._04Rest.restspring.dto.request.CreateCollegeStudentRequest;
import belajar.springboot._04Rest.restspring.dto.request.ReadCollegeStudentRequest;
import belajar.springboot._04Rest.restspring.dto.response.CreateCollegeStudentResponse;
import belajar.springboot._04Rest.restspring.dto.response.ReadCollegeStudentResponse;
import belajar.springboot._04Rest.restspring.service.CollegeStudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/college")
//@Validated
public class CollegeStudentController {

    @Autowired
    private CollegeStudentService collegeStudentService;
    //Binding Request Body, ModelAttribute, Request Params
    @PostMapping(path = "/student",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<CreateCollegeStudentResponse> createCollegeStudentData(
            HttpServletRequest httpServletRequest,
            /*@Valid*/ @RequestBody CreateCollegeStudentRequest request)
    {
        return collegeStudentService.createCollegeStudent(request);
    }


    @GetMapping(path = "/student")
    public ApiResponse<ReadCollegeStudentResponse> readCollegeStudentData(
            HttpServletRequest httpServletRequest,
            @RequestParam(required = false, name = "nama_depan") String namaDepan,
            @RequestParam(required = false, name = "nama_belakang") String namaBelakang,
            @RequestParam(required = false, name = "nomor_induk_mahasiswa") String nomorIndukMahasiswa,
            @RequestParam(required = false, name = "jurusan") String jurusan,
            @RequestParam(required = false, name = "angkatan") Integer angkatan
            )
    {
        ReadCollegeStudentRequest request = ReadCollegeStudentRequest
                .builder()
                .namaDepan(namaDepan)
                .namaBelakang(namaBelakang)
                .nomorIndukMahasiswa(nomorIndukMahasiswa)
                .jurusan(jurusan)
                .angkatan(angkatan)
                .build();

        return collegeStudentService.readCollegeStudent(request);
    }
}
