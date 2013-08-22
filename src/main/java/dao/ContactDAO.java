package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Contact;

public class ContactDAO extends GenericDAOImpl<Integer, Contact>{

	public ContactDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	
}
