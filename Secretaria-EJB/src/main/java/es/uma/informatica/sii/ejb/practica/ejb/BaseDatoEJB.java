package es.uma.informatica.sii.ejb.practica.ejb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;
import es.uma.informatica.sii.ejb.practica.entidades.Clase;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Startup
@Singleton
public class BaseDatoEJB implements GestionBD {

	@PersistenceContext(unitName = "Secretaria")
	private EntityManager em;

	@PostConstruct
	public void construyeBD() {
		// Alumno 0

		Alumno alumno = new Alumno();

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

		// ALUMNO 1

		Alumno alumno1 = new Alumno();

		alumno1.setId(2);
		alumno1.setDni("254789A");
		alumno1.setNombreCompleto("Pepita");
		alumno1.setApellido1("Palotes");
		alumno1.setApellido2("Perez");
		alumno1.setEmailInstitucional("pepa@uma.es");
		alumno1.setEmailPersonal("pepita12@gmail.com");
		alumno1.setNumeroArchivo("1245780");
		alumno1.setNumeroMovil("66548448");
		alumno1.setNumeroTelefono("957412785");
		alumno1.setDireccion("Calle Margarito");
		alumno1.setLocalidad("Ronda");
		alumno1.setProvincia("Málaga");
		alumno1.setCp(29510);
		em.persist(alumno1);
		// alumno.setExpedienteAlumno(listaExpediente);

		// ALUMNO 3

		Alumno alumno3 = new Alumno();

		alumno3.setId(3);
		alumno3.setDni("254789B");
		alumno3.setNombreCompleto("Manolo");
		alumno3.setApellido1("Garcia");
		alumno3.setApellido2("Perez");
		alumno3.setEmailInstitucional("manolo@uma.es");
		alumno3.setEmailPersonal("manolo12@gmail.com");
		alumno3.setNumeroArchivo("1245780");
		alumno3.setNumeroMovil("66548449");
		alumno3.setNumeroTelefono("957412783");
		alumno3.setDireccion("Calle Tulipan");
		alumno3.setLocalidad("Mijas");
		alumno3.setProvincia("Málaga");
		alumno3.setCp(29515);
		em.persist(alumno3);
		// alumno.setExpedienteAlumno(listaExpediente);

		// ALUMNO 4

		Alumno alumno4 = new Alumno();

		alumno4.setId(4);
		alumno4.setDni("254789P");
		alumno4.setNombreCompleto("Pablo");
		alumno4.setApellido1("Espinosa");
		alumno4.setApellido2("Perez");
		alumno4.setEmailInstitucional("pablo@uma.es");
		alumno4.setEmailPersonal("pablo15@gmail.com");
		alumno4.setNumeroArchivo("1245790");
		alumno4.setNumeroMovil("66548441");
		alumno4.setNumeroTelefono("957412780");
		alumno4.setDireccion("Calle Tulipan");
		alumno4.setLocalidad("Fuengirola");
		alumno4.setProvincia("Málaga");
		alumno4.setCp(29510);
		em.persist(alumno4);
		// alumno.setExpedienteAlumno(listaExpediente);

		// Alumno 5
		Alumno alumno5 = new Alumno();

		alumno5.setId(5);
		alumno5.setDni("254789K");
		alumno5.setNombreCompleto("Angelito");
		alumno5.setApellido1("García");
		alumno5.setApellido2("Lorca");
		alumno5.setEmailInstitucional("angelito@uma.es");
		alumno5.setEmailPersonal("angel00@gmail.com");
		alumno5.setNumeroArchivo("124570");
		alumno5.setNumeroMovil("66548445");
		alumno5.setNumeroTelefono("957412780");
		alumno5.setDireccion("Calle Amapola");
		alumno5.setLocalidad("Ronda");
		alumno5.setProvincia("Málaga");
		alumno5.setCp(29510);
		em.persist(alumno5);

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

		// EXPEDIENTE 1

		Expediente expediente1 = new Expediente();
		listaExpediente.add(expediente1);

		expediente1.setActivo('1');
		expediente1.setCreditosCF(0);
		expediente1.setCreditosFB(0);
		expediente1.setCreditosMO(0);
		expediente1.setCreditosOP(0);
		expediente1.setCreditosPE(0);
		expediente1.setCreditosTF(0);
		expediente1.setNotaMediaProvisional((float) 7.00);
		expediente1.setNumeroExpediente(102474113);
		expediente1.setAlumnoExpediente(alumno1);
		expediente1.setTitulacionExpediente(titulacion);
		em.persist(expediente1);

		// Expediente 3
		Expediente expediente3 = new Expediente();
		listaExpediente.add(expediente3);

		expediente3.setActivo('1');
		expediente3.setCreditosCF(0);
		expediente3.setCreditosFB(0);
		expediente3.setCreditosMO(0);
		expediente3.setCreditosOP(0);
		expediente3.setCreditosPE(0);
		expediente3.setCreditosTF(0);
		expediente3.setNotaMediaProvisional((float) 8.45);
		expediente3.setNumeroExpediente(102474116);
		expediente3.setAlumnoExpediente(alumno3);
		expediente3.setTitulacionExpediente(titulacion);
		em.persist(expediente3);

		// Expediente 4
		Expediente expediente4 = new Expediente();
		listaExpediente.add(expediente4);

		expediente4.setActivo('1');
		expediente4.setCreditosCF(0);
		expediente4.setCreditosFB(0);
		expediente4.setCreditosMO(0);
		expediente4.setCreditosOP(0);
		expediente4.setCreditosPE(0);
		expediente4.setCreditosTF(0);
		expediente4.setNotaMediaProvisional((float) 8.5);
		expediente4.setNumeroExpediente(102474119);
		expediente4.setAlumnoExpediente(alumno4);
		expediente4.setTitulacionExpediente(titulacion);
		em.persist(expediente4);

		// Expediente 5
		Expediente expediente5 = new Expediente();
		listaExpediente.add(expediente5);

		expediente5.setActivo('1');
		expediente5.setCreditosCF(0);
		expediente5.setCreditosFB(0);
		expediente5.setCreditosMO(0);
		expediente5.setCreditosOP(0);
		expediente5.setCreditosPE(0);
		expediente5.setCreditosTF(0);
		expediente5.setNotaMediaProvisional((float) 8);
		expediente5.setNumeroExpediente(102474120);
		expediente5.setAlumnoExpediente(alumno5);
		expediente5.setTitulacionExpediente(titulacion);
		em.persist(expediente5);
		
		// Matricula
		Matricula matricula = new Matricula();

		matricula.setCursoAcademico("2020/2021");
		matricula.setEstado("Activa");
		matricula.setExpedienteMatricula(expediente);
		matricula.setFechaMatricula(new java.util.Date());
		matricula.setNuevoIngreso(1);
		matricula.setNumeroArchivo(123344556);
		matricula.setTurnoPreferente("Mañana");
		em.persist(matricula);

		// Matricula 1
		Matricula matricula1 = new Matricula();

		matricula1.setCursoAcademico("2020/2021");
		matricula1.setEstado("Activa");
		matricula1.setExpedienteMatricula(expediente1);
		matricula1.setFechaMatricula(new java.util.Date());
		matricula1.setNuevoIngreso(1);
		matricula1.setNumeroArchivo(1245780);
		matricula1.setTurnoPreferente("Mañana");
		em.persist(matricula1);

		// Matricula 3
		Matricula matricula3 = new Matricula();

		matricula3.setCursoAcademico("2020/2021");
		matricula3.setEstado("Activa");
		matricula3.setExpedienteMatricula(expediente3);
		matricula3.setFechaMatricula(new java.util.Date());
		matricula3.setNuevoIngreso(1);
		matricula3.setNumeroArchivo(123344553);
		matricula3.setTurnoPreferente("Mañana");
		em.persist(matricula3);

		// Matricula 4
		Matricula matricula4 = new Matricula();

		matricula4.setCursoAcademico("2020/2021");
		matricula4.setEstado("Activa");
		matricula4.setExpedienteMatricula(expediente4);
		matricula4.setFechaMatricula(new java.util.Date());
		matricula4.setNuevoIngreso(1);
		matricula4.setNumeroArchivo(123344559);
		matricula4.setTurnoPreferente("Mañana");
		em.persist(matricula4);

		// Encuesta
		Encuesta encuesta = new Encuesta();
		List<Encuesta> listaEncuesta = new ArrayList<Encuesta>();
		listaEncuesta.add(encuesta);

		encuesta.setFechaEnvio(new java.util.Date());
		encuesta.setExpedienteEncuesta(expediente);
		em.persist(encuesta);

		// Encuesta1
		Encuesta encuesta1 = new Encuesta();
		// listaEncuesta.add(encuesta1);

		encuesta1.setFechaEnvio(new java.util.Date());
		encuesta1.setExpedienteEncuesta(expediente1);
		em.persist(encuesta1);

		// Encuesta4
		Encuesta encuesta4 = new Encuesta();
		// listaEncuesta.add(encuesta1);

		encuesta4.setFechaEnvio(new java.util.Date());
		encuesta4.setExpedienteEncuesta(expediente4);
		em.persist(encuesta4);
		List<Encuesta> listaEncuesta1 = new ArrayList<Encuesta>();
		listaEncuesta1.add(encuesta4);
		listaEncuesta1.add(encuesta1);
		listaEncuesta1.add(encuesta);

		// Asignatura
		Asignatura asignatura = new Asignatura();
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		listaAsignatura.add(asignatura);

		asignatura.setCodigo(1456156);
		asignatura.setCreditosPracticas(6);
		asignatura.setCreditosTeoria(6);
		// asignatura.setCurso(2021);
		asignatura.setCurso(1);
		asignatura.setDuracion("1º cuatrimestre");
		asignatura.setNombre("Cálculo");
		asignatura.setOfertada("Si");
		asignatura.setOtro_idioma("Inglés");
		asignatura.setPlazas("25");
		asignatura.setReferencia(564846687);
		asignatura.setTipo("Obligatoria");
		asignatura.setTitulacionAsignatura(titulacion);
		em.persist(asignatura);

		// Asignatura2
		Asignatura asignatura2 = new Asignatura();
		listaAsignatura.add(asignatura2);

		asignatura2.setCodigo(1456152);
		asignatura2.setCreditosPracticas(6);
		asignatura2.setCreditosTeoria(6);
		// asignatura.setCurso(2021);
		asignatura.setCurso(1);
		asignatura2.setDuracion("1º cuatrimestre");
		asignatura2.setNombre("Programación");
		asignatura2.setOfertada("Si");
		asignatura2.setOtro_idioma("Inglés");
		asignatura2.setPlazas("40");
		asignatura2.setReferencia(5648464);
		asignatura2.setTipo("Obligatoria");
		asignatura2.setTitulacionAsignatura(titulacion);
		em.persist(asignatura2);

		// Grupo 1A
		Grupo grupo = new Grupo();
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		listaGrupo.add(grupo);

		grupo.setAsignar("Si");

		// grupo.setCurso(2021);
		grupo.setCurso(1);
		grupo.setId(1231546);
		grupo.setIngles('0');
		grupo.setLetra('A');
		grupo.setPlazas("25");
		grupo.setTitulacionGrupo(titulacion);
		grupo.setTurno_mañana_tarde("Mañana");
		grupo.setVisible('1');
		em.persist(grupo);

		// Grupo 1B
		Grupo grupo1 = new Grupo();
		listaGrupo.add(grupo1);

		grupo1.setAsignar("Si");
		grupo1.setCurso(1);
		// grupo1.setCurso(2021);
		grupo1.setId(1231540);
		grupo1.setIngles('0');
		grupo1.setLetra('B');
		grupo1.setPlazas("25");
		grupo1.setTitulacionGrupo(titulacion);
		grupo1.setTurno_mañana_tarde("Mañana");
		grupo1.setVisible('1');
		em.persist(grupo1);

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
		gruposAsignatura.setCursoAcademico("2020/2021");
		gruposAsignatura.setOferta('1');
		gruposAsignatura.setGrupoGruposAsignatura(grupo);
		gruposAsignatura.setAsignaturaGruposAsignatura(asignatura);
		// gruposAsignatura.setEncuestaGruposAsignatura(listaEncuesta);

		em.persist(gruposAsignatura);

		// GruposAsignatura1
		GruposAsignatura gruposAsignatura1 = new GruposAsignatura();
		listaGruposAsignatura.add(gruposAsignatura1);

		gruposAsignatura1.setCursoAcademico("2020/2021");
		gruposAsignatura1.setOferta('1');
		gruposAsignatura1.setGrupoGruposAsignatura(grupo1);
		gruposAsignatura1.setAsignaturaGruposAsignatura(asignatura);
		gruposAsignatura1.setEncuestaGruposAsignatura(listaEncuesta1);

		em.persist(gruposAsignatura1);

		// GruposAsignatura2
		GruposAsignatura gruposAsignatura2 = new GruposAsignatura();
		listaGruposAsignatura.add(gruposAsignatura2);

		gruposAsignatura2.setCursoAcademico("2020/2021");
		gruposAsignatura2.setOferta('1');
		gruposAsignatura2.setGrupoGruposAsignatura(grupo1);
		gruposAsignatura2.setAsignaturaGruposAsignatura(asignatura2);
		// gruposAsignatura2.setEncuestaGruposAsignatura(listaEncuesta);

		em.persist(gruposAsignatura2);

		// GruposAsignatura3
		GruposAsignatura gruposAsignatura3 = new GruposAsignatura();
		listaGruposAsignatura.add(gruposAsignatura3);

		gruposAsignatura3.setCursoAcademico("2020/2021");
		gruposAsignatura3.setOferta('1');
		gruposAsignatura3.setGrupoGruposAsignatura(grupo);
		gruposAsignatura3.setAsignaturaGruposAsignatura(asignatura2);
		gruposAsignatura3.setEncuestaGruposAsignatura(listaEncuesta1);

		em.persist(gruposAsignatura3);

		encuesta.setGruposAsignaturaEncuesta(listaGruposAsignatura);

		// AsignaturasMatricula del Alumno 0
		AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula.add(asignaturasMatricula);

		asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
		asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
		asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);

