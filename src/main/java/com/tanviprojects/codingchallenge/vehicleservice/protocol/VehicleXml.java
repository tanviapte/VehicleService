package com.tanviprojects.codingchallenge.vehicleservice.protocol;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Vehicle")
public class VehicleXml {
    private int id;
    private int year;
    private String make;
    private String model;

    public VehicleXml(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.year = vehicle.getYear();
        this.make = vehicle.getMake();
        this.model = vehicle.getModel();
    }

    @XmlElement(name = "Id")
    public int getId() {
        return id;
    }

    @XmlElement(name = "Year")
    public int getYear() {
        return year;
    }

    @XmlElement(name = "Make")
    public String getMake() {
        return make;
    }

    @XmlElement(name = "Model")
    public String getModel() {
        return model;
    }
}
