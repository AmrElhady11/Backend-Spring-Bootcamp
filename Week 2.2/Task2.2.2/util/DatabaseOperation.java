package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperation {
    private String url;
    private String password;
    private String username;
    private Connection connection;

    public DatabaseOperation(String url, String password, String username) {
        this.url = url;
        this.password = password;
        this.username = username;

        }


    public void connectToDataBase(){
        System.out.println("connect to database "+url);
    }
    public void disconnectFromDataBase(){
        System.out.println("Disconnect from database "+url);
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

}