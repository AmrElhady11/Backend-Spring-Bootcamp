import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.DatabaseUtil;
import vehicles.Car;
import vehicles.Plane;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Car car = container.getBean("carBean",Car.class);
        car.setColor("red");
        car.setModel("BMW");
        car.setPrice("900K");
        car.setTypeOfVehicle("traveling car");
        Plane plane = container.getBean("planeBean",Plane.class);
        plane.setColor("gray");
        plane.setModel("f16");
        plane.setPrice("800M");
        plane.setTypeOfVehicle("war plane");
        try {
            boolean result = car.saveToDB();
            result =plane.saveToDB();
            if(result)
                System.out.println("the data has been stored successfully!");
            else
                System.out.println("something went Wrong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}