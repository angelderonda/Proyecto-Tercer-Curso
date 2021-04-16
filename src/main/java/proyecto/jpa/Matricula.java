package proyecto.jpa;

import java.io.Serializable;
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
		@SuppressWarnings("unused")
		private Integer cursoAcademico;
		@SuppressWarnings("unused")
		private Integer expedienteMatricula;
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer cursoAcademico;
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	@Column(name = "FECHA_MATRICULA", nullable = false)
	private String fechaMatricula;
	@Column(name = "NUEVO_INGRESO", columnDefinition = "char(1) default '0'" )
	private char nuevoIngreso;
	@Column(name = "NUMERO_ARCHIVO")
	private Integer numeroArchivo;
	@Column(name = "TURNO_PREFERENTE")
	private String turnoPreferente;

	


	//Relacion muchos a uno con expediente
	@Id
	@ManyToOne(optional = false)	
	private Expediente expedienteMatricula;
	
	//Relacion uno a muchos con asignaturaMatricula
	@OneToMany(mappedBy="matriculaAsignaturasMatricula")
	private List<AsignaturasMatricula> asignaturasMatriculaMatricula;
	

	
	
	//Getters y Setters

	public Integer getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(Integer cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fechaMatricula) {
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

	public char getNuevoIngreso() {
		return nuevoIngreso;
	}

	public void setNuevoIngreso(char nuevoIngreso) {
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
		return "Matricula [cursoAcademico=" + cursoAcademico + ", estado=" + estado + ", fechaMatricula="
				+ fechaMatricula + ", nuevoIngreso=" + nuevoIngreso + ", numeroArchivo=" + numeroArchivo
				+ ", turnoPreferente=" + turnoPreferente + ", expedienteMatricula=" + expedienteMatricula
				+ ", asignaturasMatriculaMatricula=" + asignaturasMatriculaMatricula + "]";
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