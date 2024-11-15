package vehicles;

import util.DatabaseUtil;

import java.sql.SQLException;

public class Plane implements Vehicle {
    private String model;
    private String price;
    private String color;
    private String typeOfVehicle;
    private DatabaseUtil databaseUtil;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public void setDatabaseUtil(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    @Override
    public boolean saveToDB() throws SQLException {
        if(model==null||price==null||color==null||typeOfVehicle==null)
            return false;
        return databaseUtil.addVehicle(model,price,color,typeOfVehicle);

    }
}
