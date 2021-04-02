package proyecto.jpa;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase:GruposAsignatura
* Indica la variación que hay dentro de los grupos para cada asignatura. Todos los alumnos de un grupo no tienen las mismas asignaturas 
* sino que hay un grupo de alumnos por cada asigntura que puede no coincidir en otras asignaturas.
*/

@Entity
public class GruposAsignatura {
	
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer curso_academico;
	@Column(name = "OFERTA")	
	private char oferta;
	
	//Relacion muchos a muchos con encuesta
	@ManyToMany
	private List<Encuesta> encuestaGruposAsignatura;
	
	
	//Relacion muchos a uno con grupo
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="CURSO_ACADEMICO", referencedColumnName="REFERENCIA")
	private Grupo grupoGruposAsignatura;
	
	//Relacion muchos a uno con asignatura
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="CURSO_ACADEMICO", referencedColumnName="REFERENCIA")
	private Asignatura asignaturaGruposAsignatura;
	
	
	
	
	//Getters and Setters
	
	public Integer getCurso_academico() {
		return curso_academico;
	}
	public void setCurso_academico(Integer curso_academico) {
		this.curso_academico = curso_academico;
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
		return "GruposAsignatura [curso_academico=" + curso_academico + ", oferta=" + oferta + "]";
	}
	
	//HashCode and Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
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
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		return true;
	}

	

	
	
}
