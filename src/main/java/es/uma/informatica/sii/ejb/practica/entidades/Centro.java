package es.uma.informatica.sii.ejb.practica.entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: Centro
* Esta clase hace referencia a los centros físicos donde se realiza la docencia dentro de la universidad/facultad.
*/

@Entity
public class Centro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", nullable = false)
	private Integer id;
	@Column(name="DIRECCION", nullable = false)
	private String direccion;
	@Column(name="NOMBRE",nullable = false, unique = true)
	private String nombre;
	@Column(name="TELEFONO_CONSERJERIA")
	private String telefonoConserjeria;
	
	
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

	public String getTelefonoConserjeria() {
		return telefonoConserjeria;
	}

	public void setTelefono_conserjeria(String telefonoConserjeria) {
		this.telefonoConserjeria = telefonoConserjeria;
	}

}
