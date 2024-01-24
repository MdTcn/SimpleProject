package com.mtacine.simpleproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/information")
public class InformationController {

    @GetMapping
    public String informationApp(){
        return "Welcome to your Information project";
    }
}
