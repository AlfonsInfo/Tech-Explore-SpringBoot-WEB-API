package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {


    @GetMapping(EndPointConstant.PATH_VARIABLE)
    public String order(
            @PathVariable("orderId") String orderId,
            @PathVariable("productId") String productId
    ){
        return "Order : " + orderId + " Product : " + productId;
    }

}
