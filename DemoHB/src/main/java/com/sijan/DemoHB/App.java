package com.sijan.DemoHB;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
//    	Name na = new Name();
//    	na.setFname("Bom");
//    	na.setLname("Sherchan");
//    	na.setMname("Kaji");
//    	
//        Demo1 demo = new Demo1();
//        demo.setId(1);
//        demo.setAname(na);
//        demo.setAddress("dhangadi");
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);;
    	laptop.setLname("Samsung");
    	
    	Student stud = new Student();
    	stud.setName("Sijan");
    	stud.setRollno(39);
    	stud.setMarks(100);
    	stud.getLaptop().add(laptop);
    	
    	laptop.getStudent().add(stud);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        //con.configure("hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf= con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
    
        session.save(laptop);
        session.save(stud);
        tx.commit();
        session.close();
    }
}
