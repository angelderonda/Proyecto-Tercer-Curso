package proyecto.jpa;

import java.util.Date;

import java.util.List;

import javax.persistence.*;
/**
* @author Los Datografos 
* Clase: Encuesta
* Hace referencia a las encuestas de preferencia que los alumnos rellenan con sus asignaturas prioritarias y sus elecciones.
*/

@Entity
public class Encuesta {
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ENVIO", nullable = false)
	private Date fechaEnvio;
		
	@ManyToMany(mappedBy = "encuestaGruposAsignatura")
	private List<GruposAsignatura> gruposAsignaturaEncuesta;
	
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="FECHA_ENVIO", referencedColumnName="NUMERO_EXPEDIENTE")
	private Expediente expedienteEncuesta;
	
	
	//Getters and Setters
	
	
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Encuesta [fechaEnvio=" + fechaEnvio + ", grupoAsignaturaEncuesta=" + gruposAsignaturaEncuesta
				+ ", expedienteEncuesta=" + expedienteEncuesta + "]";
	}

	
	
	//HashCode and Equals
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaEnvio == null) ? 0 : fechaEnvio.hashCode());
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
        Encuesta other = (Encuesta) obj;

        if (fechaEnvio == null) {
            if (other.fechaEnvio != null)
                return false;
        } else if (!fechaEnvio.equals(other.fechaEnvio))
            return false;
        return true;
    }
	
	

}
