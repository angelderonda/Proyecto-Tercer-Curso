package es.uma.informatica.sii.ejb.practica;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.AsignaturasMatricula;
import es.uma.informatica.sii.ejb.practica.entidades.Centro;
import es.uma.informatica.sii.ejb.practica.entidades.Clase;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.Ingrediente;
import es.uma.informatica.sii.ejb.practica.entidades.Lote;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula;
import es.uma.informatica.sii.ejb.practica.entidades.Producto;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		
		//Asignatura
		Asignatura asignatura = new Asignatura();
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		
		//Centro
		Centro centro = new Centro();
		List<Centro> listaCentro= new ArrayList<Centro>();
		
		//Grupo
		Grupo grupo = new Grupo();
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		
		//Titulacion
		Titulacion titulacion = new Titulacion ();
		
		 //Matricula
        Matricula matricula = new Matricula();
        
        //Clase
      	Clase clase1 = new Clase();
      	List<Clase> listaClase = new ArrayList<Clase>();
      	
      	//Expediente
      	Expediente expediente = new Expediente();
      	
      	//AsignaturasMatricula
        AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();        
        List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();        
        listaAsignaturasMatricula.add(asignaturasMatricula);
		
        asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
        asignatura.setClaseAsignatura(listaClase);
        asignatura.setCodigo(1456156);
        asignatura.setCreditosPracticas(6);
        asignatura.setCreditosTeoria(6);
        asignatura.setCurso();
        asignatura.setDuracion("1º cuatrimestre");
        asignatura.setGruposAsignaturaAsignatura();
        asignatura.setNombre("Cálculo");
        asignatura.setOfertada("Si");
        asignatura.setOtros_idiomas("Inglés");
        asignatura.setPlazas("25");
        asignatura.setReferencia(564846687);
        asignatura.setTipo("Obligatoria");
        asignatura.setTitulacionAsignatura(titulacion);     
        asignatura.setAsignaturasMatriculaAsignatura(listaAsignaturasMatricula);
        
		
        
		
		
		centro.setId(1041);
		centro.setDireccion("Calle Malaga");
		centro.setNombre("Centro Informatica");
		centro.setTelefono_conserjeria("690329116");
		
		
		
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
        expediente.setNotaMediaProvisional(9);
        expediente.setNumeroExpediente(102474112);
        expediente.setTitulacionExpediente(titulacion);
		
		
		
		grupo.setAsignar("Si");
		grupo.setAsignaturasMatriculaGrupo(listaAsignaturasMatricula);
		grupo.setClasesGrupo(listaClase);
		grupo.setCurso();
		grupo.setGrupoGrupo();
		grupo.setGrupoReflexiva();
		grupo.setGruposAsignaturaGrupo();
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
        matricula.setFechaMatricula("22/04/2021");
        matricula.setNuevoIngreso(1);
        matricula.setNumeroArchivo(123344556);
        matricula.setTurnoPreferente("Mañana");
		
		
		
		
		
		clase1.setAsignaturaClase(asignatura);		
		clase1.setDia(new Date(2021,9,17));
		clase1.setGrupoClase(grupo);
		clase1.setHoraFin(new Date());
		clase1.setHoraInicio(new Date());
		
		
		
		
		       
		asignaturasMatricula.setAsignaturaAsignaturasMatricula(asignatura);
        asignaturasMatricula.setGrupoAsignaturasMatricula(grupo);
        asignaturasMatricula.setMatriculaAsignaturasMatricula(matricula);
        
        
		
		for (Ingrediente ingrediente: new Ingrediente [] {carne, pimienta, especias, pimenton, sal, azucar, perejil}) {
			em.persist(ingrediente);
		}
		
		Producto chorizo = new Producto ("Chorizo");
		Producto salchicha = new Producto ("Salchicha");
		Producto hamburguesa = new Producto ("Hamburguesa");
		
		chorizo.setIngredientes(Stream.of(carne, pimienta, pimenton, sal)
				.collect(Collectors.toSet()));
		
		salchicha.setIngredientes(Stream.of(carne, sal, azucar, perejil)
				.collect(Collectors.toSet()));
		
		hamburguesa.setIngredientes(Stream.of(carne, especias, sal, azucar)
				.collect(Collectors.toSet()));
		
		for (Producto producto: new Producto [] {chorizo, salchicha, hamburguesa}) {
			em.persist(producto);
		}
		
		Lote lote = new Lote ("LT1", chorizo, BigDecimal.TEN, Date.valueOf("2021-04-11"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C1");
		lote.getLoteIngredientes().put(pimienta, "Pi1");
		lote.getLoteIngredientes().put(pimenton, "PM1");
		lote.getLoteIngredientes().put(sal, "S1");
		
		em.persist(lote);
		
		lote = new Lote ("LT2", chorizo, BigDecimal.valueOf(25L), Date.valueOf("2021-04-12"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C2");
		lote.getLoteIngredientes().put(pimienta, "Pi2");
		lote.getLoteIngredientes().put(pimenton, "PM2");
		lote.getLoteIngredientes().put(sal, "S2");
		
		em.persist(lote);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
