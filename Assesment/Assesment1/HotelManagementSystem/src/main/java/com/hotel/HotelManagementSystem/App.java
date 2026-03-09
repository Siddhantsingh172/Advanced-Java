package com.hotel.HotelManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hotel.entities.Booking;
import java.util.List;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("com/hotel/config/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {


        	// 1️.ADD BOOKING


            tx = session.beginTransaction();

            Booking booking = new Booking(
                    "Rahul",
                    "Deluxe",
                    "2026-02-12",
                    "2026-02-16");

            session.persist(booking);

            tx.commit();
            System.out.println("Booking Inserted Successfully");


            
            // 2.VIEW ALL BOOKINGS

            List<Booking> list =
                    session.createQuery("from Booking", Booking.class).list();

            System.out.println("----- All Bookings -----");
            for(Booking b : list) {
                System.out.println(b);
            }

          
            
            // 3️.UPDATE BOOKING

            tx = session.beginTransaction();

            Booking updateBooking =
                    session.get(Booking.class, 1);

            if(updateBooking != null) {
                updateBooking.setRoomType("Suite");
                updateBooking.calculateTotalAmount();
                session.merge(updateBooking);
                System.out.println("Updated Successfully");
            }

            tx.commit();


            // 4️.DELETE BOOKING

            tx = session.beginTransaction();

            Booking deleteBooking =
                    session.get(Booking.class, 1);

            if(deleteBooking != null) {
                session.remove(deleteBooking);
                System.out.println("Deleted Successfully");
            }

            tx.commit();

        } catch (Exception e) {

            if(tx != null)
                tx.rollback();

            e.printStackTrace();
        }

        session.close();
        factory.close();
    }
}
