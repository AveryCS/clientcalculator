package com.studiofaye.clientcalculator.repos;

import com.studiofaye.clientcalculator.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByClientRating(int rating);
    List<Client> findAll();
    boolean existsByEmailIgnoreCase(String email);

}



//    @Query("SELECT client.clientRating FROM Client client WHERE client.clientRating = :specificValue")
//    List<String> findByClientRating(@Param("specificValue") int specificValue);
//}
