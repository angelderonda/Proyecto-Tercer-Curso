package proyecto.jpa;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: AsignaturasMatricula
* Esta clase se utiliza para relacionar las asignaturas elegidas en una matrícula y con el/los grupo/s en el/los que se van a impartir las mismas.
*/

@Entity
@IdClass(AsignaturasMatriculaId.class)
public class AsignaturasMatricula {
	
	
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
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="REFERENCIA", referencedColumnName="REFERENCIA")
	private Asignatura asignaturaAsignaturasMatricula;
	
	//Relacion muchos a uno con matricula
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="CURSO_ACADEMICO", referencedColumnName="CURSO_ACADEMICO")
	private Matricula matriculaAsignaturasMatricula;
	
	//Relacion muchos a uno con grupo
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="NUMERO_EXPEDIENTE", referencedColumnName="NUMERO_EXPEDIENTE")
	private Grupo grupoAsignaturasMatricula;
	
}
