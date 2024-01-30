package com.example.springproject.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Order")
public class OrderController {
   @PostMapping
    public String getOrder(){
        return "Order";
    }


}
