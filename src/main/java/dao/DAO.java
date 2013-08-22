package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import model.PersistentEntity;


public interface DAO<PK extends Serializable, E extends Serializable>  {
	
	public static final int MAX_RESULT = Integer.MAX_VALUE;
	public static final int FIRST_RESULT = 0;
	
	public E findByPk(PK id);

//	public Collection<E> findByQuery(String query, int page, int maxResults, Map<String, Object> parameters) throws DAOException;
//	public Collection<E> findByQuery(String query, int page, int maxResults, Object... parameters) throws DAOException;
//
//	public Collection<E> findAll(int page, int maxResult, Map<String, Object> parameters) throws DAOException;
//	public Collection<E> findAll(int page, int maxResult, Object... parameters) throws DAOException;
//
//	public Collection<E> findSingleByQuery(String query, Map<String, Object> parameters) throws DAOException;
//	public Collection<E> findSingleByQuery(String query, Object... parameters) throws DAOException;
//
//	public int getTotalItens() throws DAOException;
//	
//	public E findByPk(Object pk) throws DAOException;

}
