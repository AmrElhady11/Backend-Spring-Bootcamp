package main.com.myApp.Models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    private String name;
    private String password;
    private String nation;
    private String programmingLanguage;
    private String OS ;

}
