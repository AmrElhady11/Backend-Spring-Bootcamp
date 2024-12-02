import com.vehiclesSystem.config.VehicleConfig;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.MotorBikeController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.controller.VehiclesController;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.MotorBike;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container= new AnnotationConfigApplicationContext(VehicleConfig.class);

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
        motorBikeController.saveVehicle(motorBike);

        ((AnnotationConfigApplicationContext) (container)).close();

    }
}