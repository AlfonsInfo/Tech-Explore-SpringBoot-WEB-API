package belajar.springboot._02core.model.Coach;

import belajar.springboot._02core.model.Interface.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BadmintonCoach implements Coach {

    public BadmintonCoach() {
        System.out.println("In Cosnstructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Backhand smash";
    }
}
