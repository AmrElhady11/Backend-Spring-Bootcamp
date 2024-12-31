package main.com.myApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Temporal(TemporalType.DATE)
    @Column(name = "production_date")
    private Date productionDate;


}
