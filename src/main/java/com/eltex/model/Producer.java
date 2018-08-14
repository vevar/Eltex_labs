package com.eltex.model;


import java.io.Serializable;

/***
 * Model of producer
 */
public class Producer implements Serializable {

    private int id;
    private String name;

    public Producer() {
    }

    public Producer(String name) {
        this.name = name;
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
}
