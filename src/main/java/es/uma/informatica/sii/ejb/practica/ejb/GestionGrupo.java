package es.uma.informatica.sii.ejb.practica.ejb;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;

@Local
public interface GestionGrupo {

	// CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) GRUPO

	public void createGrupo(Grupo grupo) throws ObjetoYaExistenteException;

	public Grupo readGrupo(Integer idGrupo) throws ObjetoNoExistenteException;

	public void updateGrupo(Grupo grupo) throws ObjetoNoExistenteException;

	public void deleteGrupo(Integer idGrupo) throws ObjetoNoExistenteException;

	/**
	 * AL ALUMNO IDENTIFICADO CON SU ID SE LE ASIGNAN LOS GRUPOSASIGNATURA DADOS POR
	 * lista SI EL PERSONAL DE SECRETARIA ACCEDE A REALIZAR EL CAMBIO, CON LO CUAL
	 * EL PARAMETRO CAMBIOACEPTADO ESTARA A TRUE. EN CASO CONTRARIO, NO SE REALIZARA
	 * EL CAMBIO DE GRUPO
	 * 
	 * @param idAlumno
	 * @param lista
	 * @param cambioAceptado
	 * @throws ObjetoNoExistenteException
	 */

	public void gestionarCambioGrupo(Integer idAlumno, List<GruposAsignatura> lista, boolean cambioAceptado)
			throws ObjetoNoExistenteException;

}
