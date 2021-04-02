package proyecto.jpa;

import javax.persistence.*;

/**
* @author Los Datografos 
* Clase: AsignaturasMatriculaID
* Esta clase se usa para poder crear la clave primaria compuesta de AsignaturasMatricula
*/


public class AsignaturasMatriculaId {
	
	@Column(name="REFERENCIA", nullable = false)
	private Long referencia;
	@Column(name = "CURSO_ACADEMICO", nullable = false)
	private Integer cursoAcademico;
	@Column(name = "NUMERO_EXPEDIENTE", nullable = false)
	private Long numeroExpediente;
}
