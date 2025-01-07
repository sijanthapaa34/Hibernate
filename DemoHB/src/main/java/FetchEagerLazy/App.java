package FetchEagerLazy;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
public static void main( String[] args ){
	 
	 Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
     //con.configure("hibernate.cfg.xml");
     ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
     SessionFactory sf= con.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction tx = session.beginTransaction();
     
     Student s1 = session.get(Student.class, 2);
     System.out.println(s1.getSname());
//     Collection<Laptop> laps = s1.getLaps();
//     for (Laptop lap : laps) {
//    	 System.out.println(lap);
//     }
    
     tx.commit();
     session.close();
}
}
  