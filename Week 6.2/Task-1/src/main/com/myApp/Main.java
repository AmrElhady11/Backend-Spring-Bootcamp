package main.com.myApp;

import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try{
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            // Task 1 storing date and time in database
            session.persist(new User("amr", "amr@gmail.com"));

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
