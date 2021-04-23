package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import javax.persistence.*;

import es.uma.informatica.sii.ejb.practica.entidades.Asignatura.AsignaturaId;
import es.uma.informatica.sii.ejb.practica.entidades.Matricula.MatriculaId;

/**
* @author Los Datografos 
* Clase: AsignaturasMatricula
* Esta clase se utiliza para relacionar las asignaturas elegidas en una matrícula y con el/los grupo/s en el/los que se van a impartir las mismas.
*/

@Entity
@IdClass(AsignaturasMatricula.AsignaturasMatriculaId.class)
public class AsignaturasMatricula implements Serializable{
	
	public static class AsignaturasMatriculaId implements Serializable{

		private static final long serialVersionUID = 1L;
				
		
		
		private MatriculaId matriculaAsignaturasMatricula;	
		private AsignaturaId asignaturaAsignaturasMatricula;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((asignaturaAsignaturasMatricula == null) ? 0 : asignaturaAsignaturasMatricula.hashCode());
			result = prime * result
					+ ((matriculaAsignaturasMatricula == null) ? 0 : matriculaAsignaturasMatricula.hashCode());
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
			AsignaturasMatriculaId other = (AsignaturasMatriculaId) obj;
			if (asignaturaAsignaturasMatricula == null) {
				if (other.asignaturaAsignaturasMatricula != null)
					return false;
			} else if (!asignaturaAsignaturasMatricula.equals(other.asignaturaAsignaturasMatricula))
				return false;
			if (matriculaAsignaturasMatricula == null) {
				if (other.matriculaAsignaturasMatricula != null)
					return false;
			} else if (!matriculaAsignaturasMatricula.equals(other.matriculaAsignaturasMatricula))
				return false;
			return true;
		}

		
		
		
		
		
	}
	
	private static final long serialVersionUID = 1L;
		
	
	//Relacion muchos a uno con asignatura
	@Id
	@ManyToOne(optional = false,cascade=CascadeType.REMOVE)
	private Asignatura asignaturaAsignaturasMatricula;
	
	//Relacion muchos a uno con matricula
	@Id
	@ManyToOne(optional = false,cascade=CascadeType.REMOVE)
	private Matricula matriculaAsignaturasMatricula;
	
	//Relacion muchos a uno con grupo
	@ManyToOne(optional = false,cascade=CascadeType.REMOVE)
	private Grupo grupoAsignaturasMatricula;

	//Getters y Setters
	
	public Asignatura getAsignaturaAsignaturasMatricula() {
		return asignaturaAsignaturasMatricula;
	}

	public void setAsignaturaAsignaturasMatricula(Asignatura asignaturaAsignaturasMatricula) {
		this.asignaturaAsignaturasMatricula = asignaturaAsignaturasMatricula;
	}

	public Matricula getMatriculaAsignaturasMatricula() {
		return matriculaAsignaturasMatricula;
	}

	public void setMatriculaAsignaturasMatricula(Matricula matriculaAsignaturasMatricula) {
		this.matriculaAsignaturasMatricula = matriculaAsignaturasMatricula;
	}

	public Grupo getGrupoAsignaturasMatricula() {
		return grupoAsignaturasMatricula;
	}

	public void setGrupoAsignaturasMatricula(Grupo grupoAsignaturasMatricula) {
		this.grupoAsignaturasMatricula = grupoAsignaturasMatricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((asignaturaAsignaturasMatricula == null) ? 0 : asignaturaAsignaturasMatricula.hashCode());
		result = prime * result
				+ ((matriculaAsignaturasMatricula == null) ? 0 : matriculaAsignaturasMatricula.hashCode());
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
		AsignaturasMatricula other = (AsignaturasMatricula) obj;
		if (asignaturaAsignaturasMatricula == null) {
			if (other.asignaturaAsignaturasMatricula != null)
				return false;
		} else if (!asignaturaAsignaturasMatricula.equals(other.asignaturaAsignaturasMatricula))
			return false;
		if (matriculaAsignaturasMatricula == null) {
			if (other.matriculaAsignaturasMatricula != null)
				return false;
		} else if (!matriculaAsignaturasMatricula.equals(other.matriculaAsignaturasMatricula))
			return false;
		return true;
	}
	
	//NO NECESITA DE TO STRING AL SER UNA TABLA INTERMEDIA
	
	
	
	
	
	
	
}
