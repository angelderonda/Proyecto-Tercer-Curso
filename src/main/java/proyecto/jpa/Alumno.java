package proyecto.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Alumno
* Esta clase identifica cada alumno (persona física) e incluye la información personal externa a la docencia.
*/

@Entity
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", nullable = false)
	private Integer id;
	@Column(name="DNI", unique = true, nullable = false)
	private String dni;
	@Column(name="NOMBRE_COMPLETO")
	private String nombreCompleto;
	@Column(name="EMAIL_INSTITUCIONAL")
	private String emailInstitucional;
	@Column(name="EMAIL_PERSONAL")
	private String emailPersonal;
	@Column(name="NUMERO_TELEFONO")
	private Long numeroTelefono;
	@Column(name="NUMERO_MOVIL")
	private Long numeroMovil;
	
	
	@OneToMany(mappedBy = "alumnoExpediente")
	private List<Expediente> expedienteAlumno;
	
	//Getter y setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmailInstitucional() {
		return emailInstitucional;
	}

	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public Long getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Long numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Long getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(Long numeroMovil) {
		this.numeroMovil = numeroMovil;
	}
	
	//toString

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", emailInstitucional="
				+ emailInstitucional + ", emailPersonal=" + emailPersonal + ", numeroTelefono=" + numeroTelefono
				+ ", numeroMovil=" + numeroMovil + ", expedienteAlumno=" + expedienteAlumno + "]";
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
        Alumno other = (Alumno) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
	
	
	
	
	
	
	
	
	

}
