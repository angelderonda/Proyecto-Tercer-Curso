package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Local;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;

public interface GestionGruposAsignatura {
	
	public void createGruposAsignatura(GruposAsignatura gruposAsignatura) throws ObjetoYaExistenteException;
	public GruposAsignatura readGrupoAsignatura(GruposAsignaturaId  idGrupoAsignatura) throws ObjetoNoExistenteException;
	public void updateGrupoAsignatura(GruposAsignatura gruposAsignatura) throws ObjetoNoExistenteException;
	public void deleteGrupoAsignatura(GruposAsignaturaId idGrupoAsignatura) throws ObjetoNoExistenteException;

}
