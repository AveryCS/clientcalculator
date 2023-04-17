package com.studiofaye.clientcalculator.entities;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;

    public Client(){}
}
