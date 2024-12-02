package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DataBaseOperations;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class CarController implements VehiclesController {
    private DataBaseOperations dataBaseOperations;
    @Autowired
    public CarController(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        try {
            dataBaseOperations.seve(vehicle);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
