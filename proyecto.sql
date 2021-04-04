CREATE TABLE ALUMNO (ID INTEGER NOT NULL, DNI VARCHAR(255) NOT NULL UNIQUE, EMAIL_INSTITUCIONAL VARCHAR(255), EMAIL_PERSONAL VARCHAR(255), NOMBRE_COMPLETO VARCHAR(255), NUMERO_MOVIL BIGINT, NUMERO_TELEFONO BIGINT, PRIMARY KEY (ID))
CREATE TABLE ASIGNATURA (REFERENCIA BIGINT NOT NULL, disc VARCHAR(31), CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, CURSO INTEGER, DURACION VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, OFERTADA TINYINT(1) default 0 NOT NULL, TIPO VARCHAR(255), TITULACIONASIGNATURA_CÓDIGO BIGINT, MENCION VARCHAR(255), PLAZAS INTEGER NOT NULL, PRIMARY KEY (REFERENCIA))
CREATE TABLE ASIGNATURASMATRICULA (CURSO_ACADEMICO BIGINT NOT NULL, NUMERO_EXPEDIENTE BIGINT NOT NULL, REFERENCIA BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, NUMERO_EXPEDIENTE, REFERENCIA))
CREATE TABLE CENTRO (ID INTEGER NOT NULL, DIRECCION VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL UNIQUE, TELEFONO_CONSERJERIA BIGINT, PRIMARY KEY (ID))
CREATE TABLE CLASE (HORA_FIN TIME, DIA DATE NOT NULL, HORA_INICIO TIME NOT NULL, ASIGNATURACLASE_REFERENCIA BIGINT, GRUPOCLASE_ID INTEGER, PRIMARY KEY (DIA, HORA_INICIO))
CREATE TABLE ENCUESTA (FECHA_ENVIO BIGINT NOT NULL, PRIMARY KEY (FECHA_ENVIO))
CREATE TABLE EXPEDIENTE (NUMERO_EXPEDIENTE BIGINT NOT NULL, ACTIVO TINYINT(1) default 0, CREDITOS_CF INTEGER, CREDITOS_FB INTEGER, CREDITOS_MO INTEGER, CREDITOS_OP INTEGER, CREDITOS_PE INTEGER, CREDITOS_SUPERADOS INTEGER, CREDITOS_TF INTEGER, NOTA_MEDIA_PROVISIONAL BIGINT, ALUMNOEXPEDIENTE_ID INTEGER, TITULACIONEXPEDIENTE_CÓDIGO BIGINT, PRIMARY KEY (NUMERO_EXPEDIENTE))
CREATE TABLE GRUPO (ID INTEGER NOT NULL, ASIGNAR VARCHAR(255), CURSO INTEGER NOT NULL UNIQUE, INGLES TINYINT(1) default 0 NOT NULL, LETRA CHAR(1) NOT NULL UNIQUE, PLAZAS INTEGER, TURNO_TARDE_MAÑANA VARCHAR(255) NOT NULL, VISIBLE TINYINT(1) default 0, grupoReflexiva INTEGER, TITULACIONGRUPO_CÓDIGO BIGINT, PRIMARY KEY (ID))
CREATE TABLE GRUPOSASIGNATURA (CURSO_ACADEMICO BIGINT NOT NULL, OFERTA CHAR(1), PRIMARY KEY (CURSO_ACADEMICO))
CREATE TABLE MATRICULA (CURSO_ACADEMICO BIGINT NOT NULL, ESTADO VARCHAR(255) NOT NULL, FECHA_MATRICULA VARCHAR(255) NOT NULL, NUEVO_INGRESO TINYINT(1) default 0, NUMERO_ARCHIVO INTEGER, TURNO_PREFERENTE VARCHAR(255), PRIMARY KEY (CURSO_ACADEMICO))
CREATE TABLE TITULACION (CÓDIGO BIGINT NOT NULL, CREDITOS INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (CÓDIGO))
CREATE TABLE TITULACION_CENTRO (centroTitulacion_ID INTEGER NOT NULL, titulacionCentro_CÓDIGO BIGINT NOT NULL, PRIMARY KEY (centroTitulacion_ID, titulacionCentro_CÓDIGO))
CREATE TABLE GRUPOSASIGNATURA_ENCUESTA (encuestaGruposAsignatura_FECHA_ENVIO DATE NOT NULL, gruposAsignaturaEncuesta_CURSO_ACADEMICO INTEGER NOT NULL, PRIMARY KEY (encuestaGruposAsignatura_FECHA_ENVIO, gruposAsignaturaEncuesta_CURSO_ACADEMICO))
ALTER TABLE ASIGNATURA ADD CONSTRAINT FK_ASIGNATURA_TITULACIONASIGNATURA_CÓDIGO FOREIGN KEY (TITULACIONASIGNATURA_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE ASIGNATURASMATRICULA ADD CONSTRAINT FK_ASIGNATURASMATRICULA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO) REFERENCES MATRICULA (CURSO_ACADEMICO)
ALTER TABLE ASIGNATURASMATRICULA ADD CONSTRAINT FK_ASIGNATURASMATRICULA_NUMERO_EXPEDIENTE FOREIGN KEY (NUMERO_EXPEDIENTE) REFERENCES GRUPO (NUMERO_EXPEDIENTE)
ALTER TABLE ASIGNATURASMATRICULA ADD CONSTRAINT FK_ASIGNATURASMATRICULA_REFERENCIA FOREIGN KEY (REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GRUPOCLASE_ID FOREIGN KEY (GRUPOCLASE_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_ASIGNATURACLASE_REFERENCIA FOREIGN KEY (ASIGNATURACLASE_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_FECHA_ENVIO FOREIGN KEY (FECHA_ENVIO) REFERENCES EXPEDIENTE (NUMERO_EXPEDIENTE)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_ALUMNOEXPEDIENTE_ID FOREIGN KEY (ALUMNOEXPEDIENTE_ID) REFERENCES ALUMNO (ID)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_TITULACIONEXPEDIENTE_CÓDIGO FOREIGN KEY (TITULACIONEXPEDIENTE_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_grupoReflexiva FOREIGN KEY (grupoReflexiva) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TITULACIONGRUPO_CÓDIGO FOREIGN KEY (TITULACIONGRUPO_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE GRUPOSASIGNATURA ADD CONSTRAINT FK_GRUPOSASIGNATURA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO) REFERENCES EXPEDIENTE (NUMERO_EXPEDIENTE)
ALTER TABLE TITULACION_CENTRO ADD CONSTRAINT FK_TITULACION_CENTRO_titulacionCentro_CÓDIGO FOREIGN KEY (titulacionCentro_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE TITULACION_CENTRO ADD CONSTRAINT FK_TITULACION_CENTRO_centroTitulacion_ID FOREIGN KEY (centroTitulacion_ID) REFERENCES CENTRO (ID)
ALTER TABLE GRUPOSASIGNATURA_ENCUESTA ADD CONSTRAINT GRPSSGNATURAENCUESTAncstGruposAsignaturaFECHAENVIO FOREIGN KEY (encuestaGruposAsignatura_FECHA_ENVIO) REFERENCES ENCUESTA (FECHA_ENVIO)
ALTER TABLE GRUPOSASIGNATURA_ENCUESTA ADD CONSTRAINT GRPSSGNTRAENCUESTAgrpssgntraEncuestaCURSOACADEMICO FOREIGN KEY (gruposAsignaturaEncuesta_CURSO_ACADEMICO) REFERENCES GRUPOSASIGNATURA (CURSO_ACADEMICO)