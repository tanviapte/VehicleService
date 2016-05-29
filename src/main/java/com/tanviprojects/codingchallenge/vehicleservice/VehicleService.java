package com.tanviprojects.codingchallenge.vehicleservice;

import com.tanviprojects.codingchallenge.vehicleservice.configuration.VehicleServiceConfiguration;
import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;
import com.tanviprojects.codingchallenge.vehicleservice.repository.IVehicleRepository;
import com.tanviprojects.codingchallenge.vehicleservice.repository.InMemoryVehicleRepository;
import com.tanviprojects.codingchallenge.vehicleservice.resources.VehicleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VehicleService extends Application<VehicleServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new VehicleService().run(args);
    }

    public void run(VehicleServiceConfiguration vehicleServiceConfiguration, Environment environment) throws Exception {
        ConcurrentMap<Integer, Vehicle> vehicleStore = new ConcurrentHashMap<>();
        IVehicleRepository vehicleRepo = new InMemoryVehicleRepository(vehicleStore);
        final VehicleResource resource = new VehicleResource(vehicleRepo);
        environment.jersey().register(resource);
    }
}
