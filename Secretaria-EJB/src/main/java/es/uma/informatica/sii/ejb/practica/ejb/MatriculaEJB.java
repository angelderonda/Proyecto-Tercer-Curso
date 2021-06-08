package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;

@Stateless
public class MatriculaEJB implements GestionMatricula {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Override
	public Matricula readMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException {

		Matricula aux = em.find(Matricula.class, idMatricula);
		if (aux == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}

		return aux;
	}

	@Override
	public void updateMatricula(Matricula matricula) throws ObjetoNoExistenteException {
		Matricula aux = em.find(Matricula.class, new MatriculaId(matricula.getCursoAcademico(),
				matricula.getExpedienteMatricula().getNumeroExpediente()));
		if (aux == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}	
		em.merge(matricula);

	}

	@Override
	public void deleteMatricula(MatriculaId idMatricula) throws ObjetoNoExistenteException {

		Matricula aux = em.find(Matricula.class, idMatricula);
		if (aux == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}
		em.remove(aux);
	}
	
	@Override
	public List<AsignaturasMatricula> getAsignaturas(Matricula matricula) throws ObjetoNoExistenteException{
		Matricula aux = em.find(Matricula.class, new MatriculaId(matricula.getCursoAcademico(),
				matricula.getExpedienteMatricula().getNumeroExpediente()));
		if (aux == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}	
		List<AsignaturasMatricula> list = aux.getAsignaturasMatriculaMatricula();
		list.size();
		return list;
	}

	@Override
	public void createMatricula(Matricula matricula, Integer expedienteID)
			throws ObjetoYaExistenteException, ObjetoNoExistenteException {
		Expediente expediente = em.find(Expediente.class, expedienteID);
		if (expediente == null) {
			throw new ObjetoNoExistenteException("Esta matricula ya ha sido creada");
		}
		matricula.setExpedienteMatricula(expediente);
		Matricula aux = em.find(Matricula.class, new MatriculaId(matricula.getCursoAcademico(),
				matricula.getExpedienteMatricula().getNumeroExpediente()));

		if (aux != null) {
			throw new ObjetoYaExistenteException("Esta matricula ya ha sido creada");
		}
		em.persist(matricula);	
	}

	@Override
	public boolean conGrupos(Matricula matricula) throws ObjetoNoExistenteException {
		Matricula aux = em.find(Matricula.class, new MatriculaId(matricula.getCursoAcademico(),
				matricula.getExpedienteMatricula().getNumeroExpediente()));
		if (aux == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}	
		List<AsignaturasMatricula> list = aux.getAsignaturasMatriculaMatricula();
		
		for(AsignaturasMatricula am : list) {
			if(am.getGrupoAsignaturasMatricula() != null) {
				return true;
			}
		}
		return false;
	}
	
	

}
