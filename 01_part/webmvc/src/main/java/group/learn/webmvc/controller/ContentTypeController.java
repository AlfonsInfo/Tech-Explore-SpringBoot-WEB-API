package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody

@RestController
public class ContentTypeController {


    @PostMapping(path = EndPointConstant.FORM_CONTENT_TYPE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String helloForm(@RequestParam(name = "name") String name){
        return "Hello " + name;
    }


    @PostMapping(
            path = EndPointConstant.RESPONSE_CONTENT_TYPE,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    public String hello(@RequestParam(name = "name") String name){
        return """
                <html>
                    <body>
                    <h1>Hello $name</h1>
                    </body>
                </html>
                """.replace("$name",name);
    }
}
