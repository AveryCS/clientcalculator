package com.studiofaye.clientcalculator.controller;

import com.studiofaye.clientcalculator.calculators.ClientRatingCalculator;
import com.studiofaye.clientcalculator.entities.Client;
import com.studiofaye.clientcalculator.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        if (clientRepo.existsByEmailIgnoreCase(newClient.getEmail())) {
            throw new RuntimeException("Client is already in database");
        }
        newClient.setClientRating(clientCalc.calculateClientRating(newClient));
        Client savedClient = clientRepo.save(newClient);
        return ResponseEntity.ok(savedClient);
    }

    //Update hoursBookedPerYear
    @Transactional
    @PatchMapping("/client/{id}/hoursBookedPerYear/{hoursBookedPerYear}")
    public ResponseEntity<Client> updateClientHours(@PathVariable long id, @PathVariable int hoursBookedPerYear) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateHoursBookedPerYear(hoursBookedPerYear);
            updatedClient.setClientRating(clientCalc.calculateClientRating(updatedClient));
            Client savedClient = clientRepo.save(updatedClient);
            clientRepo.save(savedClient);
            return ResponseEntity.ok(savedClient);
        }
        //FIXED (ASmith) My curl request isn't returning a 404 not found error in the terminal. Look into why
        return ResponseEntity.notFound().build();
    }

    //FIXED ADD A @TRANSACTIONAL ANNOTATION AND LEARN ABOUT IT
    //update hourlyRate
    @Transactional
    @PatchMapping("/client/{id}/hourlyRate/{hourlyRate}")
    public ResponseEntity<Client> updateRevenue(@PathVariable long id, @PathVariable int hourlyRate) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateHourlyRate(hourlyRate);
            updatedClient.setClientRating(clientCalc.calculateClientRating(updatedClient));
            Client savedClient = clientRepo.save(updatedClient);
            clientRepo.save(savedClient);
            return ResponseEntity.ok(savedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //updateName
    @Transactional
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
    @Transactional
    @PatchMapping("/client/{id}/easeToWorkWith/{easeToWorkWith}")
    public ResponseEntity<Client> updateEaseToWorkWith(@PathVariable long id, @PathVariable int easeToWorkWith) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client updatedClient = maybeClient.get();
            updatedClient.updateEaseToWorkWith(easeToWorkWith);
            updatedClient.setClientRating(clientCalc.calculateClientRating(updatedClient));
            Client savedClient = clientRepo.save(updatedClient);
            clientRepo.save(savedClient);
            return ResponseEntity.ok(savedClient);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete client
    @DeleteMapping("/client/{id}")
    //FIXED RETURN THE CLIENT THAT WAS JUST DELETED
    public ResponseEntity<Client> deleteClient(@PathVariable long id) {
        Optional<Client> maybeClient = clientRepo.findById(id);
        if (maybeClient.isPresent()) {
            Client deletedClient = maybeClient.get();
            clientRepo.delete(deletedClient);
            return ResponseEntity.ok(deletedClient);
        }
        return ResponseEntity.notFound().build();
    }


    //Search clients by rating
    @GetMapping("/clients")
    //TODO Look back over this and better understand @RequestParam
    public ResponseEntity<List<Client>> getAllClientsByRating(@RequestParam(required = false) Integer rating) {
        //FIXED see if I can query the database, rather than iterating over the clientRepo
        if (rating == null) {
            return ResponseEntity.ok(clientRepo.findAll());
        }
        List<Client> list = clientRepo.findByClientRating(rating);
        return ResponseEntity.ok(list);
    }
}
