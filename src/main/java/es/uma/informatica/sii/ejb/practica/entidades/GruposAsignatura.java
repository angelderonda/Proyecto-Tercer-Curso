package es.uma.informatica.sii.ejb.practica.entidades;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;

/**
* @author Los Datografos 
* Clase:GruposAsignatura
* Indica la variación que hay dentro de los grupos para cada asignatura. Todos los alumnos de un grupo no tienen las mismas asignaturas 
* sino que hay un grupo de alumnos por cada asigntura que puede no coincidir en otras asignaturas.
*/

@Entity
@IdClass(GruposAsignatura.GruposAsignaturaId.class)
public class GruposAsignatura implements Serializable{
	
	public static class GruposAsignaturaId implements Serializable{
		private static final long serialVersionUID = 1L;		
		private Integer cursoAcademico;
		//PK de grupo		
		private Integer grupoGruposAsignatura;
		//PK de asignatura		
		private AsignaturaId asignaturaGruposAsignatura;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((asignaturaGruposAsignatura == null) ? 0 : asignaturaGruposAsignatura.hashCode());
			result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
			result = prime * result + ((grupoGruposAsignatura == null) ? 0 : grupoGruposAsignatura.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GruposAsignaturaId other = (GruposAsignaturaId) obj;
			if (asignaturaGruposAsignatura == null) {
				if (other.asignaturaGruposAsignatura != null)
					return false;
			} else if (!asignaturaGruposAsignatura.equals(other.asignaturaGruposAsignatura))
				return false;
			if (cursoAcademico == null) {
				if (other.cursoAcademico != null)
					return false;
			} else if (!cursoAcademico.equals(other.cursoAcademico))
				return false;
			if (grupoGruposAsignatura == null) {
				if (other.grupoGruposAsignatura != null)
					return false;
			} else if (!grupoGruposAsignatura.equals(other.grupoGruposAsignatura))
				return false;
			return true;
		}	
		
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer cursoAcademico;
	@Column(name = "OFERTA", columnDefinition = "char(1)")	
	private char oferta;

	
	
	//Relacion muchos a uno con grupo
	@Id
	@ManyToOne(optional = false)
	private Grupo grupoGruposAsignatura;
	
	//Relacion muchos a uno con asignatura
	@Id
	@ManyToOne(optional = false)
	private Asignatura asignaturaGruposAsignatura;
	
	
	//Relacion muchos a muchos con encuesta
	@ManyToMany
	private List<Encuesta> encuestaGruposAsignatura;
		
	//Getters and Setters
	
	public Integer getCurso_academico() {
		return cursoAcademico;
	}
	public void setCurso_academico(Integer cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}
	public char getOferta() {
		return oferta;
	}
	public void setOferta(char oferta) {
		this.oferta = oferta;
	}
	
	public Integer getCursoAcademico() {
		return cursoAcademico;
	}
	public void setCursoAcademico(Integer cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}
	public Grupo getGrupoGruposAsignatura() {
		return grupoGruposAsignatura;
	}
	public void setGrupoGruposAsignatura(Grupo grupoGruposAsignatura) {
		this.grupoGruposAsignatura = grupoGruposAsignatura;
	}
	public Asignatura getAsignaturaGruposAsignatura() {
		return asignaturaGruposAsignatura;
	}
	public void setAsignaturaGruposAsignatura(Asignatura asignaturaGruposAsignatura) {
		this.asignaturaGruposAsignatura = asignaturaGruposAsignatura;
	}
	public List<Encuesta> getEncuestaGruposAsignatura() {
		return encuestaGruposAsignatura;
	}
	public void setEncuestaGruposAsignatura(List<Encuesta> encuestaGruposAsignatura) {
		this.encuestaGruposAsignatura = encuestaGruposAsignatura;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "GruposAsignatura [curso_academico=" + cursoAcademico + ", oferta=" + oferta + "]";
	}
	
	//HashCode and Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GruposAsignatura other = (GruposAsignatura) obj;
		if (cursoAcademico == null) {
			if (other.cursoAcademico != null)
				return false;
		} else if (!cursoAcademico.equals(other.cursoAcademico))
			return false;
		return true;
	}

	

	
	
}
