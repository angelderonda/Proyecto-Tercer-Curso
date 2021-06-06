package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;

@Stateless

public class AlumnoEJB implements GestionAlumno {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Override
	public void createAlumno(Alumno alumno) throws ObjetoYaExistenteException {

		Alumno aux = em.find(Alumno.class, alumno.getId());
		if (aux != null) {
			throw new ObjetoYaExistenteException("Este alumno ya existe");
		}
		em.persist(alumno);

	}

	@Override
	public Alumno readAlumno(Integer idAlumno) throws ObjetoNoExistenteException {
		Alumno aux = em.find(Alumno.class, idAlumno);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		return aux;

	}

	@Override
	public void updateAlumno(Alumno alumno) throws ObjetoNoExistenteException {
		Alumno aux = em.find(Alumno.class, alumno.getId());
		if (aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		em.merge(alumno);
	}

	@Override
	public void deleteAlumno(Integer idAlumno) throws ObjetoNoExistenteException {

		Alumno aux = em.find(Alumno.class, idAlumno);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		em.remove(aux);

	}

	@Override
	public List<Alumno> listarAlumnos(TipoFiltro filtro, float parametro) throws ProyectoException {
		List<Alumno> res = new ArrayList<Alumno>();
		TypedQuery<Alumno> query;
		switch (filtro) {
		case NUEVOS_O_VETERANOS:
			query = em.createNamedQuery("NUEVOS_O_VETERANOS", Alumno.class);
			res = query.setParameter("nuevoOveterano", (int) parametro).getResultList();
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

		case TITULACION:
			query = em.createNamedQuery("TITULACION", Alumno.class);
			res = query.setParameter("codigo", (int) parametro).getResultList();
			break;
		case ALUMNOS_POR_ASIGNAR:
			query = em.createNamedQuery("ALUMNOS_POR_ASIGNAR", Alumno.class);
			res = query.getResultList();
			break;

		default:// TODOS
			query = em.createNamedQuery("TODOS", Alumno.class);
			res = query.getResultList();
			break;
		}
		return res;
	}

	@Override
	public void rellenarEncuesta(Integer idAlumno, List<GruposAsignatura> lista)
			throws ObjetoNoExistenteException, ObjetoYaExistenteException {
		Alumno aux = em.find(Alumno.class, idAlumno);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}

		for (GruposAsignatura ga : lista) {
			GruposAsignatura auxga = em.find(GruposAsignatura.class,
					new GruposAsignaturaId(ga.getCursoAcademico(), ga.getGrupoGruposAsignatura().getId(),
							new AsignaturaId(ga.getAsignaturaGruposAsignatura().getReferencia(),
									ga.getAsignaturaGruposAsignatura().getTitulacionAsignatura().getCodigo())));

			if (auxga == null) {
				throw new ObjetoNoExistenteException("El grupo asignatura que buscas no existe");
			}
		}

		// Creamos la encuesta
		Encuesta encuesta = new Encuesta();
		encuesta.setGruposAsignaturaEncuesta(lista);
		encuesta.setFechaEnvio(new Date());
		// Obtenemos el expediente activo
		Expediente exp = aux.getExpedienteActivo();
		if (exp == null)
			throw new ObjetoNoExistenteException("El expediente no existe");
		encuesta.setExpedienteEncuesta(exp);
		em.persist(encuesta);

		for (GruposAsignatura ga : lista) {
			GruposAsignatura auxga = em.find(GruposAsignatura.class,
					new GruposAsignaturaId(ga.getCursoAcademico(), ga.getGrupoGruposAsignatura().getId(),
							new AsignaturaId(ga.getAsignaturaGruposAsignatura().getReferencia(),
									ga.getAsignaturaGruposAsignatura().getTitulacionAsignatura().getCodigo())));

			if (auxga == null) {
				throw new ObjetoNoExistenteException("El grupo asignatura que buscas no existe");
			}

			List<Encuesta> listaEncuesta = auxga.getEncuestaGruposAsignatura();
			if (listaEncuesta == null)
				listaEncuesta = new ArrayList<>();
			System.out.println(
					"GRUPOASIG" + auxga.getAsignaturaGruposAsignatura() + " " + auxga.getGrupoGruposAsignatura());
			System.out.println(listaEncuesta);
			listaEncuesta.add(encuesta);
			auxga.setEncuestaGruposAsignatura(listaEncuesta);
			em.merge(auxga);
		}

		/*
		 * // Obtenemos la lista de encuestas del expediente y añadimos la encuesta
		 * recien // creada List<Encuesta> listEncuesta = exp.getEncuestaExpediente();
		 * if (listEncuesta == null) new ArrayList<Encuesta>();
		 * listEncuesta.add(encuesta); exp.setEncuestaExpediente(listEncuesta); // Merge
		 * em.merge(aux); em.merge(exp); em.merge(encuesta);
		 */
	}