		em.persist(asignaturasMatricula);

		AsignaturasMatricula asignaturasMatricula1 = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula1 = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula1.add(asignaturasMatricula1);

		asignaturasMatricula1.setAsignaturaAsignaturasMatricula(asignatura2);
		asignaturasMatricula1.setGrupoAsignaturasMatricula(grupo);
		asignaturasMatricula1.setMatriculaAsignaturasMatricula(matricula);
		em.persist(asignaturasMatricula1);

		// AsignaturasMatricula del Alumno 1
		AsignaturasMatricula asignaturasMatricula2 = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula2 = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula2.add(asignaturasMatricula2);

		asignaturasMatricula2.setAsignaturaAsignaturasMatricula(asignatura);
		asignaturasMatricula2.setGrupoAsignaturasMatricula(null);
		asignaturasMatricula2.setMatriculaAsignaturasMatricula(matricula1);

		em.persist(asignaturasMatricula2);

		AsignaturasMatricula asignaturasMatricula3 = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula3 = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula3.add(asignaturasMatricula3);

		asignaturasMatricula3.setAsignaturaAsignaturasMatricula(asignatura2);
		asignaturasMatricula3.setGrupoAsignaturasMatricula(null);
		asignaturasMatricula3.setMatriculaAsignaturasMatricula(matricula1);
		em.persist(asignaturasMatricula3);

