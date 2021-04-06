package proyecto.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Asignatura
* Esta clase identifica todas las asignaturas ofertadas en el centro (materia que se imparte en las clases) con sus atributos como créditos o duración.
*/

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINANTE_OPTATIVA", discriminatorType = DiscriminatorType.CHAR )
@DiscriminatorValue("A")
public class Asignatura implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="REFERENCIA", nullable = false)
	private Long referencia;
	@Column(name="CODIGO", nullable = false)
	private Integer codigo;
	@Column(name="CREDITOS", nullable = false)
	private Integer creditos;
	@Column(name="OFERTADA", nullable = false)
	private Boolean ofertada;
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	@Column(name="CURSO")
	private Integer curso;
	@Column(name="TIPO")
	private String tipo; //Mat basica, optativa,tfg...
	@Column(name="DURACION")
	private String duracion;
	
	//Relacion muchos a uno con titulacion
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
	
	public Long getReferencia() {
		return referencia;
	}



	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public Integer getCreditos() {
		return creditos;
	}



	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}



	public Boolean getOfertada() {
		return ofertada;
	}



	public void setOfertada(Boolean ofertada) {
		this.ofertada = ofertada;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getCurso() {
		return curso;
	}



	public void setCurso(Integer curso) {
		this.curso = curso;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getDuracion() {
		return duracion;
	}



	public void setDuracion(String duracion) {
		this.duracion = duracion;
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
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos=" + creditos + ", ofertada="
				+ ofertada + ", nombre=" + nombre + ", curso=" + curso + ", tipo=" + tipo + ", duracion=" + duracion
				+ ", titulacionAsignatura=" + titulacionAsignatura + ", claseAsignatura=" + claseAsignatura
				+ ", gruposAsignaturaAsignatura=" + gruposAsignaturaAsignatura + ", asignaturasMatriculaAsignatura="
				+ asignaturasMatriculaAsignatura + "]";
	}	
	

	//HashCode and Equals
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
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
        return true;
    }
	
	
}
