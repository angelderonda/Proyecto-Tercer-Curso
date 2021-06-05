package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Los Datografos Clase: Clase Esta clase indica el tramo horario y dia
 *         donde se imparte una asignatura concreto. Varias asignaturas de
 *         distintos grupos usan tramo horario simultáneo.
 */

@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {

	public static class ClaseId implements Serializable {

		private static final long serialVersionUID = 1L;

		private Date dia;
		private Date horaInicio;
		private Integer grupoClase;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dia == null) ? 0 : dia.hashCode());
			result = prime * result + ((grupoClase == null) ? 0 : grupoClase.hashCode());
			result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
			ClaseId other = (ClaseId) obj;
			if (dia == null) {
				if (other.dia != null)
					return false;
			} else if (!dia.equals(other.dia))
				return false;
			if (grupoClase == null) {
				if (other.grupoClase != null)
					return false;
			} else if (!grupoClase.equals(other.grupoClase))
				return false;
			if (horaInicio == null) {
				if (other.horaInicio != null)
					return false;
			} else if (!horaInicio.equals(other.horaInicio))
				return false;
			return true;
		}

	}

	private static final long serialVersionUID = 1L;

	@Column(name = "HORA_FIN")
	@Temporal(TemporalType.DATE)
	private Date horaFin;
	@Id
	@Column(name = "HORA_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date horaInicio;
	@Id
	@Column(name = "dia", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dia;

	// Relacion muchos a uno con Asignatura
	@ManyToOne(optional = false)
	private Asignatura asignaturaClase;

	// Relacion muchos a uno con Grupo
	@Id
	@ManyToOne(optional = false)
	private Grupo grupoClase;

	// Getters and Setters

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Asignatura getAsignaturaClase() {
		return asignaturaClase;
	}

	public void setAsignaturaClase(Asignatura asignaturaClase) {
		this.asignaturaClase = asignaturaClase;
	}

	public Grupo getGrupoClase() {
		return grupoClase;
	}

	public void setGrupoClase(Grupo grupoClase) {
		this.grupoClase = grupoClase;
	}

	// toString

	@Override
	public String toString() {
		return "Clase [horaInicio=" + horaInicio + ", dia=" + dia + "]";
	}

	// HashCode and Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((grupoClase == null) ? 0 : grupoClase.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
		Clase other = (Clase) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (grupoClase == null) {
			if (other.grupoClase != null)
				return false;
		} else if (!grupoClase.equals(other.grupoClase))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		return true;
	}

}