		// AsignaturasMatricula del Alumno 4
		AsignaturasMatricula asignaturasMatricula4 = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula4 = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula4.add(asignaturasMatricula4);

		asignaturasMatricula4.setAsignaturaAsignaturasMatricula(asignatura);
		asignaturasMatricula4.setGrupoAsignaturasMatricula(null);
		asignaturasMatricula4.setMatriculaAsignaturasMatricula(matricula4);

		em.persist(asignaturasMatricula4);

		AsignaturasMatricula asignaturasMatricula5 = new AsignaturasMatricula();
		List<AsignaturasMatricula> listaAsignaturasMatricula5 = new ArrayList<AsignaturasMatricula>();
		listaAsignaturasMatricula5.add(asignaturasMatricula5);

		asignaturasMatricula5.setAsignaturaAsignaturasMatricula(asignatura2);
		asignaturasMatricula5.setGrupoAsignaturasMatricula(null);
		asignaturasMatricula5.setMatriculaAsignaturasMatricula(matricula4);
		em.persist(asignaturasMatricula5);

		/*
		 * encuesta.setGruposAsignaturaEncuesta(listaGruposAsignatura); //
		 * AsignaturasMatricula AsignaturasMatricula asignaturasMatricula = new
		 * AsignaturasMatricula(); List<AsignaturasMatricula> listaAsignaturasMatricula
		 * = new ArrayList<AsignaturasMatricula>();
		 * listaAsignaturasMatricula.add(asignaturasMatricula);
		 * 
		 * asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
		 * asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
		 * asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);
		 * em.persist(asignaturasMatricula);
		 */

