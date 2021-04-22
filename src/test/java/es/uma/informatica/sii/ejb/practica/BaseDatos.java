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
		
		//Titulacion
		Titulacion informatica = new Titulacion ();
		informatica.setCodigo(1041);
		informatica.setCreditos(240);
		informatica.setNombre("Informatica");
		informatica.setAsignaturaTitulacion();
		informatica.setCentroTitulacion();
		informatica.setExpedienteTitulacion();
		informatica.setGrupoTitulacion();
		
		//Asignatura
		Asignatura asignatura = new Asignatura();
        asignatura.setAsignaturasMatriculaAsignatura(asignaturasMatriculaAsignatura);
        asignatura.setClaseAsignatura(claseAsignatura);
        asignatura.setCodigo(codigo);
        asignatura.setCreditosPracticas(creditosPracticas);
        asignatura.setCreditosTeoria(creditosTeoria);
        asignatura.setCurso(curso);
        asignatura.setDuracion(duracion);
        asignatura.setGruposAsignaturaAsignatura(gruposAsignaturaAsignatura);
        asignatura.setNombre(nombre);
        asignatura.setOfertada(ofertada);
        asignatura.setOtros_idiomas(otros_idiomas);
        asignatura.setPlazas(plazas);
        asignatura.setReferencia(564846687);
        asignatura.setTipo(tipo);
        asignatura.setTitulacionAsignatura(titulacion);
        asignatura.setAsignaturasMatriculaAsignatura(asignaturasMatriculaAsignatura);
		
        
        //AsignaturasMatricula
        AsignaturasMatricula asignaturasMatricula = new AsignaturasMatricula();
        asignaturasMatricula.setAsignaturaAsignaturasMatricula();
        asignaturasMatricula.setGrupoAsignaturasMatricula();
        asignaturasMatricula.setMatriculaAsignaturasMatricula();
        
        List<AsignaturasMatricula> listaAsignaturasMatricula = new ArrayList<AsignaturasMatricula>();
        listaAsignaturasMatricula.add(asignaturasMatricula);
        
        //Matricula
        Matricula matricula = new Matricula();
        
        matricula.setAsignaturasMatriculaMatricula(listaAsignaturasMatricula);
        matricula.setCursoAcademico("2020/2021");
        matricula.setEstado("Activo");
        matricula.setExpedienteMatricula(expediente);
        matricula.setFechaMatricula("22/04/2021");
        matricula.setNuevoIngreso(1);
        matricula.setNumeroArchivo(123344556);
        matricula.setTurnoPreferente("Mañana");
		
		//Centro
		Centro centro = new Centro();
		centro.setId(1041);
		centro.setDireccion("Calle Malaga");
		centro.setNombre("Centro Informatica");
		centro.setTelefono_conserjeria("690329116");
		
		
		//Clase
		Clase clase1 = new Clase();
		clase1.setAsignaturaClase();
		clase1.setDia();
		clase1.setGrupoClase();
		clase1.setHoraFin();
		clase1.setHoraInicio();
		
		//Grupo
		Grupo grupo = new Grupo();
		grupo.setAsignar(asignar);
		grupo.setAsignaturasMatriculaGrupo(asignaturasMatriculaGrupo);
		grupo.setClasesGrupo(clasesGrupo);
		grupo.setCurso(curso);
		grupo.setGrupoGrupo(grupoGrupo);
		grupo.setGrupoReflexiva(grupoReflexiva);
		grupo.setGruposAsignaturaGrupo(gruposAsignaturaGrupo);
		grupo.setId(id);
		grupo.setIngles(ingles);
		grupo.setLetra(letra);
		grupo.setPlazas(plazas);
		grupo.setTitulacionGrupo(titulacionGrupo);
		grupo.setTurno_mañana_tarde(turno_mañana_tarde);
		grupo.setVisible(visible);
		
		
		
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
