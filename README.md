# Proyecto_Secretaria

## Aclaración sobre la nomenclatura de las variables que mapean relaciones en JPA

Sea una relación entre la clase 'A' y la clase 'B':
* El atributo representante de dicha relación dentro de la clase A tendrá como nombre: aB 
* El atributo representante de dicha relación dentro de la clase B tendrá como nombre: bA 

## Aclaración sobre diagramas E/R 

* El primer diagrama E/R creado con DataModeler: *Diagrama ER DM*, presenta la siguiente diferencia con respecto al generado a partir de JPA: *Diagrama ER JPA*. En este caso la tabla optativa, subentidad de Asignatura no la hemos generado como una tabla, sino que hemos utilizado la estrategia **single-table**, con una columna llamada DISCRIMINANTE_OPTATIVA de tipo CHAR que tomará el valor 'A' si la fila se trata de una asignatura y el valor 'O' si se trata de una asignatura optativa. Esto se debe a que en nuestro sistema predominan las asignaturas normales sobre las optativas y consideramos que es mas eficiente no generar mas tablas para ello.

* La obligatoriedad se indica mediante la aplicación en las relaciones ManyToMany, no se puede modelar usando JPA.

* Hemos probado usando la herramienta DataModeler a introducir nuestras sentencias DML y el resultado del modelo parece verse alterado. Para ver completamente mejor el diagrama se puede usar la herramienta JPA Content (click derecho 'open diagram') dentro de nuestro proyecto JPA.


* El nombre de las relaciones en el digrama E/R siguen el esquema "de que entidad sale la relaciónHacia que entidad se dirige la relación" (ejemplo aclaratorio: si tenemos dos entidades clase y alumno relacionadas y la relacion va de Clase a Alumno se especificaría como **claseAlumno**) sin embargo, en el esquema generado por Eclipse automaticamente aparecen al contrario. Además cabe destacar que eclipse genera algunas tablas necesarias para la generacion de algunas relaciones por lo que, hay más tabla en este que en el que realizamos en la asignatura de administración de base de datos.

## Aclaración sobre scripts generados

* El archivo con nombre *generacion-DM.ddl* es el que genera el DataModeler y el que tiene el nombre *proyecto.sql* es el que genera Eclipse.


## Cambios en los requisitos respecto a la primera entrega:


* RF-11 -> Gestionar listado de alumnos: el listado según los grupos era opcional en un principio y hemos decidido finalmente no implementarlo. Hemos añadido mostrar un listado de todos los alumnos y un listado de los alumnos con una nota media provisional mayor a una dada.

* RF-12 -> Solicitar cambio de grupo: tal y como habíamos planteado este requisito no tuvimos en cuenta que era necesario modelar la entidad 'Documentacion' y que también sería necesario en un futuro crear una página web desde el lado del alumno para solicitar el cambio. Por cuestiones de tiempo y de como lo hemos querido implementar, pensamos que es mejor que la solicitud del cambio se gestione una vez que el alumno haya entregado la documentación presencialmente en secretaría. Por ello, no son necesarios ni este requisito ni la página web y bastaría con el RF-9 gestionar cambio de grupo.


* RF-13 -> Notificar colisión de horario: era un requisito opcional y,tras una reunión con el profesor, nos hemos dado cuenta de que áun no se nos han entregado los horarios disponibles aún para implementarlo. Intentaremos en el futuro dentro de las posibilidades y el tiempo disponible implementar este requisito, aunque no es seguro.


## Cambios entidades JPA respecto a la primera entrega:


* Cambios de la clase Alumno:

	-Incluidos los NamedQueries de la clase para buscar alumnos en la base de datos.
	-Hemos separado el atributo nombreCompleto en nombre, apellido1 y apellido2 de tipo string todos.
	-Hemos añadido el atributo numeroArchivo de tipo String.
	-Los atributos numeroMovil y numeroTelefono cambian de tipo Long a tipo String.
	-Añadidos los atributos direccion, localidad y provincia de tipo String.
	-Añadido el atributo cp de tipo Integer.
	-La relación expedienteAlumno incluye un "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados para los nuevos atributos.
	-toString actualizado.
	-Nuevo método getExpedienteActivo para obtener los expedientes con el atributo activo en '1'.


* Cambios de la clase Asignatura:

	-Creación de una IdClass AsignaturaId que recoge referencia y titulacionAsignatura. También incluye constructor con los atributos por parámetros y hashCode e equals.
	-Cambio del InheritanceType de SINGLE_TABLE a TABLE_PER_CLASS.
	-El atributo referencia (primary key) cambia de tipo Long a Integer.
	-Se ha eliminado el atributo creditos y se han añadido dos nuevos llamados creditosPracticas y creditosTeoria de tipo Integer.
	-El atributo duracion pasa a ser "nullable = false".
	-El atributo ofertada pasa de tipo Boolean a tipo String.
	-Dos nuevos atributos plazas y otro_idioma tipos String.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-La relación titulacion asignatura pasa a ser @Id de forma que esta clase pasa a ser una weak entity.
	-Getters y Setters actualizados para los nuevos atributos.
	-toString actualizado.
	-hashCode e equals actualizados.


