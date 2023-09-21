package com.studiofaye.clientcalculator.controller;

import com.studiofaye.clientcalculator.calculators.ClientRatingCalculator;
import com.studiofaye.clientcalculator.entities.Client;
import com.studiofaye.clientcalculator.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private ClientRatingCalculator clientCalc;

    public ClientController() {
    }

    @RequestMapping("/hello")
    public String showAllClientsTemplate() {
        return "helloooooooo SUCCESS";
    }

    //Get current client
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getSingleClient(@PathVariable long id) {
        Optional<Client> maybeClient = clientRepo.findById(id);

        return maybeClient.isPresent() ? ResponseEntity.ok(maybeClient.get()) : ResponseEntity.notFound().build();
    }

    //Add new client
    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client newClient) {
        //TODO(ASmith) is there a way to not iterate over the client repo / find by a specific field for a faster lookup
        if (clientRepo.existsByEmailIgnoreCase(newClient.getEmail())) {
            throw new RuntimeException("Client is already in database");
        }
        newClient.setClientRating(clientCalc.calculateClientRating(newClient));
        Client savedClient = clientRepo.save(newClient);
        return ResponseEntity.ok(savedClient);
    }


    //Update client
    //Update hoursBookedPerYear
    @PatchMapping("/client/{id}/hoursBookedPerYear/{hoursBookedPerYear}")
    public ResponseEntity<Client> updateClientHours(@PathVariable long id, @PathVariable int hoursBookedPerYear) {

        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateHoursBookedPerYear(hoursBookedPerYear);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        //TODO(ASmith) My curl request isn't returning a 404 not found error in the terminal. Look into why
        return ResponseEntity.notFound().build();
    }

    //update hourlyRate
    @PatchMapping("/client/{id}/hourlyRate/{hourlyRate}")
    public ResponseEntity<Client> updateRevenue(@PathVariable long id, @PathVariable int hourlyRate) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateHourlyRate(hourlyRate);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //updateName
    @PatchMapping("/client/{id}/name/{name}")
    public ResponseEntity<Client> updateName(@PathVariable long id, @PathVariable String name) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateName(name);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //updateEaseToWorkWith
    @PatchMapping("/client/{id}/easeToWorkWith/{easeToWorkWith}")
    public ResponseEntity<Client> updateEaseToWorkWith(@PathVariable long id, @PathVariable int easeToWorkWith) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateEaseToWorkWith(easeToWorkWith);
            clientRepo.save(updatedClient);
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete client
    @DeleteMapping("/client/{id}")
    //TODO RETURN THE CLIENT THAT WAS JUST DELETED
    public void deleteClient(@PathVariable long id) {
        clientRepo.deleteById(id);
        return;
    }

    //Show list of all clients
//    @GetMapping("/clients")
//    public ResponseEntity<Iterable<Client>> getAllClients(){
//        Iterable<Client>  clientList = clientRepo.findAll();
//        return   ResponseEntity.ok(clientList);
//
//    }


    //Search clients by rating
    @GetMapping("/clients")
    //TODO Look back over this and better understand @RequestParam
    public ResponseEntity<List<Client>> getAllClientsByRating(@RequestParam(required = false) Integer rating) {
        //TODO see if I can query the database, rather than iterating over the clientRepo
        if (rating == null) {

            return ResponseEntity.ok(clientRepo.findAll());

        }
        List<Client> list = clientRepo.findByClientRating(rating);
        return ResponseEntity.ok(list);

    }

}
