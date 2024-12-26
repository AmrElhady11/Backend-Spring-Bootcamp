package main.com.myApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String emeil;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmeil(String emeil) {
        this.emeil = emeil;
    }

    public User(String name, String emeil) {
        this.name = name;
        this.emeil = emeil;
    }

    public User() {

    }
}