		/*
		 * AsignaturasMatricula asignaturasMatricula1 = new AsignaturasMatricula();
		 * 
		 * asignaturasMatricula1.setAsignaturaAsignaturasMatricula(asignatura2);
		 * asignaturasMatricula1.setGrupoAsignaturasMatricula(grupo); // NO SE HACE NO
		 * TIENE GRUPOS
		 * asignaturasMatricula1.setMatriculaAsignaturasMatricula(matricula1);
		 * 
		 * // ME CREO ESTA ASIGNATURA MATRICULA CON LA MISMA ASIGNATURA QUE LA DE ARRIBA
		 * // PERO NO SE LA ASOCIO A NADIE AsignaturasMatricula asignaturasMatricula2 =
		 * new AsignaturasMatricula();
		 * asignaturasMatricula2.setAsignaturaAsignaturasMatricula(asignatura);
		 * asignaturasMatricula2.setGrupoAsignaturasMatricula(grupo1); // NO SE HACE NO
		 * TIENE GRUPOS
		 * asignaturasMatricula1.setMatriculaAsignaturasMatricula(matricula1);
		 * 
		 * em.persist(asignaturasMatricula1); em.persist(asignaturasMatricula2);
		 * List<AsignaturasMatricula> listaAsignaturasMatricula1 = new
		 * ArrayList<AsignaturasMatricula>();
		 * listaAsignaturasMatricula1.add(asignaturasMatricula1);
		 * listaAsignaturasMatricula1.add(asignaturasMatricula2);
		 */

