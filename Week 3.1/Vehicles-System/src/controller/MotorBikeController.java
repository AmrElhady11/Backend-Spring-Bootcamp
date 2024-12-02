package controller;

import dao.DataBaseOperations;
import models.Vehicle;

import java.sql.SQLException;

public class MotorBikeController implements VehiclesController  {
    private DataBaseOperations dataBaseOperations;

    public MotorBikeController(DataBaseOperations dataBaseOperations) {
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
