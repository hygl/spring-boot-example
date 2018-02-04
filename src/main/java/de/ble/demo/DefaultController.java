package de.ble.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DefaultController{

    @GetMapping("/test")
    public  @ResponseBody String  getMethodName(@RequestParam String param) {
        return param.toUpperCase();
    }
    
}