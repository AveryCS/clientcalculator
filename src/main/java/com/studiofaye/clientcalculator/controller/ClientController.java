package com.studiofaye.clientcalculator.controller;

import com.studiofaye.clientcalculator.entities.Client;
import com.studiofaye.clientcalculator.repos.ClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client newClient){
        //TODO(ASmith) is there a way to not iterate over the client repo / find by a specific field for a faster lookup
        for(Client client :clientRepo.findAll()){
            if(client.getEmail().equalsIgnoreCase(newClient.getEmail())){
                //TODO(ASmith) how do I handle these exceptions in a more RESTful way?
                throw new RuntimeException("Client is already in database");
            }
        }
       Client savedClient = clientRepo.save(newClient);
      return ResponseEntity.ok().body(savedClient);
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
