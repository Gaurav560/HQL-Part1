package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) {

        // creating session object

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();


        //for persisting 50 student records in db
//        Random r=new Random();
//        for (int i = 0; i < 50; i++) {
//            Student s=new Student();
//            s.setRollNo(i);
//            s.setMarks(r.nextInt(100));
//            s.setSname("Name "+ i);
//            session.persist(s);
//        }


//to get all the students
//        Query<Student> q = session.createQuery("from Student", Student.class);
//        List<Student> students = q.getResultList();
//            for (Student s:students){
//                System.out.println(s);
//            }


//to get marks >50
//          Query<Student> query=session.createQuery("from Student where marks>50",Student.class);
//          List<Student> students=query.list();
//          for(Student s:students) { System.out.println(s); }


//to get a unique result
        Query<Student> query = session.createQuery("from Student where rollNo=7", Student.class);
        Student student = query.uniqueResult();
        System.out.println(student);


        tx.commit();

        session.close();
    }
}
