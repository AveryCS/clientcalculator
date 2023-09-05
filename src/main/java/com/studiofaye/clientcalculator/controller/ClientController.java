package com.studiofaye.clientcalculator.controller;

import com.studiofaye.clientcalculator.entities.Client;
import com.studiofaye.clientcalculator.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepo;

    public ClientController(){}

    @RequestMapping("/hello")
    public String showAllClientsTemplate(){
        return "helloooooooo SUCCESS";
    }

    //Add new client
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client newClient){
        System.out.println(newClient.toString());
       Client tempClient = clientRepo.save(newClient);
      return tempClient;
    }

    //Get current client
    @GetMapping("/getClientInfo/{id}")
    public String getSingleClient(@PathVariable long id){
        return "Show info for " + id; //+ database.findById() name and all other info

    }

    //Update client
    //Update Hours
//    @PatchMapping("/updateClientInfo/hours/{id}/")
//    public ResponseEntity<Client> updateClientHours(@PathVariable long id, int hours){
//
//        Client newClient = database.findById.get()
//        newClient.updateHours
//        clientRepo.save
//         return newClient

//    }

    //update Revenue
//    @PatchMapping("/updateClientInfo/yearlyRevenue/{id}/")
//    public ResponseEntity<Client> updaterevenue(@PathVariable long id, float updatedRevenue){
//
//
//    }

    //Search clients by rating
    //@GetMapping(/"searchByRating")


    //Delete client
    //@DeleteMapping("/deleteClient)

    //Show list of all clients
    //@GetMapping("/showAllClientInfo")

    //add client




}
