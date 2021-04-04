package proyecto.jpa;


import javax.persistence.*;

public class Main {

	public static void main(String[] args) {
		invocaEM();
	}
	
	public static void invocaEM() {
		EntityManager EM = JPAUtil.getEntityManager();
		System.out.println("Creación de tablas realizada correctamente");
	}

}
