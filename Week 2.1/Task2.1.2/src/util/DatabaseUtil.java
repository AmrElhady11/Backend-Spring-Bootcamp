package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
    private String url;
    private String password;
    private String username;
    private Connection connection;

    public DatabaseUtil(String url, String password, String username) {
        this.url = url;
        this.password = password;
        this.username = username;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.getUrl(),this.getUsername(),this.getPassword());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean addVehicle(String model,String price,String color,String typeOfVehicle) throws SQLException {
        try {


            String statement = "insert into test.vehicles(MODLE,PRICE,Color,TYPE_OF_Vehicle)Values(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(statement);
            pst.setString(1, model);
            pst.setString(2, price);
            pst.setString(3, color);
            pst.setString(4, typeOfVehicle);
            int result = pst.executeUpdate();
            return result==1 ? true : false;
        }
        catch(Exception e){
            return false;


        }
    }
}