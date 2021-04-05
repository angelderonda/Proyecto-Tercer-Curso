package proyecto.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
* @author Los Datografos 
* Clase: Clase
* Esta clase indica el tramo horario y dia donde se imparte una asignatura concreto. Varias asignaturas de distintos grupos usan tramo horario simultáneo.
*/

@Entity
public class Clase implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@Column(name = "ID", nullable = false)
	private ClaseId id;
	@Column(name = "HORA_FIN")
	@Temporal(TemporalType.TIME)
	private Date horaFin; 
	
	
	//Relacion muchos a uno con Asignatura
	@ManyToOne(optional = false)
	private Asignatura asignaturaClase;
	
	//Relacion muchos a uno con Grupo
	@ManyToOne(optional = false)
	private Grupo grupoClase;
	
	//Getters and Setters
	
	public ClaseId getId() {
		return id;
	}
	
	public void setId(ClaseId id) {
		this.id = id;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
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
		
	//toString
	
	@Override
	public String toString() {
		return "Clase [id=" + id + ", horaFin=" + horaFin + ", asignaturaClase=" + asignaturaClase + ", grupoClase="
				+ grupoClase + "]";
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
        Clase other = (Clase) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
	
	
}
