

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "login")
@RequestScoped
public class Login {
	
	private String nombre,contrasenia;
	
	private static final Logger LOGGER = Logger.getLogger(Login.class.getCanonicalName());

	
	private UIComponent mybutton;

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

    public String entrar() {
    	LOGGER.info("Angelete guapo \n");
        if(nombre.equals("admin") && contrasenia.equals("admin")) {
        	return "inicio.xhtml";
        }
        else  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or password is incorrect"));
        
        return null;
    }
}