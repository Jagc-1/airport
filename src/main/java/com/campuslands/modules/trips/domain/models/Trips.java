package com.campuslands.modules.trips.domain.models;

import java.sql.Date;

public class Trips {

    int id;
    Date date;
    double price;
    String departure_airport;
    String arrival_airport;

    public Trips(int id, Date date, double price, String departure_airport, String arrival_airport) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
    }

    public Trips(Date date, double price, String departure_airport, String arrival_airport) {
        //this.id = id;
        this.date = date;
        this.price = price;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

}