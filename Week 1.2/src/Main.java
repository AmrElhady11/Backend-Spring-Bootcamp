import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Shape shape = container.getBean("circle", Circle.class);
        System.out.println(shape.getArea(3));
        Shape shape1 = container.getBean("square", Square.class);
        System.out.println(shape1.getArea(3));
    }
}