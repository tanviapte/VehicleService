package com.tanviprojects.codingchallenge.vehicleservice.repository;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;
import java.util.List;

public interface IVehicleRepository {
    public Vehicle get(int id);
    public List<Vehicle> getAll();
    public void update(Vehicle newVehicle);
    public Vehicle create(Vehicle vehicle);
    public void delete(int id);
}
