package main.com.myApp;

import main.com.myApp.model.Product;
import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        try{
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            // Task 1 storing date and time in database
            session.persist(new User("amr", "amr@gmail.com"));
            // Task 2
            Query query = session.createQuery("from Product ");
            List<Product> productList = query.getResultList();
            for(Product product : productList){
                System.out.println(product);
            }
            System.out.println("=====================update query=====================");
            query = session.createQuery("update Product set name=:name where id=:id");
            query.setParameter("name", "ProductX");
            query.setParameter("id", 1);
            int result = query.executeUpdate();
            System.out.printf("the result for update is: %d\n", result);
            System.out.println("=====================delete query=====================");
            query = session.createQuery("delete from Product where id=:id");
            query.setParameter("id", 5);
             result = query.executeUpdate();
            System.out.printf("the result for delete is: %d\n", result);
            System.out.println("=====================aggregation functions=====================");
            query = session.createQuery("select sum(price) from Product ");
            double sum = (double) query.getResultList().get(0);
            System.out.printf("the result for aggregation is: %f\n", sum);
            session.getTransaction().commit();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
