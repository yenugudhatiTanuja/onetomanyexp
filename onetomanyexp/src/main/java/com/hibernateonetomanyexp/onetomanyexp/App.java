package com.hibernateonetomanyexp.onetomanyexp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory= new Configuration().configure().buildSessionFactory();
    	Session ses=factory.openSession();
    	Transaction tx=ses.beginTransaction();
    	Student sobj=new Student("tanuja","yenugudhati","tanuja@gmail.com","4534234567");
    	ses.save(sobj);
    	MarksDetails mobj1=new MarksDetails("English", "100", "90", "pass");
    	mobj1.setStudent(sobj);
    	ses.save(mobj1);
    	MarksDetails mobj2=new MarksDetails("Maths", "80", "90", "pass");
    	mobj1.setStudent(sobj);
    	ses.save(mobj2);
    	MarksDetails mobj3=new MarksDetails("Hindi", "80", "90", "pass");
    	mobj1.setStudent(sobj);
    	ses.save(mobj3);
    	System.out.println("Added");
    	tx.commit();
    	ses.close();
    	factory.close();
    	
    }
}