		/*
		 * AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();
		 * List<AsignaturasMatricula> listaAsignaturasMatricula = new
		 * ArrayList<AsignaturasMatricula>();
		 * listaAsignaturasMatricula.add(asignaturasMatricula);
		 * 
		 * asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
		 * asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
		 * asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);
		 * em.persist(asignaturasMatricula);
		 * 
		 * /* matricula.setAsignaturasMatriculaMatricula(listaAsignaturasMatricula);
		 * grupo.setGruposAsignaturaGrupo(listaGruposAsignatura);
		 * grupo.setClasesGrupo(listaClase);
		 * grupo.setAsignaturasMatriculaGrupo(listaAsignaturasMatricula);
		 * //grupo.setGrupoGrupo(); //grupo.setGrupoReflexiva();
		 * asignatura.setGruposAsignaturaAsignatura(listaGruposAsignatura);
		 * asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
		 * asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
		 * asignatura.setClaseAsignatura(listaClase);
		 * expediente.setEncuestaExpediente(listaEncuesta);
		 * expediente.setMatriculaExpediente(listaMatricula);
		 * titulacion.setAsignaturaTitulacion(listaAsignatura);
		 * titulacion.setExpedienteTitulacion(listaExpediente);
		 * titulacion.setGrupoTitulacion(listaGrupo);
		 */

	}
}
