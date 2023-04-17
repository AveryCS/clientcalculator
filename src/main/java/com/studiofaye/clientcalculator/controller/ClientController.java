package com.studiofaye.clientcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    public ClientController(){}

    @RequestMapping("/hello")
    public String showAllClientsTemplate(){
        return "helloooooooo SUCCESS";
    }

    //Add new client
//    @PostMapping("/addClient")

    //Get current client
    @GetMapping("/getClientInfo/{id}")
    public String getSingleClient(@PathVariable long id){
        return "Show info for " + id; //+ database.findById() name and all other info

    }

    //Update client
    //@PatchMapping("/updateClientInfo")

    //Search clients by rating
    //@GetMapping(/"searchByRating")


    //Delete client
    //@DeleteMapping("/deleteClient)

    //Show list of all clients
    //@GetMapping("/showAllClientInfo")




}
