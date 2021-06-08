package es.uma.informatica.sii.ejb.practica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Grupo;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura;
import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.GruposAsignatura.GruposAsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Titulacion;

@Stateless
public class GruposAsignaturaEJB implements GestionGruposAsignatura {

	@PersistenceContext(name = "Secretaria")
	private EntityManager em;

	@Override
	public void createGruposAsignatura(GruposAsignatura gruposAsignatura, Integer titulacionId, Integer grupoId, Integer referencia) throws ObjetoYaExistenteException {
		
		Grupo grupo = em.find(Grupo.class,grupoId);
		AsignaturaId asignaturaId = new AsignaturaId(referencia,titulacionId);
		Asignatura asig = em.find(Asignatura.class,asignaturaId);
		if (asig == null) {
			throw new ObjetoYaExistenteException("La asignatura asignatura no existe");
		}
		
		GruposAsignatura aux = em.find(GruposAsignatura.class, new GruposAsignaturaId(
				gruposAsignatura.getCursoAcademico(), grupo.getId(),
				asignaturaId));

		if (aux != null) {
			throw new ObjetoYaExistenteException("Este grupo asignatura ya existe");
		}
		gruposAsignatura.setAsignaturaGruposAsignatura(asig);
		gruposAsignatura.setGrupoGruposAsignatura(grupo);
		em.persist(gruposAsignatura);

	}

	@Override
	public GruposAsignatura readGrupoAsignatura(GruposAsignaturaId idGrupoAsignatura)
			throws ObjetoNoExistenteException {

		GruposAsignatura aux = em.find(GruposAsignatura.class, idGrupoAsignatura);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El grupo asignatura que buscas no existe");
		}

		return aux;
	}

	@Override
	public void updateGrupoAsignatura(GruposAsignatura gruposAsignatura) throws ObjetoNoExistenteException {

		Asignatura asignatura = gruposAsignatura.getAsignaturaGruposAsignatura();

		GruposAsignatura aux = em.find(GruposAsignatura.class, new GruposAsignaturaId(
				gruposAsignatura.getCursoAcademico(), gruposAsignatura.getGrupoGruposAsignatura().getId(),
				new AsignaturaId(asignatura.getReferencia(), asignatura.getTitulacionAsignatura().getCodigo())));
		if (aux == null) {
			throw new ObjetoNoExistenteException("El grupo asignatura que buscas no existe");
		}
		// aux = asignatura;
		em.merge(gruposAsignatura);

	}

	@Override
	public void deleteGrupoAsignatura(GruposAsignaturaId idGrupoAsignatura) throws ObjetoNoExistenteException {

		GruposAsignatura aux = em.find(GruposAsignatura.class, idGrupoAsignatura);
		if (aux == null) {
			throw new ObjetoNoExistenteException("El grupo asignatura que buscas no existe");
		}
		em.remove(aux);

	}
	
	

}
