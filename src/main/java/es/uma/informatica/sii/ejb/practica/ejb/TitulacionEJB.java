package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Stateless
public class TitulacionEJB implements GestionTitulacion {

	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public void createTitulacion(Titulacion titulacion) throws ObjetoYaExistenteException {
		
		Titulacion aux = em.find(Titulacion.class,titulacion.getCodigo());
		if(aux != null) {
			throw new ObjetoYaExistenteException("Esta titulación ya existe");
		}
		em.persist(titulacion);

	}

	@Override
	public Titulacion readTitulacion(Integer codigo) throws ObjetoNoExistenteException {
		
		Titulacion aux = em.find(Titulacion.class,codigo);
		if(aux != null) {
			throw new ObjetoNoExistenteException("Titulación no encontrada");
		}		
		return aux;
		
	}

	@Override
	public void updateTitulacion(Titulacion titulacion) throws ObjetoNoExistenteException {
		
		Titulacion aux = em.find(Titulacion.class,titulacion.getCodigo());
		if(aux != null) {
			throw new ObjetoNoExistenteException("Titulación no encontrada");
		}		
		//aux = codigo;
		em.merge(titulacion);

	}

	@Override
	public void deleteTitulacion(Integer codigo) throws ObjetoNoExistenteException {
		
		Titulacion aux = em.find(Titulacion.class,codigo);
		if(aux != null) {
			throw new ObjetoNoExistenteException("Titulación no encontrada");
		}		
		em.remove(aux);		

	}

}
