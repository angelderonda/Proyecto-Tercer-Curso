package proyecto.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
* @author Los Datografos 
* Clase: Expediente
* La forma de identificar al alumno dentro de la universidad. Un alumno tiene un expediente asociado a él (por cada titulación en la que esté).
*/


@Entity
public class Expediente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NUMERO_EXPEDIENTE", nullable = false)
	private Long numeroExpediente;
	private Boolean activo;
	@Column(name = "NOTA_MEDIA_PROVISIONAL")
	private Long notaMediaProvisional;
	@Column(name = "CREDITOS_SUPERADOS")
	private Integer creditosSuperados;
	@Column(name = "CREDITOS_FB")
	private Integer creditosFB;
	@Column(name = "CREDITOS_MO")
	private Integer creditosMO;
	@Column(name = "CREDITOS_OP")
	private Integer creditosOP;
	@Column(name = "CREDITOS_CF")
	private Integer creditosCF;
	@Column(name = "CREDITOS_PE")
	private Integer creditosPE;
	@Column(name = "CREDITOS_TF")
	private Integer creditosTF;

	// Relacion muchos a uno con titulacion
	@ManyToOne(optional = false)
	private Titulacion titulacionExpediente;

	// Relacion muchos a uno con Alumnos
	@ManyToOne(optional = false)
	private Alumno alumnoExpediente;

	//Relacion uno a muchos con Encuesta
	@OneToMany(mappedBy = "expedienteEncuesta")
	private List<Encuesta> encuestaExpediente;
	
	// Relacion uno a muchos con Matricula
	@OneToMany(mappedBy = "expedienteMatricula")
	private List<Matricula> matriculaExpediente;

	//Getters y Setters
	
	public Long getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(Long numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Long getNotaMediaProvisional() {
		return notaMediaProvisional;
	}

	public void setNotaMediaProvisional(Long notaMediaProvisional) {
		this.notaMediaProvisional = notaMediaProvisional;
	}

	public Integer getCreditosSuperados() {
		return creditosSuperados;
	}

	public void setCreditosSuperados(Integer creditosSuperados) {
		this.creditosSuperados = creditosSuperados;
	}

	public Integer getCreditosFB() {
		return creditosFB;
	}

	public void setCreditosFB(Integer creditosFB) {
		this.creditosFB = creditosFB;
	}

	public Integer getCreditosMO() {
		return creditosMO;
	}

	public void setCreditosMO(Integer creditosMO) {
		this.creditosMO = creditosMO;
	}

	public Integer getCreditosOP() {
		return creditosOP;
	}

	public void setCreditosOP(Integer creditosOP) {
		this.creditosOP = creditosOP;
	}

	public Integer getCreditosCF() {
		return creditosCF;
	}

	public void setCreditosCF(Integer creditosCF) {
		this.creditosCF = creditosCF;
	}

	public Integer getCreditosPE() {
		return creditosPE;
	}

	public void setCreditosPE(Integer creditosPE) {
		this.creditosPE = creditosPE;
	}

	public Integer getCreditosTF() {
		return creditosTF;
	}

	public void setCreditosTF(Integer creditosTF) {
		this.creditosTF = creditosTF;
	}

	public Titulacion getTitulacionExpediente() {
		return titulacionExpediente;
	}

	public void setTitulacionExpediente(Titulacion titulacionExpediente) {
		this.titulacionExpediente = titulacionExpediente;
	}

	public Alumno getAlumnoExpediente() {
		return alumnoExpediente;
	}

	public void setAlumnoExpediente(Alumno alumnoExpediente) {
		this.alumnoExpediente = alumnoExpediente;
	}

	public List<Encuesta> getEncuestaExpediente() {
		return encuestaExpediente;
	}

	public void setEncuestaExpediente(List<Encuesta> encuestaExpediente) {
		this.encuestaExpediente = encuestaExpediente;
	}

	public List<Matricula> getMatriculaExpediente() {
		return matriculaExpediente;
	}

	public void setMatriculaExpediente(List<Matricula> matriculaExpediente) {
		this.matriculaExpediente = matriculaExpediente;
	}
	

	//toString
	
	@Override
	public String toString() {
		return "Expediente [numeroExpediente=" + numeroExpediente + ", activo=" + activo + ", notaMediaProvisional="
				+ notaMediaProvisional + ", creditosSuperados=" + creditosSuperados + ", creditosFB=" + creditosFB
				+ ", creditosMO=" + creditosMO + ", creditosOP=" + creditosOP + ", creditosCF=" + creditosCF
				+ ", creditosPE=" + creditosPE + ", creditosTF=" + creditosTF + ", titulacionExp=" + titulacionExpediente
				+ "]";
	}
	
	//HashCode and Equals
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroExpediente == null) ? 0 : numeroExpediente.hashCode());
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
		Expediente other = (Expediente) obj;
		if (numeroExpediente == null) {
			if (other.numeroExpediente != null)
				return false;
		} else if (!numeroExpediente.equals(other.numeroExpediente))
			return false;
		return true;
	}
		

}

