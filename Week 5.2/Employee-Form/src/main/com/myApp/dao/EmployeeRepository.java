package main.com.myApp.dao;

import main.com.myApp.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    boolean save(Employee employee) throws SQLException;
    Employee findById(int id) throws SQLException;
    List<Employee> findAll() throws SQLException;
    boolean delete(int id) throws SQLException;


}
