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
            //create new user into database
            session.save(new User("amr", "amr@gmail.com"));
            //read a user from database
            User user = (User) session.get(User.class, 1);
            System.out.println(user);
            //update a user from db
            user.setEmeil("newEmail@gmail.com");
            //delete user from database
            User user1 = (User) session.get(User.class, 2);
            session.delete(user1);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
