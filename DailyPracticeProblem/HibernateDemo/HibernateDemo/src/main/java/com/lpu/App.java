package com.lpu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.entities.User;

public class App {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("/in/cg/config/hibernate.cfg.xml")  // if we didn't specify the path it will search hibernate.cfb in main/resources folder 
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {

            // CREATE
            tx = session.beginTransaction();

            User user = new User();
            user.setName("Madhav");
            user.setGender("Male");
            user.setCity("Hyderabad");
            user.setEmail("madhav@gmail.com");

            session.persist(user);

            tx.commit();
            System.out.println("Inserted ID: " + user.getId());


//            // READ BY ID
//            User fetchedUser = session.get(User.class, user.getId());
//            System.out.println("Fetched User: " + fetchedUser.getName());
//
//
//            // UPDATE
//            tx = session.beginTransaction();
//
//            fetchedUser.setCity("Bangalore");
//            session.merge(fetchedUser);
//
//            tx.commit();
//            System.out.println("User Updated");
//
//
//            // ======================
//            // READ ALL
//            // ======================
//            List<User> users = session
//                    .createQuery("from User", User.class)
//                    .list();
//
//            System.out.println("All Users:");
//            for (User u : users) {
//                System.out.println(
//                        u.getId() + " | " +
//                        u.getName() + " | " +
//                        u.getCity()
//                );
//            }
//
//
//            // ======================
//            // DELETE
//            // ======================
//            tx = session.beginTransaction();
//
//            session.remove(fetchedUser);
//
//            tx.commit();
//            System.out.println("User Deleted");


        } catch (Exception e) {
            if (tx != null) {
				tx.rollback();
			}
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

        System.out.println("CRUD Completed.");
    }
}
