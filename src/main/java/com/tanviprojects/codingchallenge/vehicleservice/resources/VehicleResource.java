package com.tanviprojects.codingchallenge.vehicleservice.resources;

import com.tanviprojects.codingchallenge.vehicleservice.protocol.json.Vehicle;
import com.tanviprojects.codingchallenge.vehicleservice.repository.IVehicleRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("vehicles")
public class VehicleResource {
    private IVehicleRepository repository;

    public VehicleResource(IVehicleRepository repository) {
        this.repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getall() {
        return repository.getAll().stream().map(
            vehicle -> new Vehicle(vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel())
        ).collect(Collectors.toList());
    }
}
