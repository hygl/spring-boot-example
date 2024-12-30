package de.ble.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @GetMapping("/")
    public String index() {
	    return "Hello World!";
    }

    @PostMapping("/")
    public String form(){
        return "";
    }
}
