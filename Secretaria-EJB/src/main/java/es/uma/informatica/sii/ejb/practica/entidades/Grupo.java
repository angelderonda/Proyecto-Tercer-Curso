package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author Los Datografos Clase: Grupo Recoge a un número de alumnos para cada
 *         asignatura y existen varios por cada titulación. Además tiene un
 *         horario completo asociado.
 */

@Entity
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	@Column(name = "ASIGNAR")
	private String asignar;
	@Column(name = "CURSO", nullable = false, unique = true)
	private Integer curso;
	@Column(name = "INGLES", columnDefinition = "char(1) default '0' not null")
	private char ingles;
	@Column(name = "LETRA", unique = true, columnDefinition = "char(1) not null")
	private char letra;
	@Column(name = "PLAZAS", nullable = false)
	private String plazas;
	@Column(name = "TURNO_TARDE_MAÑANA", nullable = false)
	private String turno_mañana_tarde;
	@Column(name = "VISIBLE", columnDefinition = "char(1) default '0'")
	private char visible;

	// Relacion reflexiva
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "grupoReflexiva")
	private Grupo grupoReflexiva;
	@OneToMany(mappedBy = "grupoReflexiva", cascade = CascadeType.REMOVE)
	private List<Grupo> grupoGrupo;

	// Relacion muchos a uno con titulacion
	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	private Titulacion titulacionGrupo;

	// Relacion uno a muchos con clase
	@OneToMany(mappedBy = "grupoClase", cascade = CascadeType.REMOVE)
	private List<Clase> clasesGrupo;

	// Relacion uno a muchos con Asignaturas_Matricula
	@OneToMany(mappedBy = "grupoAsignaturasMatricula", cascade = CascadeType.REMOVE)
	private List<AsignaturasMatricula> asignaturasMatriculaGrupo;

	// Relacion uno a muchos con gruposAsignatura
	@OneToMany(mappedBy = "grupoGruposAsignatura", cascade = CascadeType.REMOVE)
	private List<GruposAsignatura> gruposAsignaturaGrupo;

	// Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAsignar() {
		return asignar;
	}

	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public char getIngles() {
		return ingles;
	}

	public void setIngles(char ingles) {
		this.ingles = ingles;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getPlazas() {
		return plazas;
	}

	public void setPlazas(String plazas) {
		this.plazas = plazas;
	}

	public String getTurno_mañana_tarde() {
		return turno_mañana_tarde;
	}

	public void setTurno_mañana_tarde(String turno_mañana_tarde) {
		this.turno_mañana_tarde = turno_mañana_tarde;
	}

	public char getVisible() {
		return visible;
	}

	public void setVisible(char visible) {
		this.visible = visible;
	}

	public Grupo getGrupoReflexiva() {
		return grupoReflexiva;
	}

	public void setGrupoReflexiva(Grupo grupoReflexiva) {
		this.grupoReflexiva = grupoReflexiva;
	}

	public List<Grupo> getGrupoGrupo() {
		return grupoGrupo;
	}

	public void setGrupoGrupo(List<Grupo> grupoGrupo) {
		this.grupoGrupo = grupoGrupo;
	}

	public Titulacion getTitulacionGrupo() {
		return titulacionGrupo;
	}

	public void setTitulacionGrupo(Titulacion titulacionGrupo) {
		this.titulacionGrupo = titulacionGrupo;
	}

	public List<Clase> getClasesGrupo() {
		return clasesGrupo;
	}

	public void setClasesGrupo(List<Clase> clasesGrupo) {
		this.clasesGrupo = clasesGrupo;
	}

	public List<AsignaturasMatricula> getAsignaturasMatriculaGrupo() {
		return asignaturasMatriculaGrupo;
	}

	public void setAsignaturasMatriculaGrupo(List<AsignaturasMatricula> asignaturasMatriculaGrupo) {
		this.asignaturasMatriculaGrupo = asignaturasMatriculaGrupo;
	}

	public List<GruposAsignatura> getGruposAsignaturaGrupo() {
		return gruposAsignaturaGrupo;
	}

	public void setGruposAsignaturaGrupo(List<GruposAsignatura> gruposAsignaturaGrupo) {
		this.gruposAsignaturaGrupo = gruposAsignaturaGrupo;
	}

	// toString

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + "]";
	}

	// HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
