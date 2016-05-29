package com.tanviprojects.codingchallenge.vehicleservice.protocol.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tanviapte on 5/28/16.
 */
public class Vehicle {
    private int id;
    private int year;
    private String make;
    private String model;

    public Vehicle(int id, int year, String make, String model) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    @JsonProperty("Year")
    public int getYear() {
        return year;
    }

    @JsonProperty("Make")
    public String getMake() {
        return make;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }
}
