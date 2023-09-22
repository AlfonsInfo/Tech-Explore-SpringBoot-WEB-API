package belajar.springboot._02core.controller.scope;


import belajar.springboot._02core.model.Coach.BadmintonCoach;
import belajar.springboot._02core.model.Coach.BaseballCoach;
import belajar.springboot._02core.model.Interface.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scope")
public class ScopeDemoController {
    private Coach coachOne;
    private Coach coachTwo;

    private Coach coachThree;
    private Coach coachFour;



    @Autowired
    public ScopeDemoController(
            @Qualifier("badmintonCoach") Coach coachOne,
            @Qualifier("badmintonCoach") Coach coachTwo,
            @Qualifier("baseballCoach") Coach coachThree,
            @Qualifier("baseballCoach") Coach coachFour
    ) {
        this.coachOne = coachOne;
        this.coachTwo = coachTwo;
        this.coachThree =coachThree;
        this.coachFour = coachFour;
    }


    @GetMapping("/singleton")
    public String singleton(){
        return "coach one is the same object to coach two \n" +
                "Coach One hashCode " + this.coachOne +"same with coach Two hash code : " +  this.coachTwo  + "so its a " +   this.coachOne.equals(this.coachTwo);
    }

    @GetMapping("/prototype")
    public String prototype(){
        return "coach three is not the same object to coach four " +
                "Coach three : " + this.coachThree + " " + "Coach four : " + this.coachFour;
    }



}
