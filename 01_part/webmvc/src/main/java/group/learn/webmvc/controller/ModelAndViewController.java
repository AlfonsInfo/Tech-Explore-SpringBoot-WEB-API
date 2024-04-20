package group.learn.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ModelAndViewController {

    @GetMapping(path = "/model-view")
    @ResponseBody
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name){
        return new ModelAndView("hello", Map.of("title", "Vieww", "name",name));
    }



    @GetMapping(path = "/model-view/redirect")
    @ResponseBody
    public ModelAndView redirectHello(@RequestParam(name = "name", required = false) String name){
        if(name == null){
            return new ModelAndView("redirect:/model-view?name=Guest");
        }else {
            return new ModelAndView("hello", Map.of("title", "Vieww", "name",name));
        }
    }
}
