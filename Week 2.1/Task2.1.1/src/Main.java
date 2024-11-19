import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Shape shape = container.getBean("circle", Circle.class);
       shape.draw2DShape();
       shape.draw3DShape();
        Shape shape1 = container.getBean("square", Square.class);
        shape1.draw2DShape();
        shape1.draw3DShape();
    }
}