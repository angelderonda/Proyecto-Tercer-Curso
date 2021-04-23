package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;

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
	public void gestionarCambioGrupo(Integer idAlumno, List<GruposAsignatura> lista, boolean cambioAceptado) throws ObjetoNoExistenteException {
		Alumno alumno = em.find(Alumno.class, idAlumno);
		for (GruposAsignatura ga : lista) {
			GruposAsignatura auxga = em.find(GruposAsignatura.class,
					new GruposAsignaturaId(ga.getCursoAcademico(), ga.getGrupoGruposAsignatura().getId(),
							new AsignaturaId(ga.getAsignaturaGruposAsignatura().getReferencia(),
									ga.getAsignaturaGruposAsignatura().getTitulacionAsignatura().getCodigo())));
			if (auxga == null) {
				throw new ObjetoNoExistenteException("El grupo asignatura no existe: " + auxga);
			}
		}
		if(alumno == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		Expediente expediente = alumno.getExpedienteActivo();
		if(expediente == null) {
			throw new ObjetoNoExistenteException("El expediente que buscas no existe");
		}
		List<Expediente> listaExpedienteAlumno = alumno.getExpedienteAlumno();
		listaExpedienteAlumno.remove(expediente);
		Matricula matricula = expediente.getMatriculaActiva();
		if(matricula == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}
		List<Matricula> listaMatriculasExpediente = expediente.getMatriculaExpediente();
		listaMatriculasExpediente.remove(matricula);
		if(cambioAceptado) { //Cambiamos al alumno de grupo
			//tenemos la lista de asignaturas y grupo al que vamos a cambiar al alumno
			List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();
			for(GruposAsignatura grupoAsignatura : lista) {
			//accedemos a su expediente, su matricula, y en su matricula cambiamos la lista de asignaturasMatricula
			//Por las que creamos usando las que aparecen en el param lista. Ahi modificamos su matricula su expediente y el alumno y listo
				AsignaturasMatricula asignaturaMatricula = new AsignaturasMatricula();
				asignaturaMatricula.setAsignaturaAsignaturasMatricula(grupoAsignatura.getAsignaturaGruposAsignatura());
				asignaturaMatricula.setMatriculaAsignaturasMatricula(matricula);
				asignaturaMatricula.setGrupoAsignaturasMatricula(grupoAsignatura.getGrupoGruposAsignatura());
				listaAsignaturasMatricula.add(asignaturaMatricula);
			}
		matricula.setAsignaturasMatriculaMatricula(listaAsignaturasMatricula);
		listaMatriculasExpediente.add(matricula);
		//listaMatriculasExpediente.add
		expediente.setMatriculaExpediente(listaMatriculasExpediente);
		listaExpedienteAlumno.add(expediente);
		alumno.setExpedienteAlumno(listaExpedienteAlumno);
		//Merge
		em.merge(alumno);
		em.merge(expediente);
		em.merge(matricula);
		}
	}

//	@Override
//	public void incluirAlumno(Alumno alumno, Grupo grupo) throws ProyectoException {
//		// TODO Auto-generated method stub
//		
//	}
}
