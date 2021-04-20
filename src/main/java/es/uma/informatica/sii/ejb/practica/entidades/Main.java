package es.uma.informatica.sii.ejb.practica.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Secretaria");
		EntityManager em = emf.createEntityManager();
		
		/*for (int i = 0; i < 100; i++) {
			List<Expediente> exp = new ArrayList<Expediente>();
			Expediente expediente = new Expediente();
			expediente.setNotaMediaProvisional(i+2);
			Alumno alumno = new Alumno();
			expediente.setAlumnoExpediente(alumno);
			alumno.setId(i);
			exp.add(expediente);
			alumno.setExpedienteAlumno(exp);
			em.persist(alumno);
			em.persist(expediente);
		}*/
		
		em.close();
		emf.close();
				
	}	

}