	/**
	 * Si es manual, secretaria manda directamente la lista de gruposAsignatura si
	 * no llamamos a algoritmo, aunque el comportamiento de algoritmo ahora mismo es
	 * no es el final debido a que nos tiene q ser explicado. En este metodo
	 * llamamos internamente a otro metodo de otro EJB porque queremos realizar la
	 * misma funcion. Ese metodo es gestionarCambioGrupo que dados un idAlumno y una
	 * lista de asignaturas, realiza un cambio de grupo para ese alumno si el tercer
	 * parametro está a true
	 * 
	 * @param idAlumno
	 * @param lista
	 * @param idEncuesta
	 * @param manualmente
	 * @throws ProyectoException
	 */
	@Override
	public void asignarGrupo(Integer idAlumno, List<GruposAsignatura> lista, EncuestaId idEncuesta, boolean manualmente)
			throws ObjetoNoExistenteException {
		// TODO Auto-generated method stub
		if (!manualmente) {
			List<GruposAsignatura> listaAlgoritmo = algoritmo(idAlumno, idEncuesta);
			asignaGrupo(idAlumno, listaAlgoritmo);
		} else
			asignaGrupo(idAlumno, lista);
	}

	/**
	 * Algoritmo para asignar grupo, ahora mismo a falta de ser explicado el
	 * algoritmo solamente le asignamos al alumno el grupo que ha elegido en su
	 * encuesta por lo que devolvemos de su encuesta simplemente la lista de
	 * gruposAsignatura
	 * 
	 * @param idAlumno
	 * @param idEncuesta
	 * @return
	 * @throws ObjetoNoExistenteException
	 */
	private List<GruposAsignatura> algoritmo(Integer idAlumno, EncuestaId idEncuesta)
			throws ObjetoNoExistenteException {
		Encuesta aux = em.find(Encuesta.class, idEncuesta);
		if (aux == null) {
			throw new ObjetoNoExistenteException("La encuesta que buscas no existe");
		}
		return aux.getGruposAsignaturaEncuesta();
	}

	private void asignaGrupo(Integer idAlumno, List<GruposAsignatura> lista) throws ObjetoNoExistenteException {
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
		if (alumno == null) {
			throw new ObjetoNoExistenteException("El alumno que buscas no existe");
		}
		Expediente expediente = alumno.getExpedienteActivo();
		if (expediente == null) {
			throw new ObjetoNoExistenteException("El expediente que buscas no existe");
		}
		Matricula matricula = expediente.getMatriculaActiva();
		if (matricula == null) {
			throw new ObjetoNoExistenteException("La matricula que buscas no existe");
		}
		List<AsignaturasMatricula> listAm = matricula.getAsignaturasMatriculaMatricula();
		for (AsignaturasMatricula am : listAm) {
			for (GruposAsignatura grupoAsignatura : lista) {
				if (am.getAsignaturaAsignaturasMatricula().equals(grupoAsignatura.getAsignaturaGruposAsignatura())) {
					System.out.println("A la asignatura " + am.getAsignaturaAsignaturasMatricula());
					am.setGrupoAsignaturasMatricula(grupoAsignatura.getGrupoGruposAsignatura());
					System.out.println("Le ponemos el grupo: " + am.getGrupoAsignaturasMatricula());
					em.merge(am);
				}
			}
		}
		// Merge
		em.merge(alumno);
		em.merge(expediente);
		em.merge(matricula);
	}

	public List<Alumno> getAlumnoSinGrupo() {
		List<Alumno> lista = new ArrayList<>();
		try {
			for (Alumno a : listarAlumnos(TipoFiltro.ALUMNOS_POR_ASIGNAR, 0f)) {
				Expediente e = a.getExpedienteActivo();
				if (e != null) {
					Matricula m = e.getMatriculaActiva();
					if (m != null) {
						int cont = 0;
						List<AsignaturasMatricula> listAm = m.getAsignaturasMatriculaMatricula();
						for (AsignaturasMatricula am : listAm) {
							if (am.getGrupoAsignaturasMatricula() == null)
								cont++;
						}
						if (cont > 0 && cont == listAm.size())
							lista.add(a);
					}
				}
			}
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
