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
    private String email;
    private int easeToWorkWith;

    public Client(){}



    public String toString(){
        return name + " "+ String.valueOf(hours)+ " "+ String.valueOf(yearlyRevenue);
    }

    public void updateName(String updatedName){this.name = updatedName;}

    public void updateHours(int updatedHours){ this.hours = updatedHours;}
    public void updateYearlyRevenue(float updatedYearlyRevenue){ this.yearlyRevenue = updatedYearlyRevenue;}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEaseToWorkWith() {
        return easeToWorkWith;
    }

    public void setEaseToWorkWith(int easeToWorkWith) {
        this.easeToWorkWith = easeToWorkWith;
    }
}
