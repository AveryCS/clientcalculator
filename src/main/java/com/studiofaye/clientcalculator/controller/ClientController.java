package com.studiofaye.clientcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    public ClientController(){}

    @RequestMapping("/hello")
    public String showAllClientsTemplate(){
        return "helloooooooo SUCCESS";
    }

//    @PostMapping("/addClient")



}
