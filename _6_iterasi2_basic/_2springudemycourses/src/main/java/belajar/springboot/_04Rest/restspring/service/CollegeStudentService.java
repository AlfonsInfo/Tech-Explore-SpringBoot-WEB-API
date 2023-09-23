package belajar.springboot._04Rest.restspring.service;

import belajar.springboot._04Rest.restspring.dto.ApiResponse;
import belajar.springboot._04Rest.restspring.dto.ErrorSchema;
import belajar.springboot._04Rest.restspring.dto.request.CreateCollegeStudentRequest;
import belajar.springboot._04Rest.restspring.dto.response.CreateCollegeStudentResponse;
import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import belajar.springboot._04Rest.restspring.repository.CollegeStudentRepository;
import belajar.springboot._04Rest.restspring.util.FileNameExtractor;
import belajar.springboot._04Rest.restspring.util.LogHelper;
import belajar.springboot._04Rest.restspring.validation.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
@Slf4j
public class CollegeStudentService {

    @Autowired
    private CollegeStudentRepository collegeStudentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private LogHelper logHelper;

    @Autowired
    private FileNameExtractor extractor;



    @Transactional
    public ApiResponse<CreateCollegeStudentResponse> createCollegeStudent(CreateCollegeStudentRequest request)
    {
        log.info(logHelper.logTemplate(extractor.extractFileName(System.getProperty("user.dir")),"Starting Service Create College Student" ));
        validationService.validate(request);

        try{
            log.info("Start Creating & Saving Object");
            CollegeStudent collegeStudent = CollegeStudent
                .builder()
                .namaDepan(request.getNamaDepan().toUpperCase())
                .namaBelakang(request.getNamaBelakang().toUpperCase())
                .namaLengkap(request.getNamaDepan().toUpperCase() +" "+
                        (Objects.nonNull(request.getNamaBelakang()) ?
                                request.getNamaBelakang().toUpperCase() :
                                request.getNamaDepan().toUpperCase())
                )
                .angkatan(request.getAngkatan())
                .jurusan(request.getJurusan().toUpperCase())
                .build();
            collegeStudentRepository.save(collegeStudent);
            log.info("Finish Creating & Saving Object");


            ErrorSchema errorSchema = new ErrorSchema();
            errorSchema.setSuccessResponse("Sukses Menambahkan data mahasiswa","Success Adding College Student Data");
            CreateCollegeStudentResponse response = modelMapper.map(collegeStudent, CreateCollegeStudentResponse.class);
            log.info("Finish Service Create College Student [SUCCESS]");
            return ApiResponse.<CreateCollegeStudentResponse>builder().responseData(response).errorSchema(errorSchema).build();
        } catch (Exception e){
            log.info("Exception : " + e.getMessage());
            log.info("Finish Service Create College Student [FAILED]");
            return null;
        }

    }
}