* Cambios de la clase AsignaturasMatricula:

	-La subclase AsignaturasMatriculaId incluye ahora hashCode e equals.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters añadidos.
	-hashCode e equals añadidos.


* Cambios de la clase Centro:

	-El atributo telefonoConserjeria pasa de tipo Long a tipo String.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString añadido.
	-hashCode e equals añadidos.


* Cambios de la clase Clase:

	-Creación de una IdClass ClaseId que recoge hora, diaInicio y grupoClase. También incluye hashCode e equals.
	-Se ha eliminado el atributo ClaseId.
	-Se ha cambiado el atributo horaFin de "TemporalType.TIME" a "TemporalType.DATE".
	-Se ha añadido nuevo atributo horaInicio tipo Date, con "nullable = false", "TemporalType.DATE" e @Id.
	-Se ha añadido nuevo atributo dia tipo Date, con "nullable = false", "TemporalType.DATE" e @Id.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados para los nuevos atributos.
	-toString actualizado.
	-hashCode e equals actualizados.


* Cambios de la clase ClaseId:

	*ESTA CLASE HA SIDO ELIMINADA Y AÑADIDA COMO SUBCLASE DE LA CLASE: Clase.*


* Cambios de la clase Encuesta:

	-La subclase EncuestaId incluye ahora hashCode e equals y 2 nuevos constructores añadidos, 1 con parámetros y otro sin parámetros.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.
	-hashCode e equals actualizados.


* Cambios de la clase Expediente:

	-El atributo numeroExpediente pasa de tipo Long a tipo Integer.
	-El atributo activo pasa de tipo Boolean a tipo char e incluye columnDefinition = "char(1) default '1'".
	-El atributo notaMediaProvisional pasa de tipo Integer a Float.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.
	-hashCode e equals actualizados.
	-Hemos añadido un nuevo método getMatriculaActiva para obtener la matrícula activa del expediente.


* Cambios de la clase Grupo:

	-El atributo ingles pasa de tipo Boolean a tipo char e incluye columnDefinition = "char(1) default '0' not null".
	-El atributo letra incluye columnDefinition = "char(1) not null".
	-El atributo plazas pasa de tipo Integer a tipo String.
	-El atributo visible incluye columnDefinition = "char(1) default '0'".
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.


* Cambios de la clase GruposAsignatura:

	-La subclase GruposAsignaturaId incluye ahora hashCode e equals y 2 nuevos constructores añadidos, 1 con parámetros y otro sin parámetros. El atributo cursoAcademico pasa de 		 tipo Integer a String. El atributo asignaturaGruposAsignatura pasa de tipo Long a AsignaturaId.
	-El atributo cursoAcademico pasa de tipo Integer a tipo String.
	-El atributo oferta ahora incluye columnDefinition = "char(1)".
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.


* Cambios de la clase Matricula:

	-La subclase MatriculaId incluye ahora hashCode e equals y 2 nuevos constructores añadidos, 1 con parámetros y otro sin parámetros. El atributo cursoAcademico pasa de tipo 		 Integer a String. El atributo expedienteMatricula pasa de tipo Long a Integer.
	-El atributo cursoAcademico pasa de tipo Integer a tipo String.
	-El atributo estado ahora incluye columnDefinition = "VARCHAR2(100) DEFAULT 'Activa'".
	-El atributo fechaMatricula pasa de tipo String a tipo Date.
	-El atributo nuevoIngreso pasa de tipo Boolean a tipo Integer e incluye columnDefinition = "number(1) default 1".
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.
	-hashCode e equals actualizados.


* Cambios de la clase Optativa:

	-@DiscriminatorValue("O") quitado.
	-El atributo plazas pasa de tipo Integer a tipoString.
	-Getters y Setters actualizados.


* Cambios de la clase Titulacion:

	-El atributo codigo pasa de tipo Long a tipo Integer.
	-Todas las relaciones pasan a añadir "cascade=CascadeType.REMOVE".
	-Getters y Setters actualizados.
	-toString actualizado.


## Cambios en los requisitos respecto a la segunda entrega:

* RF1 -> CRUD Asignatura: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF2 -> CRUD Alumno: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF3 -> CRUD Grupo: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF4 -> CRUD GrupoPorAsignatura: La funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF5 -> CRUD Expediente: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF6 -> CRUD Matrícula: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF7 -> CRUD Titulación: la funcionalidad de importar los datos por csv o excel no ha sido implementada.

* RF8 -> CRUD Centro: este requisito que era opcional, finalmente no ha sido implementado.

