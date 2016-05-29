package com.tanviprojects.codingchallenge.vehicleservice;

import com.tanviprojects.codingchallenge.vehicleservice.configuration.VehicleServiceConfiguration;
import com.tanviprojects.codingchallenge.vehicleservice.repository.InMemoryVehicleRepository;
import com.tanviprojects.codingchallenge.vehicleservice.resources.VehicleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class VehicleService extends Application<VehicleServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new VehicleService().run(args);
    }

    public void run(VehicleServiceConfiguration vehicleServiceConfiguration, Environment environment) throws Exception {
        final VehicleResource resource = new VehicleResource(new InMemoryVehicleRepository());
        environment.jersey().register(resource);
    }
}
