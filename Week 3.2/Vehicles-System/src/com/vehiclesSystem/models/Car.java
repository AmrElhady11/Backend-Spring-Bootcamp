package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DataBaseOperations;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car implements Vehicle {
    private String id;
    private String type;
    private String brand;
    private DataBaseOperations dataBaseOperations;


    @Autowired
    public Car(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    @Override
    public String getVehicleName() {
        return String.format("Name = Car , type = %s",type);
    }
}
