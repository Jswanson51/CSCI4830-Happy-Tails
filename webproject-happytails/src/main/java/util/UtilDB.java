/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.Pet;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Pet> listPets() {
      List<Pet> resultList = new ArrayList<Pet>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> pets = session.createQuery("FROM Pet").list();
         for (Iterator<?> iterator = pets.iterator(); iterator.hasNext();) {
            Pet pet = (Pet) iterator.next();
            resultList.add(pet);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   //Generates a list of all pets from the database
   public static List<Pet> listPets(String keyword) {
      List<Pet> resultList = new ArrayList<Pet>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
       
         List<?> pets = session.createQuery("FROM Pet").list();
         for (Iterator<?> iterator = pets.iterator(); iterator.hasNext();) {
            Pet pet = (Pet) iterator.next();
            if (pet.getName().startsWith(keyword)) {
                resultList.add(pet);
             }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   //Creates a pet object
   public static void createPets(String name, String age, String species, String breed, String temperament, String weight) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Pet(name, age, species, breed, temperament, weight));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static boolean deletePet(int petId) {
	    Session session = getSessionFactory().openSession();
	    Transaction tx = null;

	    try {
	        tx = session.beginTransaction();
	        Object object = session.get(Pet.class, petId);
	           
	           if (object != null && object instanceof Pet) {
	        	   Pet row = (Pet) object;
	               session.delete(row);
	               tx.commit();
	               return true;
	           }
	           
	           return false;

	    } catch (HibernateException e) {
	        if (tx != null)
	            tx.rollback();
	        e.printStackTrace();
	        return false;
	    } finally {
	        session.close();
	    }
	}
   
}

