DROP TABLE ALUMNO CASCADE CONSTRAINTS;
DROP TABLE ASIGNATURA CASCADE CONSTRAINTS;
DROP TABLE ASIGNATURASMATRICULA CASCADE CONSTRAINTS;
DROP TABLE CENTRO CASCADE CONSTRAINTS;
DROP TABLE CLASE CASCADE CONSTRAINTS; 
DROP TABLE ENCUESTA CASCADE CONSTRAINTS;
DROP TABLE EXPEDIENTE CASCADE CONSTRAINTS;
DROP TABLE GRUPO CASCADE CONSTRAINTS;
DROP TABLE GRUPOSASIGNATURA CASCADE CONSTRAINTS;
DROP TABLE GRUPOSASIGNATURA_ENCUESTA CASCADE CONSTRAINTS; 
DROP TABLE MATRICULA CASCADE CONSTRAINTS;
DROP TABLE OPTATIVA CASCADE CONSTRAINTS;
DROP TABLE TITULACION CASCADE CONSTRAINTS;
DROP TABLE TITULACION_CENTRO CASCADE CONSTRAINTS;

CREATE TABLE alumno (
    id                   INTEGER NOT NULL,
    dni                  VARCHAR2(255) NOT NULL,
    nombre_completo      VARCHAR2(255),
    apellido_1           VARCHAR2(255),
    apellido_2           VARCHAR2(255),
    email_institucional  VARCHAR2(255),
    email_personal       VARCHAR2(255),
    num_archivo          VARCHAR2(255),
    numero_movil         INTEGER,
    numero_telefono      INTEGER,
    direccion            VARCHAR2(255),
    localidad            VARCHAR2(255),
    provicia             VARCHAR2(255),
    cp                   INTEGER
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id )USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE alumno ADD CONSTRAINT alumno_dni_un UNIQUE ( dni );

