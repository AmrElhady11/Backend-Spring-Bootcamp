package main.com.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    @Size(min =0,max = 25 ,message = "Your first name is too long")
    private String firstName;
    @Size(min =0,max = 25 ,message = "Your Last name is too long")
    private String lastName;
    @Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{3,}$", message ="Enter a valid email" )
    @NotEmpty(message = "email is required")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$\n", message ="Make your password strong by using characters (uppercase & lowercase),digits and symbols " )
    private String password;
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message ="Use only characters,digits and_ only" )
    @NotEmpty
    private String username;
    @Pattern(regexp = "^(011|015|010|012)\\d{7}$", message ="Enter a valid number" )
    @Size(min =11,max = 11 ,message = "Your phone number must not be more or less than 11 digits")
    private String phoneNumber;

}
