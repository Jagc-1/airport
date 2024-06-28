package com.campuslands.modules.tripbooking.domain.models;
import java.sql.Date;


public class TripBooking {

    int id;
    Date date;
    int idtrips;
    
    public TripBooking(int id, Date date, int idtrips) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdtrips() {
        return idtrips;
    }

    public void setIdtrips(int idtrips) {
        this.idtrips = idtrips;
    }
}
