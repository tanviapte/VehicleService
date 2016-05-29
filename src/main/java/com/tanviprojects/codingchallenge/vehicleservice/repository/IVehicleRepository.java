package com.tanviprojects.codingchallenge.vehicleservice.repository;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;

import java.util.Collection;

public interface IVehicleRepository {
    Vehicle get(int id);
    Collection<Vehicle> getAll();
    void update(Vehicle newVehicle);
    Vehicle create(Vehicle vehicle);
    boolean delete(int id);
}
