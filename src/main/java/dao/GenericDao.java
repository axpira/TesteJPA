package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<PK extends Serializable, E extends Serializable>{
	
	public void save(E entity);
	public void remove(E entity);
	public E findByPk(PK id);
	
	public List<E> find(Map<String, Object> parameters);
	public List<E> find(Object... parameters);
}
