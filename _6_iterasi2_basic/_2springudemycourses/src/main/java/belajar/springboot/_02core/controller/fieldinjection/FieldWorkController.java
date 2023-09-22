package belajar.springboot._02core.controller.fieldinjection;

import belajar.springboot._02core.model.Interface.Coach;
import belajar.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/core")
public class FieldWorkController {

    // Field Injection - Keuntungan : Simpel
    @Autowired
    @Qualifier("badmintonCoach") //same name as class but first char lowercase
    private Coach coach;

    @Autowired
    private DateUtil dateUtil;


    @GetMapping("badmintonsport")
    public String dailyWorkout()
    {
        return coach.getDailyWorkout();
    }


    @GetMapping("getnow")
    public String getDate(){
        LocalDateTime now  = LocalDateTime.now();
        return DateUtil.formatLocalDateTime(now,"dd/MM/YYYY");
    }
}
