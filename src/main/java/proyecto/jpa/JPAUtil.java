package proyecto.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("proyecto.jpa");
	
	//Para obtener la conexión con nuestra BD
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
