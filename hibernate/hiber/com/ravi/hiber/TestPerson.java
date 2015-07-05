package com.ravi.hiber;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestPerson {
	
	public static void main(String[] args) {
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// See more at: http://www.javabeat.net/session-factory-hibernate-4/#sthash.VA5sVGqv.dpuf
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
 
        session.beginTransaction();
 
        createPerson(session);
 
        queryPerson(session);
 
    }
 
    private static void queryPerson(Session session) {
        Query query = session.createQuery("from HiberPrac");                 
        List <HiberPrac>list = query.list();
        java.util.Iterator<HiberPrac> iter = list.iterator();
        while (iter.hasNext()) {
 
        	HiberPrac person = iter.next();
            System.out.println("Person: \"" + person.getName() +"\", " + person.getSurname() +"\", " +person.getAddress());
 
        }
 
        session.getTransaction().commit();
 
    }
 
    public static void createPerson(Session session) {
    	HiberPrac person = new HiberPrac();
 
        person.setName("Barak");
        person.setSurname("Obhama");       
        person.setAddress("White House");       
 
        session.save(person);
    }

}
