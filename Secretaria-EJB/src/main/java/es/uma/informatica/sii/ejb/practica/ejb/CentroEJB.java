package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;

@Stateless
public class CentroEJB implements GestionCentro {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Override
	public void createCentro(Centro centro) throws ObjetoYaExistenteException {
		// TODO Auto-generated method stub
		Centro aux = em.find(Centro.class, centro.getId());
		if (aux != null) {
			throw new ObjetoYaExistenteException("Este centro ya existe");
		}
		em.persist(centro);

	}

	@Override
	public Centro readCentro(Integer idCentro) throws ObjetoNoExistenteException {
		// TODO Auto-generated method stub
		Centro aux = em.find(Centro.class, idCentro);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El centro que buscas no existe");
		}
		return aux;

	}

	@Override
	public void updateCentro(Centro centro) throws ObjetoNoExistenteException {
		// TODO Auto-generated method stub
		Centro aux = em.find(Centro.class, centro.getId());
		if (aux == null) {
			throw new ObjetoNoExistenteException("El centro que buscas no existe");
		}
		// aux = centro;
		em.merge(centro);
	}

	@Override
	public void deleteCentro(Integer idCentro) throws ObjetoNoExistenteException {
		// TODO Auto-generated method stub
		Centro aux = em.find(Centro.class, idCentro);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El centro que buscas no existe");
		}
		em.remove(aux);

	}

}
