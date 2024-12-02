package models;

import dao.DataBaseOperations;



public class Plane implements Vehicle{
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

    public DataBaseOperations getDataBaseOperations() {
        return dataBaseOperations;
    }

    public void setDataBaseOperations(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    public Plane(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    @Override
    public String getVehicleName() {
        return String.format("Name = Plane , type = %s",type);
    }
}
