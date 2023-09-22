//package belajar.springboot._02core.controller.setterinjection;
//
//import belajar.springboot._02core.model.Interface.Coach;
//import belajar.util.DateUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//
//
//@RestController
//@RequestMapping("/core")
//public class WorkController {
//
//    // Field Injection - Keuntungan : Simpel
//    @Autowired
//    @Qualifier("CricketCoach")
//    private Coach coach;
//
//    public void setCoach(@Qualifier("CricketCoach") Coach coach){
//        this.coach = coach;
//    }
//
//    @GetMapping("dailyworkout")
//    public String dailyWorkout()
//    {
//        return coach.getDailyWorkout();
//    }
//
//
//}
