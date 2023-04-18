package com.studiofaye.clientcalculator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int hours;
    private float yearlyRevenue;

    public Client(){}

    public String toString(){
        return name + " "+ String.valueOf(hours)+ " "+ String.valueOf(yearlyRevenue);
    }

    public void updateName(String updatedName){name = updatedName;}

    public void updateHours(int updatedHours){ hours = updatedHours;}
}
