package HBCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
 

public class App {
	public static void main( String[] args ){
		Student s = null;
		// Load Hibernate configuration and map the Student class
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        // Build the ServiceRegistry using the loaded configuration
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        // Create the SessionFactory, which is a heavyweight object used to create Sessions
        SessionFactory sf = con.buildSessionFactory();
        // Open the first session
	     Session session1 = sf.openSession();
	     
	    // Create a query to fetch the Student object with sid = 101
	    // The query is marked as cacheable for Second Level Cache usage
	     session1.beginTransaction();
	     Query q1= session1.createQuery("from Student where sid = 101");
	     q1.setCacheable(true); // Enables Second Level Cache for this query
	     
	  // Execute the query and fetch the result
	     s = (Student)q1.uniqueResult();
	     System.out.println(s);
	     
	     //normal way to fetch an object using its primary key, 
	     //leveraging Hibernate's First Level Cache
//	     s = (Student) session1.get(Student.class, 101);
//	     System.out.println(s);

	     session1.getTransaction().commit(); 
	     session1.close();// First Level Cache (session1) is now destroyed
	   
	     Session session2 = sf.openSession();
	     session2.beginTransaction();
	     
	     // Create the same query in the second session
	     // Second Level Cache will be checked here
	     Query q2= session2.createQuery("from Student where sid = 101");
	     q2.setCacheable(true);
	    
	     s = (Student)q2.uniqueResult();
	     System.out.println(s);
	     
//	     s = (Student) session2.get(Student.class, 102);
//	     System.out.println(s);

	     session2.getTransaction().commit();
	     session2.close();// First Level Cache (session2) is now destroyed

	     sf.close();
	}
}
