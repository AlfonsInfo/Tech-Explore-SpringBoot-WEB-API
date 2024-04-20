package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class RequestMappingController {

    @RequestMapping(path = EndPointConstant.REQUEST_MAPPING)
    public void requestMapping(HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>Hello from request-mapping</h1>");
    }


    //not working except restcontroller ?
    @RequestMapping(path = EndPointConstant.REQUEST_MAPPING_RETURN) // not works if annotate by @Controller but works when annotate with @RestController
    public String requestMapping2() throws IOException {
        return "<h1>Hello from request-mapping-return</h1>";
    }
}
