package com.campuslands.modules.tripbooking.domain.models;

public class TripBooking {

    int id;
    String date;
    int idtrips;
    
    public TripBooking(int id, String date, int idtrips) {
        this.id = id;
        this.date = date;
        this.idtrips = idtrips;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdtrips() {
        return idtrips;
    }

    public void setIdtrips(int idtrips) {
        this.idtrips = idtrips;
    }
}