* RF10 -> Asignar Grupo: permite una asignación de grupos manual y una asignación automática (asigna a cada alumno el grupo indicado en su encuesta).

* RF11 -> Gestionar listado de alumnos: no se ha implementado la funcionalidad para exportar el listado de alumnos.

* RF12 -> Solicitar cambio de grupo: se ha implementado mediante el envio de un correo con un link a una encuesta de preferencia.

## Cambios entidades JPA respecto a la segunda entrega:

* Matricula cambiado. Se han cambiado algunos nombres y algunos column definition.

* GruposAsignatura cambiado. Se han cambiado algunos nombres.
* Expediente cambiado. Se han cambiado algunos nombres.

* Encuesta cambiado. Se han cambiado algunos nombres.

* Se han revisado los CascadeType.REMOVE. Estos se han eliminado de las clase débiles en las relaciones ManyToOne para que no eliminen las entidades padre.

## Cambios entidades EJB respecto a la segunda entrega:

* AlumnoEJB cambiado. rellenarEncuesta y asignarGrupo modificado. Tambien hemos añadido getAlumnoSinGrupo que devuelve los alumnos sin Grupos Asignados.

* AsignaturaEJB cambiado. Hemos cambiado el método createAsignatura y el updateAsignatura.

* BaseDatoEJB añadido. Esta clase inicia la base de datos con varias entidades al iniciar la aplicación.

* GestionBD añadido como interfaz de BaseDatoEJB.

* Todas las interfaces de los EJB cambiados han sido actualizadas.

* GruposAsignaturaEJB cambiado. Hemos cambiado el método createGruposAsignatura.

* MatriculaEJB cambiado. Hemos cambiado los métodos createMatricula y updateMatricula.Además hemos añadido un método getAsignaturas para recoger las asignaturas de una Matricula y conGrupos que devuelve true si la asignaturaMatricula tienen GrupoAsignaturas y false en otro caso.

* TipoFiltro cambiado. Los filtros CREDITOS SUPERADOS Y GRUPO han sido eliminados. El filtro, ALUMNOS_POR_ASIGNAR se ha añadido.


## Los tests EJB han sido adaptados de acuerdo con los cambios en las entidades EJB

* Cambios menores puesto que esencialmente los tests son exactamente los mismos aunque ahora ya respetan los cambios en las entidades EJB hechos respecto a la segunda entrega

##  BACKING BEANS añadidos

* 'nombre de entidad'CU. Backing bean que se encarga de crear y eliminar las entidades con el mismo nombre.

* 'nombre de entidad'RD. Backing bean que se encarga de leer y eliminar las entidades con el mismo nombre.

* Asignar. Backing bean que se encarga de la asignación de alumnos.

* AsignarManual. Backing bean que se encarga de la asignación manual de alumnos exclusivamente.

* ControladorCorreo. Backing bean que se encarga del envio de correos para rellenarEncuesta.

* Escoger2. Backing bean que se encarga de de la escogida de grupo de entre los grupos mostrados.

* Fila. Backing bean que se encarga de la gestión de las filas en escoger.

* GestionarCambio. Backing bean que se encarga de dar soporte a los cambios de grupo.

* Lista. Backing Bean que se encarga de mostrar alumnos.

* Login. Backing bean que se encarga de gestionar el login.

* RellenarEncuesta. Backing bean que se encarga de dar soporte para rellenar encuestas.

## JSF añadidos 

* 'createupdate*nombre de entidad'. Página de creación y modificación de entidades con el mismo nombre.

* 'readdelete*nombre de entidad'. Página de lectura y eliminación de entidades con el mismo nombre.

* asignarGrupo. Página para la asignación de grupo.

* asignarManual. Página para asignación de grupo manual.

* correo. Página para el envio de correo.

* escogerGrupo2. Página para la escogida de grupo para los alumnos.

* gestionarCambio. Página donde se gestionan los cambios de grupos.

* gestionarEntidades. Página donde se eligen las entidades a gestionar.

* inicio. Página principal de la aplicación de donde se parte al resto de páginas.

* listarAlumnos. Página donde se listan los alumnos.

* login. Página inicial donde realizamos el login para acceder a la aplicación.

* rellenarEncuesta. Página donde se rellenan las encuestas.

* Se han añadido css para algunas páginas. Los css tienen el mismo nombre que el xhtml al que hacen referencia.

## Test Selenium añadidos

* AsignarSuitIT. Test de asignación de alumnos.

* CRUD'nombre de entidad'SuiteIT. Test de creación, lectura, modificación y eliminación de la entidad con el mismo nombre.

* EncuestaSuitIT. Test de envio de correo y rellenado de Encuesta.

* GestionGrupoSuitIT. Test de cambio de grupos.

* ListarSuiteIT. Test de listar alumnos.

* LoginSuiteIT. Test del login.




