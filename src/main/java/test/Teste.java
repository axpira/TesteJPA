package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contact;

import org.hsqldb.Server;

import dao.ContactDAO;
import dao.JpaUtil;

public class Teste {
	public static void main(String[] args) {
//		if (true) return;
		
		Server hsqlServer = null;
		try {
			hsqlServer = new Server();
//			hsqlServer.setLogWriter(new PrintWriter(System.out));
			hsqlServer.setLogWriter(null);
			hsqlServer.setSilent(true);

			hsqlServer.setDatabaseName(0, "xdb");
			hsqlServer.setDatabasePath(0, "file:testdb");

			hsqlServer.start();
			
			
			ContactDAO contactDao = new ContactDAO(JpaUtil.getEntityManager());
			Contact contact = contactDao.findByPk(2);
			System.out.println(contact.getName());
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesteHSQLDB");
			EntityManager em = emf.createEntityManager();

			
//			Contact contact = new Contact();
//			contact.setContactId(2);
//			contact.setName("Shirey");
//			em.getTransaction().begin();
//			em.persist(contact);
//			em.getTransaction().commit();
//			em.close();
			
			
			em = emf.createEntityManager();
			System.out.println("The customer names are:");
			final List<Contact> customers = em.createQuery("select c from Contact c").getResultList();
			for (Contact c : customers) {
				System.out.println(c.getContactId() + " : " + c.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (hsqlServer != null) {
				hsqlServer.shutdown();
			}

		}
	}
}
