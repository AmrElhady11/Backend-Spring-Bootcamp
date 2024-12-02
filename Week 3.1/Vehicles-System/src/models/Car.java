package models;

import dao.DataBaseOperations;

public class Car implements Vehicle {
    private String id;
    private String type;
    private String brand;
    private DataBaseOperations dataBaseOperations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    @Override
    public String getVehicleName() {
        return String.format("Name = Car , type = %s",type);
    }
}
