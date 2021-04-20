package es.uma.informatica.sii.ejb.practica.ejb;





import javax.ejb.Local;

import java.util.List;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Local
public interface GestionAlumno {
	
	public void createAlumno(Alumno alumno) throws ObjetoYaExistenteException;
	public Alumno readAlumno(Integer  idAlumno) throws ObjetoNoExistenteException;
	public void updateAlumno(Alumno alumno) throws ObjetoNoExistenteException;
	public void deleteAlumno(Integer  idAlumno) throws ObjetoNoExistenteException;
	
	//RF 10
	public void asignarGrupo(Alumno alumno, Grupo grupo) throws ProyectoException;
	
	//RF 11
	public List<Alumno> listarAlumnos(TipoFiltro filtro, int parametro) throws ProyectoException;
	
	//RF 12 - REVISA
	public void solicitarCambioDeGrupo(Integer idAlumno, List<GruposAsignatura> lista) throws ProyectoException;
	
	//RF 14
	/**
	 * LOS PARAMETROS ESCOGIDOS SON EL ALUMNO Y LA LISTA DE LOS GRUPOASIGNATURA (DEBIDO A QUE ESTA ENTIDAD
	 * AL SER DEBIL HEMOS PENSADO QUE ESCOGE TANTO EL ID DEL GRUPO COMO LA REFERENCIA DE ASIGNATURA
	 * Y ASI ES SUFICIENTE PARA RELLENAR LA ENECUESTA. EN LA PAGINA CADA ALUMNO PODRA ESCOGER LAS ASIGNATURAS Y LOS GRUPOS
	 * SEGUN LOS GRUPOSASIGNATURAS EXISTENTES EN LA BD)
	 * @param idAlumno
	 * @param lista
	 * @throws ProyectoException
	 */
	public void rellenarEncuesta(Integer idAlumno, List<GruposAsignatura> lista) throws ProyectoException;
	
	
	
	
}
