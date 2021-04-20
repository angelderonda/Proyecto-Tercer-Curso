package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;

@Stateless
public class AsignaturaEJB implements GestionAsignatura {
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public void createAsignatura(Asignatura asignatura) throws ObjetoYaExistenteException {
				
		Asignatura aux = em.find(Asignatura.class, 
				new AsignaturaId(asignatura.getReferencia(),asignatura.getTitulacionAsignatura().getCodigo()));
		if(aux != null) {
			throw new ObjetoYaExistenteException("Esta asignatura ya ha sido creada");
		}
		em.persist(asignatura);

	}

	@Override
	public Asignatura readAsignatura(AsignaturaId idAsignatura) throws ObjetoNoExistenteException {
		
		Asignatura aux = em.find(Asignatura.class, idAsignatura);
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		
		return aux;

	}

	@Override
	public void updateAsignatura(Asignatura asignatura) throws ObjetoNoExistenteException {
		
		Asignatura aux = em.find(Asignatura.class, 
				new AsignaturaId(asignatura.getReferencia(),asignatura.getTitulacionAsignatura().getCodigo()));
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		//aux = asignatura;
		em.merge(aux);
		

	}

	@Override
	public void deleteAsignatura(AsignaturaId idAsignatura) throws ObjetoNoExistenteException {
		
		Asignatura aux = em.find(Asignatura.class,idAsignatura);
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		em.remove(aux);

	}

}
