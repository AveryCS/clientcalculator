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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public float getYearlyRevenue() {
        return yearlyRevenue;
    }

    public void setYearlyRevenue(float yearlyRevenue) {
        this.yearlyRevenue = yearlyRevenue;
    }
}
