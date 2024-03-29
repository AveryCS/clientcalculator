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
    private int hoursBookedPerYear;
    private int hourlyRate;
    private String email;
    private int easeToWorkWith;
    private int clientRating;

    public int getClientRating() {
        return clientRating;
    }

    public void setClientRating(int clientRating) {
        this.clientRating = clientRating;
    }

    public Client(){}
    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public int getHoursBookedPerYear() {
        return hoursBookedPerYear;
    }

    public void setHoursBookedPerYear(int hoursBookedPerYear) {
        this.hoursBookedPerYear = hoursBookedPerYear;
    }

    public String toString(){
        return name + " "+ String.valueOf(hoursBookedPerYear)+ " "+ String.valueOf(hourlyRate);
    }

    public void updateName(String updatedName){this.name = updatedName;}
    public void updateHourlyRate(int updatedHourlyRate){ this.hourlyRate = updatedHourlyRate;}
    public void updateEaseToWorkWith(int updatedEaseToWorkWith){ this.easeToWorkWith = updatedEaseToWorkWith;}
    public void updateHoursBookedPerYear(int updatedHoursBookedPerYear){this.hoursBookedPerYear = updatedHoursBookedPerYear;}

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

//    public int calculateClientRating(){
//
//    }
}
