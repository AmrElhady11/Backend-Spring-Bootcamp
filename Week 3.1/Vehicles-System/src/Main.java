import controller.CarController;
import controller.MotorBikeController;
import controller.PlaneController;
import controller.VehiclesController;
import dao.DataBaseOperations;
import models.Car;
import models.MotorBike;
import models.Plane;
import models.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container= new ClassPathXmlApplicationContext("applicatioon.xml");

        Car car = container.getBean("car", Car.class);
        Plane plane = container.getBean("plane", Plane.class);
        MotorBike motorBike = container.getBean("motorBike", MotorBike.class);
        car.setBrand("BMW");
        car.setType("racing car");
        plane.setBrand("Boeing");
        plane.setType("traveling plane");
        motorBike.setBrand("harley");
        motorBike.setType("personal motorBike");
        VehiclesController carController = container.getBean("carController",CarController.class);
        VehiclesController planeController = container.getBean("planeController", PlaneController.class);
        VehiclesController motorBikeController = container.getBean("motorBikeController", MotorBikeController.class);
        carController.saveVehicle(car);
        planeController.saveVehicle(plane);
        motorBikeController.saveVehicle(motorBike                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               );


    }
}