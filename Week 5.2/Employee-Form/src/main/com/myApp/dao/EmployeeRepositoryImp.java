package main.com.myApp.dao;

import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EmployeeRepositoryImp implements EmployeeRepository {


    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;




    @PostConstruct
    public void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url,username,password);

        System.out.println(String.format("Connected to database: %s", connection.toString()));
    }
    @PreDestroy
    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println(String.format("Disconnected from database: %s", connection.toString()));
    }


    @Override
    public boolean save(Employee employee) throws SQLException {
        query = "insert into employee (FIRST_NAME,LAST_NAME,EMAIL,USERNAME,PHONE_NUMBER,PASSWORD) values(?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,employee.getFirstName());
        preparedStatement.setString(2,employee.getLastName());
        preparedStatement.setString(3,employee.getEmail());
        preparedStatement.setString(4,employee.getUsername());
        preparedStatement.setString(5,employee.getPhoneNumber());
        preparedStatement.setString(6,employee.getPassword());

        int result = preparedStatement.executeUpdate();
        return result==1 ? true : false;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        query = "select * from employee where EMPLOYEE_ID=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Employee employee = new Employee();
        if(resultSet.next()) {

            employee.setId(resultSet.getInt("EMPLOYEE_ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setEmail(resultSet.getString("EMAIL"));
            employee.setUsername(resultSet.getString("USERNAME"));
            employee.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
            employee.setPassword(resultSet.getString("PASSWORD"));
        }
        else {
            throw new SQLException(String.format("Employee with id %d not found", id));
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        query = "select * from employee";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("EMPLOYEE_ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setEmail(resultSet.getString("EMAIL"));
            employee.setUsername(resultSet.getString("USERNAME"));
            employee.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
            employee.setPassword(resultSet.getString("PASSWORD"));


            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        query = "delete from employee where id=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        return result==1 ? true : false;

    }

}
