package es.uma.informatica.sii.ejb.practica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.sii.ejb.practica.entidades.*;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// Alumno
		Alumno alumno = new Alumno();
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		listaAlumno.add(alumno);

		alumno.setId(1);
		alumno.setDni("254789E");
		alumno.setNombreCompleto("Pepito");
		alumno.setApellido1("Palotes");
		alumno.setApellido2("Perez");
		alumno.setEmailInstitucional("pepe@uma.es");
		alumno.setEmailPersonal("pepito12@gmail.com");
		alumno.setNumeroArchivo("1245785");
		alumno.setNumeroMovil("66548447");
		alumno.setNumeroTelefono("957412784");
		alumno.setDireccion("Calle Margarita");
		alumno.setLocalidad("Benaoján");
		alumno.setProvincia("Málaga");
		alumno.setCp(29514);
		em.persist(alumno);
		// alumno.setExpedienteAlumno(listaExpediente);

		// Centro
		Centro centro = new Centro();
		List<Centro> listaCentro = new ArrayList<Centro>();
		listaCentro.add(centro);

		centro.setId(1041);
		centro.setDireccion("Calle Malaga");
		centro.setNombre("Centro Informatica");
		centro.setTelefono_conserjeria("690329116");
		em.persist(centro);

		// Titulacion
		Titulacion titulacion = new Titulacion();
		List<Titulacion> listaTitulacion = new ArrayList<Titulacion>();
		listaTitulacion.add(titulacion);

		titulacion.setCodigo(1041);
		titulacion.setCreditos(240);
		titulacion.setNombre("Informatica");
		titulacion.setCentroTitulacion(listaCentro);
		em.persist(titulacion);

		// Expediente
		Expediente expediente = new Expediente();
		List<Expediente> listaExpediente = new ArrayList<Expediente>();
		listaExpediente.add(expediente);

		expediente.setActivo('1');
		expediente.setCreditosCF(5);
		expediente.setCreditosFB(5);
		expediente.setCreditosMO(5);
		expediente.setCreditosOP(5);
		expediente.setCreditosPE(5);
		expediente.setCreditosTF(5);
		expediente.setNotaMediaProvisional((float) 9.45);
		expediente.setNumeroExpediente(102474112);
		expediente.setAlumnoExpediente(alumno);
		expediente.setTitulacionExpediente(titulacion);
		em.persist(expediente);

		// Matricula
		Matricula matricula = new Matricula();
		List<Matricula> listaMatricula = new ArrayList<Matricula>();
		listaMatricula.add(matricula);

		matricula.setCursoAcademico("2020/2021");
		matricula.setEstado("Activo");
		matricula.setExpedienteMatricula(expediente);
		matricula.setFechaMatricula(new Date(14 / 11 / 2021));
		matricula.setNuevoIngreso(1);
		matricula.setNumeroArchivo(123344556);
		matricula.setTurnoPreferente("Mañana");
		em.persist(matricula);

		// Encuesta
		Encuesta encuesta = new Encuesta();
		List<Encuesta> listaEncuesta = new ArrayList<Encuesta>();
		listaEncuesta.add(encuesta);

		encuesta.setFechaEnvio(new Date(18 / 05 / 2021));
		encuesta.setExpedienteEncuesta(expediente);
		em.persist(encuesta);

		// Asignatura
		Asignatura asignatura = new Asignatura();
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		listaAsignatura.add(asignatura);

		asignatura.setCodigo(1456156);
		asignatura.setCreditosPracticas(6);
		asignatura.setCreditosTeoria(6);
		asignatura.setCurso(2021);
		asignatura.setDuracion("1º cuatrimestre");
		asignatura.setNombre("Cálculo");
		asignatura.setOfertada("Si");
		asignatura.setOtro_idioma("Inglés");
		asignatura.setPlazas("25");
		asignatura.setReferencia(564846687);
		asignatura.setTipo("Obligatoria");
		asignatura.setTitulacionAsignatura(titulacion);
		em.persist(asignatura);

		// Grupo
		Grupo grupo = new Grupo();
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		listaGrupo.add(grupo);

		grupo.setAsignar("Si");

		grupo.setCurso(2021);
		grupo.setId(1231546);
		grupo.setIngles('0');
		grupo.setLetra('A');
		grupo.setPlazas("25");
		grupo.setTitulacionGrupo(titulacion);
		grupo.setTurno_mañana_tarde("Mañana");
		grupo.setVisible('1');
		em.persist(grupo);

		// Clase
		Clase clase = new Clase();
		List<Clase> listaClase = new ArrayList<Clase>();
		listaClase.add(clase);

		clase.setAsignaturaClase(asignatura);
		clase.setDia(new Date(22 / 04 / 2021));
		clase.setGrupoClase(grupo);
		clase.setHoraFin(new Date(21 / 07 / 2021));
		clase.setHoraInicio(new Date(14 / 05 / 2021));
		em.persist(clase);

		// GruposAsignatura
		GruposAsignatura gruposAsignatura = new GruposAsignatura();
		List<GruposAsignatura> listaGruposAsignatura = new ArrayList<GruposAsignatura>();
		listaGruposAsignatura.add(gruposAsignatura);

		gruposAsignatura.setCursoAcademico("2021");
		gruposAsignatura.setOferta('1');
		gruposAsignatura.setGrupoGruposAsignatura(grupo);
		gruposAsignatura.setAsignaturaGruposAsignatura(asignatura);
		gruposAsignatura.setEncuestaGruposAsignatura(listaEncuesta);
		em.persist(gruposAsignatura);

		// AsignaturasMatricula
		AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula.add(asignaturasMatricula);

		asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
		asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
		asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);
		em.persist(asignaturasMatricula);

		/*
		 * 
		 * matricula.setAsignaturasMatriculaMatricula(listaAsignaturasMatricula);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * grupo.setGruposAsignaturaGrupo(listaGruposAsignatura);
		 * grupo.setClasesGrupo(listaClase);
		 * grupo.setAsignaturasMatriculaGrupo(listaAsignaturasMatricula);
		 * //grupo.setGrupoGrupo(); //grupo.setGrupoReflexiva();
		 * 
		 * 
		 * asignatura.setGruposAsignaturaAsignatura(listaGruposAsignatura);
		 * asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
		 * asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
		 * asignatura.setClaseAsignatura(listaClase);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * expediente.setEncuestaExpediente(listaEncuesta);
		 * expediente.setMatriculaExpediente(listaMatricula);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * titulacion.setAsignaturaTitulacion(listaAsignatura);
		 * titulacion.setExpedienteTitulacion(listaExpediente);
		 * titulacion.setGrupoTitulacion(listaGrupo);
		 * 
		 * 
		 * 
		 * 
		 */

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
