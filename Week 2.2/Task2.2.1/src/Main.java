import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Shape shape = container.getBean("circle", Circle.class);
        Shape shape1 = container.getBean("circle", Circle.class);
        if(shape1 == shape)
            System.out.println("singleton scope is activated");
        Shape shape2 = container.getBean("square", Square.class);
        Shape shape3 = container.getBean("square", Square.class);
        if(shape3 != shape2)
            System.out.println("prototype scope is activated");
    }
}