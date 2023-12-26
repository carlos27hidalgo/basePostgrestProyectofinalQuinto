package com.desarrollo.basePostgrest.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/home")
    public String home(){

        return "home";
    }

}
