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
		
		//Alumno
		Alumno alumno = new Alumno();    
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		listaAlumno.add(alumno);
		
		//Asignatura
		Asignatura asignatura = new Asignatura();
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		listaAsignatura.add(asignatura);
		
		//Centro
		Centro centro = new Centro();
		List<Centro> listaCentro= new ArrayList<Centro>();
		listaCentro.add(centro);
		
		//Encuesta
		Encuesta encuesta = new Encuesta();
		List<Encuesta> listaEncuesta = new ArrayList<Encuesta>();
		listaEncuesta.add(encuesta);
		
		//Grupo
		Grupo grupo = new Grupo();
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		listaGrupo.add(grupo);
			
		
		//Titulacion
		Titulacion titulacion = new Titulacion ();
		List<Titulacion> listaTitulacion = new ArrayList<Titulacion>();
		listaTitulacion.add(titulacion);
		
		 //Matricula
        Matricula matricula = new Matricula();
        List<Matricula> listaMatricula = new ArrayList<Matricula>();
      	listaMatricula.add(matricula);
        
        //Clase
      	Clase clase = new Clase();
      	List<Clase> listaClase = new ArrayList<Clase>();
      	listaClase.add(clase);
      	
      	//Expediente
      	Expediente expediente = new Expediente();
      	List<Expediente> listaExpediente = new ArrayList<Expediente>(); 
      	listaExpediente.add(expediente);
      	
      	//GruposAsignatura
      	GruposAsignatura gruposAsignatura = new GruposAsignatura();      
    	List<GruposAsignatura> listaGruposAsignatura = new ArrayList<GruposAsignatura>(); 
    	listaGruposAsignatura.add(gruposAsignatura);
      	
      	//AsignaturasMatricula
        AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();        
        List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();        
        listaAsignaturasMatricula.add(asignaturasMatricula);
        
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
        alumno.setExpedienteAlumno(listaExpediente);
        
		
        asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
        asignatura.setClaseAsignatura(listaClase);
        asignatura.setCodigo(1456156);
        asignatura.setCreditosPracticas(6);
        asignatura.setCreditosTeoria(6);
        asignatura.setCurso(2021);
        asignatura.setDuracion("1º cuatrimestre");
        asignatura.setGruposAsignaturaAsignatura(listaGruposAsignatura);
        asignatura.setNombre("Cálculo");
        asignatura.setOfertada("Si");
        asignatura.setOtro_idioma("Inglés");
        asignatura.setPlazas("25");
        asignatura.setReferencia(564846687);
        asignatura.setTipo("Obligatoria");
        asignatura.setTitulacionAsignatura(titulacion);     
        asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
        	
		
		centro.setId(1041);
		centro.setDireccion("Calle Malaga");
		centro.setNombre("Centro Informatica");
		centro.setTelefono_conserjeria("690329116");
		
		
		 encuesta.setFechaEnvio(new Date(18/05/2021));
	     encuesta.setGruposAsignaturaEncuesta(listaGruposAsignatura);
	     encuesta.setExpedienteEncuesta(expediente);
		
		
		
        expediente.setActivo('1');
        expediente.setAlumnoExpediente(alumno);
        expediente.setCreditosCF(5);
        expediente.setCreditosFB(5);
        expediente.setCreditosMO(5);
        expediente.setCreditosOP(5);
        expediente.setCreditosPE(5);        
        expediente.setCreditosTF(5);
        expediente.setEncuestaExpediente(listaEncuesta);
        expediente.setMatriculaExpediente(listaMatricula);
        expediente.setNotaMediaProvisional((float) 9.45);
        expediente.setNumeroExpediente(102474112);
        expediente.setTitulacionExpediente(titulacion);
		
		
		
		grupo.setAsignar("Si");
		grupo.setAsignaturasMatriculaGrupo(listaAsignaturasMatricula);
		grupo.setClasesGrupo(listaClase);
		grupo.setCurso(2021);
		/*grupo.setGrupoGrupo();
		grupo.setGrupoReflexiva();*/
		grupo.setGruposAsignaturaGrupo(listaGruposAsignatura);
		grupo.setId(1231546);
		grupo.setIngles('0');
		grupo.setLetra('A');
		grupo.setPlazas("25");
		grupo.setTitulacionGrupo(titulacion);
		grupo.setTurno_mañana_tarde("Mañana");
		grupo.setVisible('1');
				
		

		
		titulacion.setCodigo(1041);
		titulacion.setCreditos(240);
		titulacion.setNombre("Informatica");
		titulacion.setAsignaturaTitulacion(listaAsignatura);
		titulacion.setCentroTitulacion(listaCentro);
		titulacion.setExpedienteTitulacion(listaExpediente);
		titulacion.setGrupoTitulacion(listaGrupo);
        
        
       
        
        matricula.setAsignaturasMatriculaMatricula(listaAsignaturasMatricula);
        matricula.setCursoAcademico("2020/2021");
        matricula.setEstado("Activo");
        matricula.setExpedienteMatricula(expediente);
        matricula.setFechaMatricula(new Date(14/11/2021));
        matricula.setNuevoIngreso(1);
        matricula.setNumeroArchivo(123344556);
        matricula.setTurnoPreferente("Mañana");
		
		
        gruposAsignatura.setCursoAcademico("2021");
        gruposAsignatura.setOferta('1');
        gruposAsignatura.setGrupoGruposAsignatura(grupo);
        gruposAsignatura.setAsignaturaGruposAsignatura(asignatura);
        gruposAsignatura.setEncuestaGruposAsignatura(listaEncuesta);
		
		
		clase.setAsignaturaClase(asignatura);		
		clase.setDia(new Date(22/04/2021));
		clase.setGrupoClase(grupo);
		clase.setHoraFin(new Date(21/07/2021));
		clase.setHoraInicio(new Date(14/05/2021));
		
				       
		asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
        asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
        asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);
        
        
						
		em.persist(alumno);
		em.persist(asignatura);
		em.persist(asignaturasMatricula);
		em.persist(centro);
		em.persist(encuesta);
		em.persist(expediente);
		em.persist(grupo);
		em.persist(gruposAsignatura);		
		em.persist(titulacion);		
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
