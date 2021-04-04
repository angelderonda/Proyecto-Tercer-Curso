package proyecto.jpa;


import javax.persistence.*;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyecto.jpa");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
				
	}	

}
