package es.uma.informatica.sii.ejb.practica.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Alumno
* Esta clase identifica cada alumno (persona física) e incluye la información personal externa a la docencia.
*/

@Entity
@NamedQueries({
    @NamedQuery(name="TODOS", query="SELECT a FROM Alumno a"),
    @NamedQuery(name="NUEVOS_O_VETERANOS", query="SELECT a FROM Alumno a, Expediente e, Matricula m WHERE "
    		+ "e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente AND m.nuevoIngreso = 0 "),
    @NamedQuery(name="FECHA_DE_MATRICULACIÓN", query="SELECT a FROM Alumno a, Expediente e, Matricula m WHERE "
    		+ "e.alumnoExpediente.id = a.id AND m.expedienteMatricula.numeroExpediente = e.numeroExpediente ORDER BY m.fechaMatricula ASC"),//COMPROBAR QUE ASC ESTA OK
   // SELECT d FROM Employee e, Department d WHERE e.department = d
    @NamedQuery(name="NOTA_MEDIA", query= "SELECT a FROM Alumno a, Expediente e WHERE e.alumnoExpediente.id = a.id AND e.notaMediaProvisional > :nota"),
    @NamedQuery(name="CREDITOS_SUPERADOS", query="SELECT a FROM Alumno a, Expediente e WHERE e.alumnoExpediente.id = a.id ORDER BY e.creditosSuperados DESC"), 
    @NamedQuery(name="TITULACION", query="SELECT a FROM Alumno a, Expediente e, Titulacion t WHERE"
    		+ " e.alumnoExpediente.id = a.id AND e.titulacionExpediente = t AND t.codigo = :codigo"),
    //@NamedQuery(name="GRUPO", query="SELECT u FROM USERS u WHERE u.email = :email")
})
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", nullable = false)
	private Integer id;
	@Column(name="DNI", unique = true, nullable = false)
	private String dni;
	@Column(name="NOMBRE_COMPLETO")
	private String nombreCompleto;
	@Column(name="APELLIDO_1")
	private String apellido1;
	@Column(name="APELLIDO_2")
	private String apellido2;
	@Column(name="EMAIL_INSTITUCIONAL")
	private String emailInstitucional;
	@Column(name="EMAIL_PERSONAL")
	private String emailPersonal;
	@Column(name="NUMERO_ARCHIVO")
	private String numeroArchivo;
	@Column(name="NUMERO_MOVIL")
	private Integer numeroMovil;
	@Column(name="NUMERO_TELEFONO")
	private Integer numeroTelefono;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="LOCALIDAD")
	private String localidad;
	@Column(name="PROVINCIA")
	private String provincia;
	@Column(name="CP")
	private Integer cp;
	

	
	
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	public String getNumeroArchivo() {
		return numeroArchivo;
	}

	public void setNumeroArchivo(String numeroArchivo) {
		this.numeroArchivo = numeroArchivo;
	}

	public Integer getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(Integer numeroMovil) {
		this.numeroMovil = numeroMovil;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public List<Expediente> getExpedienteAlumno() {
		return expedienteAlumno;
	}

	public void setExpedienteAlumno(List<Expediente> expedienteAlumno) {
		this.expedienteAlumno = expedienteAlumno;
	}
	
	/**
	 * Obtiene el expediente activo del alumno aux
	 * @param aux
	 * @return
	 */
	public Expediente getExpedienteActivo() {
		Expediente res=null;
		for(Expediente e : expedienteAlumno) {
			if(e.getActivo() == '0') { //ENTENDEMOS QUE 0 ES ACTIVO
				res = e;
				break;
			}
		}
		return res;
	}
	
	//toString


	@Override
	public String toString() {
		return "Alumno [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", emailInstitucional=" + emailInstitucional + ", emailPersonal="
				+ emailPersonal + ", numeroArchivo=" + numeroArchivo + ", numeroMovil=" + numeroMovil
				+ ", numeroTelefono=" + numeroTelefono + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", cp=" + cp + ", expedienteAlumno=" + expedienteAlumno + "]";
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
