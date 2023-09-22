package belajar.springboot._02core.model.Coach;

import belajar.springboot._02core.model.Interface.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In Cosnstructor " + getClass().getSimpleName());
    }
    @PostConstruct
    public void startUpTennisCoach()
    {
        System.out.println("Construct Tennis Coach");
    }


    @PreDestroy
    public void destroyTennisCoach()
    {
        System.out.println("Destroy Tennis Coach");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
