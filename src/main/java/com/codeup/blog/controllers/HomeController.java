package com.codeup.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "This is the landing page!";
    }

}  // HomeController
