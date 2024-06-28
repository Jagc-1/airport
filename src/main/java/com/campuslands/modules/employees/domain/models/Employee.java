package com.campuslands.modules.employees.domain.models;

public class Employee {

    int id;
    String name;
    String email;
    String ingressdate;
    int idairline;
    int idairport;
    String password;
    int idrol;

    public Employee(int id, String name, String email, String ingressdate, int idairline, int idairport,
            String password, int idrol) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ingressdate = ingressdate;
        this.idairline = idairline;
        this.idairport = idairport;
        this.password = password;
        this.idrol = idrol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getIngressdate() {
        return ingressdate;
    }

    public void setIngressdate(String ingressdate) {
        this.ingressdate = ingressdate;
    }

    public int getIdairline() {
        return idairline;
    }

    public void setIdairline(int idairline) {
        this.idairline = idairline;
    }

    public int getIdairport() {
        return idairport;
    }

    public void setIdairport(int idairport) {
        this.idairport = idairport;
    }

}
