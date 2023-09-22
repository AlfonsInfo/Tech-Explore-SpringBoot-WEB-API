package belajar.springboot._02core.controller.constructorinjection;

import belajar.springboot._02core.model.Interface.Coach;
import belajar.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//todo : bandingin testing menggunakan constructor work controller, field work controller, work controller
@RestController
@RequestMapping("/core")
public class ConstructorWorkController {


    private Coach coach;

    public ConstructorWorkController(@Qualifier("tennisCoach") Coach coach) {
        this.coach = coach;
    }


    @GetMapping("tennis")
    public String dailyWorkout()
    {
        return coach.getDailyWorkout();
    }


}
