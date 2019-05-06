package com.codeup.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



    @Controller
    public class MathController {

        @GetMapping("/add/{input1}/and/{input2}")
        @ResponseBody
        public String add(@PathVariable int input1,@PathVariable int input2){
            return String.valueOf(input1 + input2);
        }


        @GetMapping("/sub/{input2}/from/{input1}")
        @ResponseBody
        public String sub(@PathVariable int input1,@PathVariable int input2){
            return String.valueOf(input1 - input2);
        }


        @GetMapping("/multi/{input1}/and/{input2}")
        @ResponseBody
        public String multi(@PathVariable int input1,@PathVariable int input2){
            return String.valueOf(input1 * input2);
        }


        @GetMapping("/div/{input1}/by/{input2}")
        @ResponseBody
        public String div(@PathVariable int input1,@PathVariable int input2){
            return String.valueOf(input1/input2);
        }

    }  // MathController class




