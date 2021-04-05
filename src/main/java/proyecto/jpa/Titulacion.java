package proyecto.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Titulacion
* Indica el grado de tipo de estudios en el que hay distintos grupos y está compuesto por muchas asignaturas.
*/

@Entity
public class Titulacion implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CÓDIGO", nullable = false)
	private Long codigo;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "CREDITOS", nullable = false)
	private Integer creditos;
	
	//Relacion uno a muchos con asignatura
	@OneToMany(mappedBy="titulacionAsignatura")
	private List<Asignatura> asignaturaTitulacion;
	
	//Relacion uno a muchos con expediente
	@OneToMany(mappedBy="titulacionExpediente")
	private List<Expediente> expedienteTitulacion;
	
	//Relacion muchos a muchos con centro
	@ManyToMany
	private List<Centro> centroTitulacion;
	
	//Relacion uno a muchos con grupo
	@OneToMany(mappedBy = "titulacionGrupo")
	private List<Grupo> grupoTitulacion;
	
	//Getters y Setters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Asignatura> getAsignaturaTitulacion() {
		return asignaturaTitulacion;
	}

	public void setAsignaturaTitulacion(List<Asignatura> asignaturaTitulacion) {
		this.asignaturaTitulacion = asignaturaTitulacion;
	}

	public List<Expediente> getExpedienteTitulacion() {
		return expedienteTitulacion;
	}

	public void setExpedienteTitulacion(List<Expediente> expedienteTitulacion) {
		this.expedienteTitulacion = expedienteTitulacion;
	}

	public List<Centro> getCentroTitulacion() {
		return centroTitulacion;
	}

	public void setCentroTitulacion(List<Centro> centroTitulacion) {
		this.centroTitulacion = centroTitulacion;
	}

	public List<Grupo> getGrupoTitulacion() {
		return grupoTitulacion;
	}

	public void setGrupoTitulacion(List<Grupo> grupoTitulacion) {
		this.grupoTitulacion = grupoTitulacion;
	}
	
	
	//toString
	

	@Override
	public String toString() {
		return "Titulacion [codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos
				+ ", asignaturaTitulacion=" + asignaturaTitulacion + ", expedienteTitulacion=" + expedienteTitulacion
				+ ", centroTitulacion=" + centroTitulacion + ", grupoTitulacion=" + grupoTitulacion + "]";
	}
	
	
	//HashCode & Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}