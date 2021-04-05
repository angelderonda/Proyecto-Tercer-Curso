package proyecto.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
		//PK de asignatura
		//@Column(name="REFERENCIA", nullable = false)
		@SuppressWarnings("unused")
		private Long referencia;
		
		//PK de matricula
		//@Column(name = "CURSO_ACADEMICO", nullable = false)
		@SuppressWarnings("unused")
		private Integer cursoAcademico;
		//@Column(name = "NUMERO_EXPEDIENTE", nullable = false)
		@SuppressWarnings("unused")
		private Long numeroExpediente;
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="REFERENCIA", nullable = false)
	private Long referencia;
	@Id
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer cursoAcademico;
	@Id
	@Column(name = "NUMERO_EXPEDIENTE", nullable = false)
	private Long numeroExpediente;
		
	
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
