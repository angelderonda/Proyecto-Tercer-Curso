package proyecto.jpa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Grupo
* Recoge a un número de alumnos para cada asignatura y existen varios por cada titulación. Además tiene un horario completo asociado.
*/

@Entity
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	@Column(name = "CURSO",nullable = false,unique = true)
	private Integer curso;
	@Column(name = "LETRA",nullable = false, unique = true)
	private char letra;
	@Column(name = "TURNO_TARDE_MAÑANA", nullable = false)
	private String turno_mañana_tarde;
	@Column(name = "INGLES", nullable = false)
	private Boolean ingles;
	@Column(name = "VISIBLE")
	private Boolean visible;
	@Column(name = "ASIGNAR")
	private String asignar;
	@Column(name = "PLAZAS")
	private Integer plazas;
		
	//Relacion reflexiva
	@ManyToOne
	@JoinColumn(name = "grupoReflexiva")
	private Grupo grupoReflexiva;
	@OneToMany(mappedBy = "grupoReflexiva")
	private List<Grupo> grupoGrupo;	
	
	//Relacion muchos a uno con titulacion
	@ManyToOne(optional = false)
	private Titulacion titulacionGrupo;
	
	//Relacion uno a muchos con clase
	@OneToMany(mappedBy="grupoClase")
	private List<Clase> clasesGrupo;
	
	//Relacion uno a muchos con Asignaturas_Matricula
	@OneToMany(mappedBy="grupoAsignaturasMatricula")
	private List<AsignaturasMatricula> asignaturasMatriculaGrupo;
	
	//Relacion uno a muchos con gruposAsignatura
	@OneToMany(mappedBy="grupoGruposAsignatura")
	private List<GruposAsignatura> gruposAsignaturaGrupo;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public String getTurno_mañana_tarde() {
		return turno_mañana_tarde;
	}
	public void setTurno_mañana_tarde(String turno_mañana_tarde) {
		this.turno_mañana_tarde = turno_mañana_tarde;
	}
	public Boolean getIngles() {
		return ingles;
	}
	public void setIngles(Boolean ingles) {
		this.ingles = ingles;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public String getAsignar() {
		return asignar;
	}
	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}
	public Integer getPlazas() {
		return plazas;
	}
	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	
	//toString
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno_mañana_tarde="
				+ turno_mañana_tarde + ", ingles=" + ingles + ", visible=" + visible + ", asignar=" + asignar
				+ ", plazas=" + plazas + "]";
	}
	
	
	//HashCode and Equals
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
