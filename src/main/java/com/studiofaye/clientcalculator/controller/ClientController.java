package com.studiofaye.clientcalculator.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.studiofaye.clientcalculator.entities.Client;
import com.studiofaye.clientcalculator.repos.ClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
      return ResponseEntity.ok(savedClient);
    }

    //Get current client
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getSingleClient(@PathVariable long id){
       Optional <Client> maybeClient = clientRepo.findById(id);
       if( maybeClient.isPresent()){
           Client existingClient = maybeClient.get();
           return ResponseEntity.ok(existingClient);
       }
        return ResponseEntity.notFound().build();

    }

    //Update client
    //Update hours
    @PatchMapping("/client/{id}/hours/{hours}")
    public ResponseEntity<Client> updateClientHours(@PathVariable long id, @PathVariable int hours){

        Optional<Client> maybeClient= clientRepo.findById(id);
        if(maybeClient.isPresent()){
            Client updatedClient = maybeClient.get();
            updatedClient .updateHours(hours);
            clientRepo.save(updatedClient );
            return ResponseEntity.ok(updatedClient );
        }
        //TODO(ASmith) My curl request isn't returning a 404 not found error in the terminal. Look into why
            return ResponseEntity.notFound().build();
    }

    //update Revenue
    @PatchMapping("/client/{id}/revenue/{revenue}")
    public ResponseEntity<Client> updateRevenue(@PathVariable long id, @PathVariable float revenue){
        Optional<Client> maybeClient = clientRepo.findById(id);
        if(maybeClient.isPresent()){
            Client updatedClient = maybeClient.get();
            updatedClient.updateYearlyRevenue(revenue);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //updateName
    @PatchMapping("/client/{id}/name/{name}")
    public ResponseEntity<Client> updateName(@PathVariable long id, @PathVariable String name){
        Optional<Client> maybeClient = clientRepo.findById(id);
        if(maybeClient.isPresent()){
            Client updatedClient = maybeClient.get();
            updatedClient.updateName(name);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //updateEaseToWorkWith
    @PatchMapping("/client/{id}/easeToWorkWith/{easeToWorkWith}")
    public ResponseEntity<Client> updateEaseToWorkWith(@PathVariable long id, @PathVariable int easeToWorkWith){
        Optional<Client> maybeClient = clientRepo.findById(id);
        if(maybeClient.isPresent()){
            Client updatedClient = maybeClient.get();
            updatedClient.updateEaseToWorkWith(easeToWorkWith);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }


    //Search clients by rating
    //@GetMapping(/"searchByRating")


    //Delete client
    //@DeleteMapping("/deleteClient)

    //Show list of all clients
    //@GetMapping("/showAllClientInfo")

    //add client




}
