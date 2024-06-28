package com.campuslands.modules.customers.domain.models;

public class Customer {
    int id;
    String name;
    int age;
    int id_document_type;
    String id_document;
    String password;
    String email;

    public Customer(String name, int age, int id_document_type, String id_document, String password, String email) {
        this.name = name;
        this.age = age;
        this.id_document_type = id_document_type;
        this.id_document = id_document;
        this.password = password;
        this.email = email;
    }

    public Customer(int id, String name, int age, int id_document_type, String id_document, String password,
            String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.id_document_type = id_document_type;
        this.id_document = id_document;
        this.password = password;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_document_type() {
        return id_document_type;
    }

    public void setId_document_type(int id_document_type) {
        this.id_document_type = id_document_type;
    }

    public String getId_document() {
        return id_document;
    }

    public void setId_document(String id_document) {
        this.id_document = id_document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}