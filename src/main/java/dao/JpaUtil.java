package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaUtil {
	public static String PROPERTIES_FILE_NAME = "jpautil.properties";
	public static final String PERSISTENCE_UNIT_NAME_DEFAULT_KEY = "persistence-unit-name-default";
	public static final String PERSISTENCE_UNIT_NAME_DEFAULT_VALUE = "test";
	
	private JpaUtil() {}

	private static EntityManagerFactory emf = null;
	
	static {
		String persistenceUnitName = PERSISTENCE_UNIT_NAME_DEFAULT_VALUE;
		try {
			persistenceUnitName = getPropertiesFromClasspath(PROPERTIES_FILE_NAME).getProperty(PERSISTENCE_UNIT_NAME_DEFAULT_KEY, PERSISTENCE_UNIT_NAME_DEFAULT_VALUE);
		} catch (IOException e) {}

		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	private static Properties getPropertiesFromClasspath(String propFileName) throws IOException {
		Properties props = new Properties();
		InputStream inputStream = JpaUtil.class.getClassLoader().getResourceAsStream(propFileName);
		props.load(inputStream);
		return props;
	}
	
	public static void fillNamedParameters(Query q, Map<String, Object> parameters) {
		// e.getPersistenceUnitUtil().
		if (parameters != null && !parameters.isEmpty()) {
			for (Map.Entry<String, Object> entry : parameters.entrySet()) {
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}

	public static void fillIndexedParameters(Query q, Object... parameters) {
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				q.setParameter(i + 1, parameters[i]);
			}
		}
	}


}
