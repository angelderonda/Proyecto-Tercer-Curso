package es.uma.informatica.sii.ejb.practica.ejb;



import javax.ejb.Local;

import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoNoExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ObjetoYaExistenteException;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.ProyectoException;
import es.uma.informatica.sii.ejb.practica.entidades.Expediente;

@Local
public interface GestionExpediente {
	public void createExpediente(Expediente expediente) throws ObjetoYaExistenteException;
	public Expediente readExpediente(Integer idExpediente) throws ObjetoNoExistenteException;
	public void updateExpediente(Expediente expediente) throws ObjetoNoExistenteException;
	public void deleteExpediente(Integer idExpediente) throws ObjetoNoExistenteException;
}
