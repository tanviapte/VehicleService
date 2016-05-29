package com.tanviprojects.codingchallenge.vehicleservice.repository;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

public class InMemoryVehicleRepository implements IVehicleRepository {
    private ConcurrentMap<Integer,Vehicle> vehicles;
    private static int currentId = 0;

    public InMemoryVehicleRepository(ConcurrentMap<Integer, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle get(int id) {
        return vehicles.get(id);
    }

    public Collection<Vehicle> getAll() {
        return Collections.list(Collections.enumeration(vehicles.values()));
    }

    public void update(Vehicle newVehicle) {
        int newId = newVehicle.getId();
        if(vehicles.containsKey(newId)) {
            vehicles.put(newId, newVehicle);
        } else {
            throw new NoSuchElementException("vehicle id " + newId + " doesn't exist");
        }
    }

    public Vehicle create(Vehicle vehicle) {
        boolean created = false;
        while(!created) {
            vehicle.setId(++currentId);
            created = (vehicles.putIfAbsent(vehicle.getId(), vehicle) == null);
        }
        return vehicle;
    }

    public boolean delete(int id) {
        return vehicles.remove(id) != null;
    }
}
