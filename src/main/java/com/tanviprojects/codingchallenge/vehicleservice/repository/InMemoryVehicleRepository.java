package com.tanviprojects.codingchallenge.vehicleservice.repository;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class InMemoryVehicleRepository implements IVehicleRepository {
    private Vehicle v;

    public InMemoryVehicleRepository() {
        v = new Vehicle(1, 1990, "abc", "abc");
    }

    public Vehicle get(int id) {
        return v;
    }

    public List<Vehicle> getAll() {
        List<Vehicle> l = new ArrayList<>();
        l.add(v);
        return l;
    }

    public void update(Vehicle newVehicle) {

    }

    public Vehicle create(Vehicle vehicle) {
        return v;
    }

    public void delete(int id) {

    }
}
