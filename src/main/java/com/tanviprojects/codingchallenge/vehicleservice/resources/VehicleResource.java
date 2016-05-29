package com.tanviprojects.codingchallenge.vehicleservice.resources;

import com.tanviprojects.codingchallenge.vehicleservice.protocol.ArrayOfVehiclesXml;
import com.tanviprojects.codingchallenge.vehicleservice.protocol.VehicleJson;
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
    public List<VehicleJson> getAllJson() {
        return repository.getAll().stream().map(
            vehicle -> new VehicleJson(vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel())
        ).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayOfVehiclesXml getAllXml() {
        return new ArrayOfVehiclesXml(repository.getAll());
    }
}
