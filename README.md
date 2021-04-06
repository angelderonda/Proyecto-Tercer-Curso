# Proyecto_Secretaria

## Aclaración sobre la nomenclatura de las variables que mapean relaciones en JPA

Sea una relación entre la clase 'A' y la clase 'B':
* El atributo representante de dicha relación dentro de la clase A tendrá como nombre: aB 
* El atributo representante de dicha relación dentro de la clase B tendrá como nombre: bA 

## Aclaración sobre diagramas E/R 

* El primer diagrama E/R creado con DataModeler: *Diagrama ER DM*, presenta la siguiente diferencia con respecto al generado a partir de JPA: *Diagrama ER JPA*. En este caso la tabla optativa, subentidad de Asignatura no la hemos generado como una tabla, sino que hemos utilizado la estrategia **single-table**, con una columna llamada DISCRIMINANTE_OPTATIVA de tipo CHAR que tomará el valor 'A' si la fila se trata de una asignatura y el valor 'O' si se trata de una asignatura optativa. Esto se debe a que en nuestro sistema predominan las asignaturas normales sobre las optativas y consideramos que es mas eficiente no generar mas tablas para ello.

* La obligatoriedad se indica mediante la aplicación en las relaciones ManyToMany, no se puede modelar usando JPA.

* Hemos probado usando la herramienta DataModeler a introducir nuestras sentencias DML y el resultado del modelo parece verse alterado. Para ver completamente mejor el diagrama se puede usar la herramienta JPA Content (click derecho 'open diagram') dentro de nuestro proyecto JPA.
