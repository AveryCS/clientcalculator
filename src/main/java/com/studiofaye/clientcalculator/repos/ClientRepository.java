package com.studiofaye.clientcalculator.repos;

import com.studiofaye.clientcalculator.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByClientRating(int rating);
}
