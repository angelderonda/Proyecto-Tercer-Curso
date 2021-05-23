/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import correo.*;


import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;


@Named(value = "controladorCorreo")
@SessionScoped
public class ControladorCorreo implements Serializable {

    private String toMail;
    

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }
   
    public void send() {
        try {
            EnvioMensaje m=new EnvioMensaje();
            m.sendMail(toMail);
        } catch (Exception e) {
        }
    }
}
