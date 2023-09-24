package belajar.springboot._04Rest.restspring.util;

import belajar.springboot._04Rest.restspring.entity.CollegeStudent.CollegeStudent;
import belajar.springboot._04Rest.restspring.repository.CollegeStudentRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class NpmGenerator implements IdentifierGenerator {

    @Autowired
    CollegeStudentRepository collegeStudentRepository;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        if (o instanceof CollegeStudent){
            CollegeStudent collegeStudent = (CollegeStudent) o;
            String jurusan = collegeStudent.getJurusan();
            //ZZ YEAR JJJ JURUSAN, III NO URUT
            int jurusanCode = 0;
            switch (jurusan){
                case "INFORMATIKA" :
                    jurusanCode = 071;
                    break;
                case "SISTEM INFORMASI" :
                    jurusanCode = 052;
                    break;
                default:
                    break;
            }
            Optional<CollegeStudent> getDataOpt = collegeStudentRepository.getListStudentGroupByJurusan(jurusanCode);
            String last5DigitsNPM;
            if(getDataOpt.isPresent()){
                CollegeStudent getData = getDataOpt.get();
                last5DigitsNPM = extractNextUniqueCode(getData.getNomorIndukMahasiswa());
            }else{
                last5DigitsNPM= "00001";
            }
            return  extract2DigitYear() + String.valueOf(jurusanCode)+last5DigitsNPM;
        }else{
            return null;
        }
    }

    public String extractNextUniqueCode(String npm){
        return "200710542";
    }

    public String extract2DigitYear(){
        LocalDateTime localDateTime = LocalDateTime.now();
        int currentYear = localDateTime.getYear();
        return localDateTime.toString().substring(2);
//        return currentYearStr;
    }
}



//
//        Query query = hibernateSession.createQuery("SELECT e FROM CollegeStudent e\n" +
//                "ORDER BY\n" +
//                "  SUBSTRING(e.id, 1, 2) DESC, \n" +
//                "  SUBSTRING(e.id, 3, 3) DESC, \n" +
//                "  SUBSTRING(e.id, 6) DESC; ");
//        query.setMaxResults(1);
//        CollegeStudent collegeStudent = (CollegeStudent) query.getSingleResult();
//
//        String nomorIndukMahasiswa =  collegeStudent.getNomorIndukMahasiswa();
//        int npmLength = nomorIndukMahasiswa.length();
//        int startIndexForSlice = npmLength-5;
//        String FiveDigitsNPM = nomorIndukMahasiswa.substring(startIndexForSlice);
//        int integerValueNPM = Integer.parseInt(FiveDigitsNPM);
//        int nextFiveDigitsNPM = ++integerValueNPM;
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        int currentYear = localDateTime.getYear();
//        String currentYearStr= localDateTime.toString().substring(2);
//         // cek column b
//        // if else berdasarkan kolum b
//        return currentYearStr+nextFiveDigitsNPM;