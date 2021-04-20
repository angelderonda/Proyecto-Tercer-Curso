package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;

@Stateless
public class GrupoEJB implements GestionGrupo{

	@PersistenceContext(name="Secretaria")
	private EntityManager em;

	@Override
	public void createGrupo(Grupo grupo) throws ObjetoYaExistenteException {
		Grupo aux = em.find(Grupo.class, grupo.getId());
		if(aux != null) {
			throw new ObjetoYaExistenteException("Este grupo ya existe");
		}
		em.persist(grupo);
	}

	@Override
	public Grupo readGrupo(Integer idGrupo) throws ObjetoNoExistenteException {
		Grupo aux = em.find(Grupo.class, idGrupo);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El grupo que buscas no existe");
		}		
		return aux;
	}

	@Override
	public void updateGrupo(Grupo grupo) throws ObjetoNoExistenteException {
		Grupo aux = em.find(Grupo.class, grupo.getId());
		if(aux == null) {
			throw new ObjetoNoExistenteException("El grupo que buscas no existe");
		}
		aux = grupo;
		em.merge(aux);
	}

	@Override
	public void deleteGrupo(Integer idGrupo) throws ObjetoNoExistenteException {
		Grupo aux = em.find(Grupo.class, idGrupo);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El grupo que buscas no existe");
		}
		em.remove(aux);
	}

	@Override
	public void gestionarCambioGrupo(Integer idAlumno, Integer idGrupo) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incluirAlumno(Alumno alumno, Grupo grupo) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}
}
