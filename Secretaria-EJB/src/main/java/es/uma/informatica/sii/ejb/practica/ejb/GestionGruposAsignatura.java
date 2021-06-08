package es.uma.informatica.sii.ejb.practica.ejb;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;

public interface GestionGruposAsignatura {
	
	//CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) GRUPOSASIGNATURA

	public GruposAsignatura readGrupoAsignatura(GruposAsignaturaId idGrupoAsignatura) throws ObjetoNoExistenteException;

	public void updateGrupoAsignatura(GruposAsignatura gruposAsignatura) throws ObjetoNoExistenteException;

	public void deleteGrupoAsignatura(GruposAsignaturaId idGrupoAsignatura) throws ObjetoNoExistenteException;

	void createGruposAsignatura(GruposAsignatura gruposAsignatura, Integer titulacionId, Integer grupoId, Integer referencia) throws ObjetoYaExistenteException;

}
