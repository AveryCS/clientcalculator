package com.studiofaye.clientcalculator.repos;

import com.studiofaye.clientcalculator.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
