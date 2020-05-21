package com.example.projektGrupowy.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

// Serializable - uzywane do obiektow ktore chcemy udostepnic/przeslac (w sieci)
@JsonAutoDetect
public class Cart implements Serializable {


    private String name;
    private long id;


    public Cart(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Cart() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