CREATE TABLE asignatura (
    referencia          INTEGER NOT NULL,
    codigo              INTEGER NOT NULL,
    curso               INTEGER,
    creditos_teoria     INTEGER NOT NULL,
    creditos_practicas  INTEGER NOT NULL,
    duracion            VARCHAR2(255) NOT NULL,
    nombre              VARCHAR2(255) NOT NULL,
    ofertada            VARCHAR2(10) NOT NULL,
    tipo                VARCHAR2(255),
    titulacion_codigo   INTEGER NOT NULL,
    plazas              VARCHAR2(255),
    otro_idioma         VARCHAR2(255)
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( referencia,
                                                                  titulacion_codigo )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE asignaturasmatricula (
    asignatura_referencia                   INTEGER NOT NULL,
    grupo_id                                INTEGER,
    matricula_curso_academico               INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    matricula_expediente_numero_expediente  INTEGER NOT NULL,
    asignatura_titulacion_codigo            INTEGER NOT NULL
);

ALTER TABLE asignaturasmatricula
    ADD CONSTRAINT asignaturasmatricula_pk PRIMARY KEY ( asignatura_referencia,
                                                         asignatura_titulacion_codigo,
                                                         matricula_curso_academico,
                                                         matricula_expediente_numero_expediente )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE centro (
    id                    INTEGER NOT NULL,
    direccion             VARCHAR2(255) NOT NULL,
    nombre                VARCHAR2(255) NOT NULL,
    telefono_conserjeria  INTEGER
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id )USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE centro ADD CONSTRAINT centro_nombre_un UNIQUE ( nombre );

CREATE TABLE clase (
    hora_fin                      DATE,
    dia                           DATE NOT NULL,
    hora_inicio                   DATE NOT NULL,
    asignatura_referencia         INTEGER NOT NULL,
    grupo_id                      INTEGER NOT NULL,
    asignatura_titulacion_codigo  INTEGER NOT NULL
);

ALTER TABLE clase
    ADD CONSTRAINT clase_pk PRIMARY KEY ( dia,
                                          hora_inicio,
                                          grupo_id );

CREATE TABLE encuesta (
    fecha_envio                   DATE NOT NULL,
    expediente_numero_expediente  INTEGER NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( fecha_envio,
                                                              expediente_numero_expediente )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE expediente (
    numero_expediente       INTEGER NOT NULL,
    activo                  CHAR(1) DEFAULT '0',
    creditos_cf             INTEGER,
    creditos_fb             INTEGER,
    creditos_mo             INTEGER,
    creditos_op             INTEGER,
    creditos_pe             INTEGER,
    creditos_superados      INTEGER,
    creditos_tf             INTEGER,
    nota_media_provisional  INTEGER,
    alumno_id               INTEGER NOT NULL,
    titulacion_codigo       INTEGER NOT NULL
);

ALTER TABLE expediente ADD CONSTRAINT expediente_pk PRIMARY KEY ( numero_expediente )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE grupo (
    id                  INTEGER NOT NULL,
    asignar             VARCHAR2(255),
    curso               INTEGER NOT NULL,
    ingles              CHAR(1) DEFAULT '0' NOT NULL,
    letra               CHAR(1) NOT NULL,
    plazas              VARCHAR2(255) NOT NULL,
    turno_tarde_manana  VARCHAR2(255) NOT NULL,
    visible             CHAR(1) DEFAULT '0',
    grupo_id            INTEGER,
    titulacion_codigo   INTEGER NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id )USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE grupo ADD CONSTRAINT grupo_curso_un UNIQUE ( curso );

ALTER TABLE grupo ADD CONSTRAINT grupo_letra_un UNIQUE ( letra );

CREATE TABLE gruposasignatura (
    curso_academico               INTEGER NOT NULL,
    oferta                        CHAR(1),
    asignatura_referencia         INTEGER NOT NULL,
    grupo_id                      INTEGER NOT NULL,
    asignatura_titulacion_codigo  INTEGER NOT NULL
);

ALTER TABLE gruposasignatura
    ADD CONSTRAINT gruposasignatura_pk PRIMARY KEY ( curso_academico,
                                                     asignatura_referencia,
                                                     asignatura_titulacion_codigo,
                                                     grupo_id )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE gruposasignatura_encuesta (
    encuesta_fecha_envio                           DATE NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    encuesta_expediente_numero_expediente          INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    gruposasignatura_curso_academico               INTEGER NOT NULL,
    gruposasignatura_grupo_id                      INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    gruposasignatura_asignatura_referencia         INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    gruposasignatura_asignatura_titulacion_codigo  INTEGER NOT NULL
);

ALTER TABLE gruposasignatura_encuesta
    ADD CONSTRAINT gruposasignatura_encuesta_pk PRIMARY KEY ( encuesta_fecha_envio,
                                                              encuesta_expediente_numero_expediente,
                                                              gruposasignatura_curso_academico,
                                                              gruposasignatura_grupo_id,
                                                              gruposasignatura_asignatura_referencia,
                                                              gruposasignatura_asignatura_titulacion_codigo )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE matricula (
    curso_academico               INTEGER NOT NULL,
    estado                        VARCHAR2(255) NOT NULL,
    fecha_matricula               VARCHAR2(255) NOT NULL,
    nuevo_ingreso                 CHAR(1) DEFAULT '0',
    numero_archivo                INTEGER,
    turno_preferente              VARCHAR2(255),
    expediente_numero_expediente  INTEGER NOT NULL
);

ALTER TABLE matricula ADD CONSTRAINT matricula_pk PRIMARY KEY ( curso_academico,
                                                                expediente_numero_expediente )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE optativa (
    asignatura_referencia         INTEGER NOT NULL,
    plazas                        VARCHAR2(255) NOT NULL,
    mencion                       VARCHAR2(255),
    asignatura_titulacion_codigo  INTEGER NOT NULL
);

ALTER TABLE optativa ADD CONSTRAINT optativa_pk PRIMARY KEY ( asignatura_referencia,
                                                              asignatura_titulacion_codigo )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE titulacion (
    codigo    INTEGER NOT NULL,
    creditos  INTEGER NOT NULL,
    nombre    VARCHAR2(255) NOT NULL
);

ALTER TABLE titulacion ADD CONSTRAINT titulacion_pk PRIMARY KEY ( codigo )USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE titulacion_centro (
    centro_id          INTEGER NOT NULL,
    titulacion_codigo  INTEGER NOT NULL
);

ALTER TABLE titulacion_centro ADD CONSTRAINT titulacion_centro_pk PRIMARY KEY ( centro_id,
                                                                                titulacion_codigo )USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_titulacion_fk FOREIGN KEY ( titulacion_codigo )
        REFERENCES titulacion ( codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturasmatricula
    ADD CONSTRAINT asignaturasmatricula_asignatura_fk FOREIGN KEY ( asignatura_referencia,
                                                                    asignatura_titulacion_codigo )
        REFERENCES asignatura ( referencia,
                                titulacion_codigo );

ALTER TABLE asignaturasmatricula
    ADD CONSTRAINT asignaturasmatricula_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturasmatricula
    ADD CONSTRAINT asignaturasmatricula_matricula_fk FOREIGN KEY ( matricula_curso_academico,
                                                                   matricula_expediente_numero_expediente )
        REFERENCES matricula ( curso_academico,
                               expediente_numero_expediente );

ALTER TABLE clase
    ADD CONSTRAINT clase_asignatura_fk FOREIGN KEY ( asignatura_referencia,
                                                     asignatura_titulacion_codigo )
        REFERENCES asignatura ( referencia,
                                titulacion_codigo );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_expediente_fk FOREIGN KEY ( expediente_numero_expediente )
        REFERENCES expediente ( numero_expediente );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_titulacion_fk FOREIGN KEY ( titulacion_codigo )
        REFERENCES titulacion ( codigo );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titulacion_fk FOREIGN KEY ( titulacion_codigo )
        REFERENCES titulacion ( codigo );

ALTER TABLE gruposasignatura
    ADD CONSTRAINT gruposasignatura_asignatura_fk FOREIGN KEY ( asignatura_referencia,
                                                                asignatura_titulacion_codigo )
        REFERENCES asignatura ( referencia,
                                titulacion_codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE gruposasignatura_encuesta
    ADD CONSTRAINT gruposasignatura_encuesta_encuesta_fk FOREIGN KEY ( encuesta_fecha_envio,
                                                                       encuesta_expediente_numero_expediente )
        REFERENCES encuesta ( fecha_envio,
                              expediente_numero_expediente );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE gruposasignatura_encuesta
    ADD CONSTRAINT gruposasignatura_encuesta_gruposasignatura_fk FOREIGN KEY ( gruposasignatura_curso_academico,
                                                                               gruposasignatura_asignatura_referencia,
                                                                               gruposasignatura_asignatura_titulacion_codigo,
                                                                               gruposasignatura_grupo_id )
        REFERENCES gruposasignatura ( curso_academico,
                                      asignatura_referencia,
                                      asignatura_titulacion_codigo,
                                      grupo_id );

ALTER TABLE gruposasignatura
    ADD CONSTRAINT gruposasignatura_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE matricula
    ADD CONSTRAINT matricula_expediente_fk FOREIGN KEY ( expediente_numero_expediente )
        REFERENCES expediente ( numero_expediente );

ALTER TABLE optativa
    ADD CONSTRAINT optativa_asignatura_fk FOREIGN KEY ( asignatura_referencia,
                                                        asignatura_titulacion_codigo )
        REFERENCES asignatura ( referencia,
                                titulacion_codigo );

ALTER TABLE titulacion_centro
    ADD CONSTRAINT titulacion_centro_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE titulacion_centro
    ADD CONSTRAINT titulacion_centro_titulacion_fk FOREIGN KEY ( titulacion_codigo )
        REFERENCES titulacion ( codigo );






