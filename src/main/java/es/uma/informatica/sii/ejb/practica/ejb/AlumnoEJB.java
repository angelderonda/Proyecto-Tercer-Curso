package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.NamedQueries;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Stateless

public class AlumnoEJB implements GestionAlumno {

	
	@PersistenceContext(name="Secretaria")
	private EntityManager em;
	
	@Override
	public void createAlumno(Alumno alumno) throws  ObjetoYaExistenteException{
	
		Alumno aux = em.find(Alumno.class, alumno.getId());
		if(aux != null) {
			throw new ObjetoYaExistenteException("Este alumno ya existe");
		}
		em.persist(alumno);

	}

	@Override
	public Alumno readAlumno(Integer  idAlumno) throws ObjetoNoExistenteException {
		Alumno aux = em.find(Alumno.class, idAlumno);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}		
		return aux;

	}

	@Override
	public void updateAlumno(Alumno alumno) throws ObjetoNoExistenteException {
		Alumno aux = em.find(Alumno.class, alumno.getId());
		if(aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		em.merge(alumno);
	}

	@Override
	public void deleteAlumno(Integer  idAlumno) throws ObjetoNoExistenteException {
		
		Alumno aux = em.find(Alumno.class, idAlumno);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}			
		em.remove(aux);

	}

	@Override
	public void asignarGrupo(Alumno alumno, Grupo grupo) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alumno> listarAlumnos(TipoFiltro filtro, int parametro) throws ProyectoException {
		List<Alumno> res = new ArrayList<Alumno>();
		TypedQuery<Alumno> query;
		switch (filtro) {
		case NUEVOS_O_VETERANOS:
			query = em.createNamedQuery("NUEVOS_O_VETERANOS", Alumno.class);
			res = query.getResultList();
			break;
		case FECHA_DE_MATRICULACIÓN:
			query = em.createNamedQuery("FECHA_DE_MATRICULACIÓN", Alumno.class);
			res = query.getResultList();
			break;
		case NOTA_MEDIA:
			query = em.createNamedQuery("NOTA_MEDIA", Alumno.class);
			res = query.setParameter("nota", parametro).getResultList();
			break;
		case CREDITOS_SUPERADOS:
			query = em.createNamedQuery("CREDITOS_SUPERADOS", Alumno.class);
			res = query.getResultList();
			break;
		case TITULACION:
			query = em.createNamedQuery("TITULACION", Alumno.class);
			res = query.setParameter("codigo", parametro).getResultList();
			break;
		/*case GRUPO:
			query = em.createNamedQuery("TITULACION", Alumno.class);
			res = query.setParameter("codigo", parametro).getResultList();
			break;*/
		default://TODOS
			query = em.createNamedQuery("TODOS", Alumno.class);
			res = query.getResultList();
			break;
		}
		return res;
	}
	

	@Override
	public void solicitarCambioDeGrupo(Integer idAlumno, Integer idGrupo) throws ProyectoException {
		//POSIBLE INNECESARIO ESTUDIAR
	}

	@Override
	public void rellenarEncuesta(Integer idAlumno, List<GruposAsignatura> lista) throws ProyectoException {
		// TODO Auto-generated method stub
		Alumno aux = em.find(Alumno.class, idAlumno);
		if(aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		//Creamos la encuesta
		Encuesta encuesta = new Encuesta();
		encuesta.setGruposAsignaturaEncuesta(lista);
		encuesta.setFechaEnvio(new Date());
		//Obtenemos el expediente activo
		Expediente exp = aux.getExpedienteActivo();
		if(exp == null) throw new ProyectoException();
		encuesta.setExpedienteEncuesta(exp);
		//Obtenemos la lista de encuestas del expediente y añadimos la encuesta recien creada
		List<Encuesta> listEncuesta = exp.getEncuestaExpediente();
		if(listEncuesta == null) new ArrayList<Encuesta>();
		listEncuesta.add(encuesta);
		exp.setEncuestaExpediente(listEncuesta);
		//Merge
		em.merge(aux);
		em.merge(exp);
		em.merge(encuesta);
	}
	
}


















