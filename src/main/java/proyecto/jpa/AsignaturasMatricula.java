package proyecto.jpa;

import java.io.Serializable;
import javax.persistence.*;

import proyecto.jpa.Matricula.MatriculaId;

/**
* @author Los Datografos 
* Clase: AsignaturasMatricula
* Esta clase se utiliza para relacionar las asignaturas elegidas en una matrícula y con el/los grupo/s en el/los que se van a impartir las mismas.
*/

@Entity
@IdClass(AsignaturasMatricula.AsignaturasMatriculaId.class)
public class AsignaturasMatricula implements Serializable{
	
	public static class AsignaturasMatriculaId implements Serializable{

		private static final long serialVersionUID = 1L;
				
		
		@SuppressWarnings("unused")
		private MatriculaId matriculaAsignaturasMatricula;
		
		@SuppressWarnings("unused")
		private Long asignaturaAsignaturasMatricula;
	}
	
	private static final long serialVersionUID = 1L;
		
	
	//Relacion muchos a uno con asignatura
	@Id
	@ManyToOne(optional = false)
	private Asignatura asignaturaAsignaturasMatricula;
	
	//Relacion muchos a uno con matricula
	@Id
	@ManyToOne(optional = false)
	private Matricula matriculaAsignaturasMatricula;
	
	//Relacion muchos a uno con grupo
	@ManyToOne(optional = false)
	private Grupo grupoAsignaturasMatricula;
	
}
