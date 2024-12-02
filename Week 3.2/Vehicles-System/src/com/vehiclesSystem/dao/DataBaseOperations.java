package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class DataBaseOperations {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username ;
    @Value(value = "${database.password}")
    private String password;
    private Connection connection;


    @PostConstruct
    public void connectToDataBase(){
        System.out.format("connecting to darabase mysql url = %s\n",url);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url,username,password);
            System.out.format("connecting to darabase successfully username = %s\n",username);
        } catch (SQLException|ClassNotFoundException e) {
             e.printStackTrace();
        }

    }
    @PreDestroy
    public void  disconnectFromDataBase(){
        try {
            connection.close();
            System.out.format("disconnect from database ");
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
