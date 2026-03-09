package com.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session =
                HibernateUtil.getFactory().openSession();

        Transaction tx = session.beginTransaction();

        Student s1 = new Student();
        s1.setName("Akhilesh");

        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Hibernate");

        Set<Course> courseSet = new HashSet<>();
        courseSet.add(c1);
        courseSet.add(c2);

        s1.setCourses(courseSet);

        session.save(c1);
        session.save(c2);
        session.save(s1);

        tx.commit();
        session.close();

        System.out.println("Data Inserted Successfully");
    }
}