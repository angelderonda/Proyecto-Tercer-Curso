package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public void createMatricula(Matricula matricula) throws ObjetoYaExistenteException {

		Matricula aux = em.find(Matricula.class, new MatriculaId (matricula.getCursoAcademico(),
				matricula.getExpedienteMatricula().getNumeroExpediente()));
		
		if(aux != null) {
			throw new ObjetoYaExistenteException("Esta asignatura ya ha sido creada");
		}
		em.persist(matricula);
	}

	@Override
	public Matricula readMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException {
		
		Matricula aux = em.find(Matricula.class, idMatricula);
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		
		return aux;
	}

	@Override
	public void updateMatricula(Matricula matricula) throws ObjetoNoExistenteException {
		Matricula aux = em.find(Matricula.class, 
				new MatriculaId(matricula.getCursoAcademico(),matricula.getExpedienteMatricula().getNumeroExpediente()));
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		//aux = asignatura;
		em.merge(aux);
		
	}

	@Override
	public void deleteMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException {

		Matricula aux = em.find(Matricula.class,idMatricula);
		if(aux == null) {
			throw new ObjetoNoExistenteException("La asignatura que buscas no existe");
		}
		em.remove(aux);
		
	}


}
