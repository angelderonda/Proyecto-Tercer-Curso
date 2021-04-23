package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Matricula
* Indica la elección del alumnado para turnos y asignaturas.
*/

@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable{
	
	public static class MatriculaId implements Serializable{

		private static final long serialVersionUID = 1L;
	
		private String cursoAcademico;		
		private Integer expedienteMatricula;
		
		public MatriculaId() {
			super();
		}
		
		public MatriculaId(String cursoAcademico, Integer expedienteMatricula) {
			super();
			this.cursoAcademico = cursoAcademico;
			this.expedienteMatricula = expedienteMatricula;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
			result = prime * result + ((expedienteMatricula == null) ? 0 : expedienteMatricula.hashCode());
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
			MatriculaId other = (MatriculaId) obj;
			if (cursoAcademico == null) {
				if (other.cursoAcademico != null)
					return false;
			} else if (!cursoAcademico.equals(other.cursoAcademico))
				return false;
			if (expedienteMatricula == null) {
				if (other.expedienteMatricula != null)
					return false;
			} else if (!expedienteMatricula.equals(other.expedienteMatricula))
				return false;
			return true;
		}
		
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private String cursoAcademico;
	@Column(name = "ESTADO", nullable = false, columnDefinition = "VARCHAR2(100) DEFAULT 'Activa'")
	private String estado;
	@Column(name = "FECHA_MATRICULA", nullable = false)
	private Date fechaMatricula;
	@Column(name = "NUEVO_INGRESO", columnDefinition = "number(1) default 1" )
	private Integer nuevoIngreso;
	@Column(name = "NUMERO_ARCHIVO")
	private Integer numeroArchivo;
	@Column(name = "TURNO_PREFERENTE")
	private String turnoPreferente;

	


	//Relacion muchos a uno con expediente
	@Id
	@ManyToOne(optional = false,cascade=CascadeType.REMOVE)	
	private Expediente expedienteMatricula;
	
	//Relacion uno a muchos con asignaturaMatricula
	@OneToMany(mappedBy="matriculaAsignaturasMatricula",cascade=CascadeType.REMOVE)
	private List<AsignaturasMatricula> asignaturasMatriculaMatricula;
	

	
	
	//Getters y Setters

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Integer getNumeroArchivo() {
		return numeroArchivo;
	}

	public void setNumeroArchivo(Integer numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}

	public String getTurnoPreferente() {
		return turnoPreferente;
	}

	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}

	public Integer getNuevoIngreso() {
		return nuevoIngreso;
	}

	public void setNuevoIngreso(Integer nuevoIngreso) {
		this.nuevoIngreso = nuevoIngreso;
	}

	public Expediente getExpedienteMatricula() {
		return expedienteMatricula;
	}

	public void setExpedienteMatricula(Expediente expedienteMatricula) {
		this.expedienteMatricula = expedienteMatricula;
	}

	public List<AsignaturasMatricula> getAsignaturasMatriculaMatricula() {
		return asignaturasMatriculaMatricula;
	}

	public void setAsignaturasMatriculaMatricula(List<AsignaturasMatricula> asignaturasMatriculaMatricula) {
		this.asignaturasMatriculaMatricula = asignaturasMatriculaMatricula;
	}
	
	
	//toString
	
	@Override
	public String toString() {
		return "Matricula [cursoAcademico=" + cursoAcademico + "]";
	}
	
	
	//HashCode & Equals	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursoAcademico == null) ? 0 : cursoAcademico.hashCode());
		result = prime * result + ((expedienteMatricula == null) ? 0 : expedienteMatricula.hashCode());
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
		Matricula other = (Matricula) obj;
		if (cursoAcademico == null) {
			if (other.cursoAcademico != null)
				return false;
		} else if (!cursoAcademico.equals(other.cursoAcademico))
			return false;
		if (expedienteMatricula == null) {
			if (other.expedienteMatricula != null)
				return false;
		} else if (!expedienteMatricula.equals(other.expedienteMatricula))
			return false;
		return true;
	}
	
	
	
}