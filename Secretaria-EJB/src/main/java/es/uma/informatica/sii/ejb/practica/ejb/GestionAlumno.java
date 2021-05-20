package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;

import java.util.List;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Alumno;
import es.uma.informatica.sii.ejb.practica.entidades.Encuesta.EncuestaId;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Local
public interface GestionAlumno {

	// CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) ALUMNO

	public void createAlumno(Alumno alumno) throws ObjetoYaExistenteException;

	public Alumno readAlumno(Integer idAlumno) throws ObjetoNoExistenteException;

	public void updateAlumno(Alumno alumno) throws ObjetoNoExistenteException;

	public void deleteAlumno(Integer idAlumno) throws ObjetoNoExistenteException;

	/**
	 * AL ALUMNO IDENTIFICADO CON SU IDALUMNO, SE LE ASIGNARA LOS GRUPOSASIGNATURA
	 * lista SI MANUALMENTE ESTA ACTIVADO. SI MANUALMENTE ESTA DESCTIVADO SE LE
	 * ASIGNARA LOS GRUPOS DEPENDE DEL ALGORITMO. COMO EL ALGORITMO AUN NO SE NOS HA
	 * DADO AHORA MISMO ASIGNAMOS A ALUMNO EL GRUPO QUE HA ELEGIDO EN LA ENCUESTA
	 * REALIZADA PREVIAMENTE POR EL MISMO 
	 * 
	 * @param idAlumno
	 * @param lista
	 * @param idEncuesta
	 * @param manualmente
	 * @throws ObjetoNoExistenteException
	 */

	public void asignarGrupo(Integer idAlumno, List<GruposAsignatura> lista, EncuestaId idEncuesta, boolean manualmente)
			throws ObjetoNoExistenteException;

	public List<Alumno> listarAlumnos(TipoFiltro filtro, float parametro) throws ProyectoException;

	/**
	 * LOS PARAMETROS ESCOGIDOS SON EL ALUMNO Y LA LISTA DE LOS GRUPOASIGNATURA
	 * (DEBIDO A QUE ESTA ENTIDAD AL SER DEBIL HEMOS PENSADO QUE ESCOGE TANTO EL ID
	 * DEL GRUPO COMO LA REFERENCIA DE ASIGNATURA Y ASI ES SUFICIENTE PARA RELLENAR
	 * LA ENECUESTA. EN LA PAGINA CADA ALUMNO PODRA ESCOGER LAS ASIGNATURAS Y LOS
	 * GRUPOS SEGUN LOS GRUPOSASIGNATURAS EXISTENTES EN LA BD)
	 * 
	 * @param idAlumno
	 * @param lista
	 * @throws ProyectoException
	 */
	public void rellenarEncuesta(Integer idAlumno, List<GruposAsignatura> lista)
			throws ObjetoYaExistenteException, ObjetoNoExistenteException;

}
