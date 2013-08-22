package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

public abstract class GenericDAOImpl<PK extends Serializable, E extends Serializable> implements GenericDao<PK, E> {
	private EntityManager entityManager;

	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager entityManager) {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		this.entityManager = entityManager;
	}
	
	
	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public void save(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public E findByPk(PK id) {
		System.out.println(entityManager);
		return entityManager.find(entityClass, id);
	}

	@Override
	public List<E> find(Map<String, Object> parameters) {
		return null;
	}

	@Override
	public List<E> find(Object... parameters) {
		return null;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
