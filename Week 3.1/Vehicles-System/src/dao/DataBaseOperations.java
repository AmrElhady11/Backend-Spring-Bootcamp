package dao;

import lombok.Data;
import models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Data
public class DataBaseOperations {
    private String url;
    private String username ;
    private String password;
    private Connection connection;

    public DataBaseOperations(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

    }

    public void connectToDataBase(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException|ClassNotFoundException e) {
             e.printStackTrace();
        }

    }
    public void  disconnectFromDataBase(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Vehicle seve(Vehicle vehicle) throws SQLException {
        String statement = "insert into test.vehicles(vehicle_name,brand,type)Values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setString(1,vehicle.getVehicleName());
        preparedStatement.setString(2,vehicle.getBrand());
        preparedStatement.setString(3,vehicle.getType());
       int result= preparedStatement.executeUpdate();

         return result==1 ? vehicle : null;

    }


}
