package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Asignatura
* Esta clase identifica todas las asignaturas ofertadas en el centro (materia que se imparte en las clases) con sus atributos como créditos o duración.
*/

@Entity
@IdClass(Asignatura.AsignaturaId.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINANTE_OPTATIVA", discriminatorType = DiscriminatorType.CHAR )
@DiscriminatorValue("A")
public class Asignatura implements Serializable{

	
	public static class AsignaturaId implements Serializable{

		private static final long serialVersionUID = 1L;
		private Integer referencia;
		private Integer titulacionAsignatura;
		
		public AsignaturaId() {
			super();
		}
				
		public AsignaturaId(Integer referencia, Integer titulacionAsignatura) {
			this.referencia = referencia;
			this.titulacionAsignatura = titulacionAsignatura;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
			result = prime * result + ((titulacionAsignatura == null) ? 0 : titulacionAsignatura.hashCode());
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
			AsignaturaId other = (AsignaturaId) obj;
			if (referencia == null) {
				if (other.referencia != null)
					return false;
			} else if (!referencia.equals(other.referencia))
				return false;
			if (titulacionAsignatura == null) {
				if (other.titulacionAsignatura != null)
					return false;
			} else if (!titulacionAsignatura.equals(other.titulacionAsignatura))
				return false;
			return true;
		}
		
		
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="REFERENCIA", nullable = false)
	private Integer referencia;
	@Column(name="CODIGO", nullable = false)
	private Integer codigo;
	@Column(name="CURSO")
	private Integer curso;
	@Column(name="CREDITOS_TEORIA", nullable = false)
	private Integer creditosTeoria;
	@Column(name="CREDITOS_PRACTICAS", nullable = false)
	private Integer creditosPracticas;
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	@Column(name="DURACION", nullable = false)
	private String duracion;
	@Column(name="OFERTADA", nullable = false)
	private String ofertada;
	@Column(name="TIPO")
	private String tipo; //Mat basica, optativa,tfg...
	@Column(name="PLAZAS")
	private String plazas;
	@Column(name="OTROS_IDIOMAS")
	private String otros_idiomas;

	
	//Relacion muchos a uno con titulacion
	@Id
	@ManyToOne(optional = false)
	private Titulacion titulacionAsignatura;
	
	//Relacion uno a muchos con clase
	@OneToMany(mappedBy="asignaturaClase")
	private List<Clase> claseAsignatura;

	//Relacion uno a muchos con gruposAsignatura
	@OneToMany(mappedBy="asignaturaGruposAsignatura")
	private List<GruposAsignatura> gruposAsignaturaAsignatura;
		
	//Relacion uno a muchos con asignaturaMatricula
	@OneToMany(mappedBy="asignaturaAsignaturasMatricula")
	private List<AsignaturasMatricula> asignaturasMatriculaAsignatura;

	//Getters and Setters
	
	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getCreditosTeoria() {
		return creditosTeoria;
	}

	public void setCreditosTeoria(Integer creditosTeoria) {
		this.creditosTeoria = creditosTeoria;
	}

	public Integer getCreditosPracticas() {
		return creditosPracticas;
	}

	public void setCreditosPracticas(Integer creditosPracticas) {
		this.creditosPracticas = creditosPracticas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getOfertada() {
		return ofertada;
	}

	public void setOfertada(String ofertada) {
		this.ofertada = ofertada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlazas() {
		return plazas;
	}

	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}

	public String getOtros_idiomas() {
		return otros_idiomas;
	}

	public void setOtros_idiomas(String otros_idiomas) {
		this.otros_idiomas = otros_idiomas;
	}

	public Titulacion getTitulacionAsignatura() {
		return titulacionAsignatura;
	}

	public void setTitulacionAsignatura(Titulacion titulacionAsignatura) {
		this.titulacionAsignatura = titulacionAsignatura;
	}

	public List<Clase> getClaseAsignatura() {
		return claseAsignatura;
	}

	public void setClaseAsignatura(List<Clase> claseAsignatura) {
		this.claseAsignatura = claseAsignatura;
	}

	public List<GruposAsignatura> getGruposAsignaturaAsignatura() {
		return gruposAsignaturaAsignatura;
	}

	public void setGruposAsignaturaAsignatura(List<GruposAsignatura> gruposAsignaturaAsignatura) {
		this.gruposAsignaturaAsignatura = gruposAsignaturaAsignatura;
	}

	public List<AsignaturasMatricula> getAsignaturasMatriculaAsignatura() {
		return asignaturasMatriculaAsignatura;
	}

	public void setAsignaturasMatriculaAsignatura(List<AsignaturasMatricula> asignaturasMatriculaAsignatura) {
		this.asignaturasMatriculaAsignatura = asignaturasMatriculaAsignatura;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", curso=" + curso + ", creditosTeoria="
				+ creditosTeoria + ", creditosPracticas=" + creditosPracticas + ", nombre=" + nombre + ", duracion="
				+ duracion + ", ofertada=" + ofertada + ", tipo=" + tipo + ", plazas=" + plazas + ", otros_idiomas="
				+ otros_idiomas + ", titulacionAsignatura=" + titulacionAsignatura + ", claseAsignatura="
				+ claseAsignatura + ", gruposAsignaturaAsignatura=" + gruposAsignaturaAsignatura
				+ ", asignaturasMatriculaAsignatura=" + asignaturasMatriculaAsignatura + "]";
	}

	//HashCode and Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((titulacionAsignatura == null) ? 0 : titulacionAsignatura.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (titulacionAsignatura == null) {
			if (other.titulacionAsignatura != null)
				return false;
		} else if (!titulacionAsignatura.equals(other.titulacionAsignatura))
			return false;
		return true;
	}


	
	
	
}
