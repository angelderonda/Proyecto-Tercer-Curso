package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;

@Stateless
public class ExpedienteEJB implements GestionExpediente{
	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public void createExpediente(Expediente expediente) throws ObjetoYaExistenteException {
		Expediente aux = em.find(Expediente.class, expediente.getNumeroExpediente());
		if(aux != null) {
			throw new ObjetoYaExistenteException("Este expediente ya existe");
		}
		em.persist(expediente);
	}

	@Override
	public Expediente readExpediente(Integer idExpediente) throws ObjetoNoExistenteException {
		Expediente aux = em.find(Expediente.class, idExpediente);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El expediente que buscas no existe");
		}
		return aux;
	}

	@Override
	public void updateExpediente(Expediente expediente) throws ObjetoNoExistenteException {
		Expediente aux = em.find(Expediente.class, expediente.getNumeroExpediente());
		if(aux == null) {
			throw new ObjetoNoExistenteException("El expediente que buscas no existe");
		}
		aux = expediente;
		em.merge(aux);
	}

	@Override
	public void deleteExpediente(Integer idExpediente) throws ObjetoNoExistenteException {
		Expediente aux = em.find(Expediente.class, idExpediente);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El expediente que buscas no existe");
		}
		em.remove(aux);
	}
}
