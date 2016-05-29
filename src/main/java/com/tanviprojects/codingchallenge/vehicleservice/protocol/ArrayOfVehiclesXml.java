package com.tanviprojects.codingchallenge.vehicleservice.protocol;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.stream.Collectors;


@XmlRootElement(name = "ArrayOfVehicles", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayOfVehiclesXml {
    @XmlElement(name = "Vehicle")
    private Collection<ArrayVehicle> vehicles;

    public ArrayOfVehiclesXml() { }

    public ArrayOfVehiclesXml(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles.stream().map(
                vehicle -> new ArrayVehicle(vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel())
        ).collect(Collectors.toList());
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    private static class ArrayVehicle {
        @XmlElement(name = "Id")
        private int id;

        @XmlElement(name = "Year")
        private int year;

        @XmlElement(name = "Make")
        private String make;

        @XmlElement(name = "Model")
        private String model;

        ArrayVehicle(int id, int year, String make, String model) {
            this.id = id;
            this.year = year;
            this.make = make;
            this.model = model;
        }
    }
}
