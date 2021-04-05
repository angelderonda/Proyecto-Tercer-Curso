package proyecto.jpa;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
		@SuppressWarnings("unused")
		private Integer cursoAcademico;
		//PK de grupo
		@SuppressWarnings("unused")
		private Integer id;
		//PK de asignatura
		@SuppressWarnings("unused")
		private Long referencia;	
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer cursoAcademico;
	@Column(name = "OFERTA")	
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
