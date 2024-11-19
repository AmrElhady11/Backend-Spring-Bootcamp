import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;
import util.DatabaseOperation;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DatabaseOperation databaseOperation = container.getBean("databaseOperationBean",DatabaseOperation.class);
        ((ClassPathXmlApplicationContext)(container)).close();
    }
}