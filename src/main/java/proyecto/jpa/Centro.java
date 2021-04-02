package proyecto.jpa;


import java.util.List;

import javax.persistence.*;

@Entity
public class Centro {

	
	@Id
	@Column(name="ID")
	private Integer id;
	@Column(name="NOMBRE", unique = true)
	private String nombre;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="TELEFONO_CONSERJERIA")
	private Long telefonoConserjeria;
	
	
	@ManyToMany(mappedBy = "centroTitulacion")
	private List<Titulacion> titulacionCentro;	
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getTelefonoConserjeria() {
		return telefonoConserjeria;
	}

	public void setTelefono_conserjeria(Long telefonoConserjeria) {
		this.telefonoConserjeria = telefonoConserjeria;
	}

}
