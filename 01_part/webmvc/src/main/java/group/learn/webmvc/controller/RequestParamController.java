package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import group.learn.webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RequestParamController {

    @Autowired
    private HelloService helloService;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");


    @GetMapping(path = EndPointConstant.REQUEST_PARAM)
    public void requestParam(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

//    @GetMapping(path = EndPointConstant.REQUEST_PARAM)
//    @ResponseBody
//    public String requestParamWithResponseBody(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        return helloService.hello(name);
//
//    }


    //Input nya String -> langsung konversi ke Date....
    @GetMapping(path = EndPointConstant.REQUEST_PARAM_CONVERTER)
    public void requestParamConverter(
            @RequestParam(name = "date") Date date,
            HttpServletResponse response
    ) throws IOException {
        response.getWriter().println("Date : " + dateFormat.format(date));
    }

}
