-- Generado por Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   en:        2021-04-08 16:45:15 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE alumno (
    id                   INTEGER NOT NULL,
    dni                  unknown 
--  ERROR: Datatype UNKNOWN is not allowed 
     NOT NULL,
    nombre_completo      VARCHAR2(40 CHAR),
    email_institucional  VARCHAR2(20 CHAR),
    email_personal       VARCHAR2(20 CHAR),
    numero_telefono      INTEGER,
    numero_móvil         INTEGER
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id );

ALTER TABLE alumno ADD CONSTRAINT alumno_dni_un UNIQUE ( dni );

CREATE TABLE asignatura (
    referencia         INTEGER NOT NULL,
    codigo             INTEGER NOT NULL,
    créditos           INTEGER NOT NULL,
    ofertada           CHAR(1) NOT NULL,
    nombre             VARCHAR2(20 CHAR) NOT NULL,
    curso              INTEGER,
    tipo               VARCHAR2(20 CHAR),
    duración           VARCHAR2(20 CHAR),
    titulación_código  INTEGER NOT NULL
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( referencia );

CREATE TABLE asignaturas_matricula (
    mátricula_curso_académico               INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    mátricula_expediente_número_expediente  INTEGER NOT NULL,
    asignatura_referencia                   INTEGER NOT NULL,
    grupo_id                                INTEGER
);

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matrícula_pk PRIMARY KEY ( mátricula_curso_académico,
                                                          mátricula_expediente_número_expediente,
                                                          asignatura_referencia );

CREATE TABLE centro (
    id                   INTEGER NOT NULL,
    nombre               VARCHAR2(20 CHAR) NOT NULL,
    direccion            VARCHAR2(20 CHAR) NOT NULL,
    telefonoconserjeria  INTEGER
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id );

ALTER TABLE centro ADD CONSTRAINT centro_nombre_un UNIQUE ( nombre );

CREATE TABLE clase (
    dia                    VARCHAR2(20 CHAR) NOT NULL,
    hora_inicio            DATE NOT NULL,
    hora_fin               DATE,
    asignatura_referencia  INTEGER NOT NULL,
    grupo_id               INTEGER NOT NULL
);

CREATE UNIQUE INDEX clase__idx ON
    clase (
        grupo_id
    ASC );

ALTER TABLE clase ADD CONSTRAINT clase_pk PRIMARY KEY ( dia,
                                                        hora_inicio );

CREATE TABLE encuesta (
    fecha_envio                   DATE NOT NULL,
    expediente_número_expediente  INTEGER NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( fecha_envio,
                                                              expediente_número_expediente );

CREATE TABLE expediente (
    numero_expediente       INTEGER NOT NULL,
    activo                  CHAR(1),
    nota_media_provisional  FLOAT(2),
    creditos_superados      INTEGER,
    creditos_fb             INTEGER,
    creditos_mo             INTEGER,
    creditos_op             INTEGER,
    creditos_cf             INTEGER,
    creditos_pe             INTEGER,
    creditos_tf             INTEGER,
    titulación_código       INTEGER NOT NULL,
    alumno_id               INTEGER NOT NULL
);

ALTER TABLE expediente ADD CONSTRAINT expediente_pk PRIMARY KEY ( numero_expediente );

CREATE TABLE grupo (
    id                  INTEGER NOT NULL,
    curso               INTEGER NOT NULL,
    letra               CHAR(1 CHAR) NOT NULL,
    turno_mañana_tarde  VARCHAR2(20 CHAR) NOT NULL,
    inglés              CHAR(1) NOT NULL,
    visible             CHAR(1),
    asignar             VARCHAR2(20 CHAR),
    plazas              INTEGER,
    grupo_id            INTEGER,
    titulación_código   INTEGER NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id );

ALTER TABLE grupo ADD CONSTRAINT grupo_curso_un UNIQUE ( curso );

ALTER TABLE grupo ADD CONSTRAINT grupo_letra_un UNIQUE ( letra );

CREATE TABLE grupos_asignatura (
    curso_academico        INTEGER NOT NULL,
    oferta                 CHAR(1),
    grupo_id               INTEGER NOT NULL,
    asignatura_referencia  INTEGER NOT NULL
);

CREATE UNIQUE INDEX grupos_asignatura__idx ON
    grupos_asignatura (
        grupo_id
    ASC );

ALTER TABLE grupos_asignatura
    ADD CONSTRAINT grupos_asignatura_pk PRIMARY KEY ( curso_academico,
                                                      grupo_id,
                                                      asignatura_referencia );

CREATE TABLE matricula (
    curso_academico               INTEGER NOT NULL,
    estado                        VARCHAR2(20 CHAR) NOT NULL,
    fecha_matricula               DATE NOT NULL,
    numero_archivo                INTEGER,
    turno_preferente              VARCHAR2(20 CHAR),
    nuevo_ingreso                 CHAR(1),
    listado_asignaturas           VARCHAR2(9999999 CHAR),
    expediente_número_expediente  INTEGER NOT NULL
);

COMMENT ON COLUMN matricula.listado_asignaturas IS
    'Tendremos que tener una relación a parte de este atributo.';

ALTER TABLE matricula ADD CONSTRAINT mátricula_pk PRIMARY KEY ( curso_academico,
                                                                expediente_número_expediente );

CREATE TABLE optativa (
    referencia  INTEGER NOT NULL,
    plazas      INTEGER NOT NULL,
    mención     VARCHAR2(20 CHAR)
);

ALTER TABLE optativa ADD CONSTRAINT optativa_pk PRIMARY KEY ( referencia );

CREATE TABLE relation_21 (
    encuesta_fecha_envío               DATE NOT NULL,
    encuesta_número_expediente         INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_asignatura_curso_académico  INTEGER NOT NULL,
    grupos_asignatura_id               INTEGER NOT NULL,
    grupos_asignatura_referencia       INTEGER NOT NULL
);

ALTER TABLE relation_21
    ADD CONSTRAINT relation_21_pk PRIMARY KEY ( encuesta_fecha_envío,
                                                encuesta_número_expediente,
                                                grupos_asignatura_curso_académico,
                                                grupos_asignatura_id,
                                                grupos_asignatura_referencia );

CREATE TABLE relation_titulación_centro (
    titulación_código  INTEGER NOT NULL,
    centro_id          INTEGER NOT NULL
);

ALTER TABLE relation_titulación_centro ADD CONSTRAINT relation_titulación_centro_pk PRIMARY KEY ( titulación_código,
                                                                                                  centro_id );

CREATE TABLE titulacion (
    codigo    INTEGER NOT NULL,
    nombre    VARCHAR2(20 CHAR) NOT NULL,
    créditos  INTEGER NOT NULL
);

ALTER TABLE titulacion ADD CONSTRAINT titulación_pk PRIMARY KEY ( codigo );

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulacion ( codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matrícula_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matrícula_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matrícula_mátricula_fk FOREIGN KEY ( mátricula_curso_académico,
                                                                    mátricula_expediente_número_expediente )
        REFERENCES matricula ( curso_academico,
                               expediente_número_expediente );

ALTER TABLE clase
    ADD CONSTRAINT clase_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_expediente_fk FOREIGN KEY ( expediente_número_expediente )
        REFERENCES expediente ( numero_expediente );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulacion ( codigo );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulacion ( codigo );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE grupos_asignatura
    ADD CONSTRAINT grupos_asignatura_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE grupos_asignatura
    ADD CONSTRAINT grupos_asignatura_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE matricula
    ADD CONSTRAINT mátricula_expediente_fk FOREIGN KEY ( expediente_número_expediente )
        REFERENCES expediente ( numero_expediente );

ALTER TABLE optativa
    ADD CONSTRAINT optativa_asignatura_fk FOREIGN KEY ( referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE relation_21
    ADD CONSTRAINT relation_21_encuesta_fk FOREIGN KEY ( encuesta_fecha_envío,
                                                         encuesta_número_expediente )
        REFERENCES encuesta ( fecha_envio,
                              expediente_número_expediente );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE relation_21
    ADD CONSTRAINT relation_21_grupos_asignatura_fk FOREIGN KEY ( grupos_asignatura_curso_académico,
                                                                  grupos_asignatura_id,
                                                                  grupos_asignatura_referencia )
        REFERENCES grupos_asignatura ( curso_academico,
                                       grupo_id,
                                       asignatura_referencia );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE relation_titulación_centro
    ADD CONSTRAINT relation_titulación_centro_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE relation_titulación_centro
    ADD CONSTRAINT relation_titulación_centro_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulacion ( codigo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             2
-- ALTER TABLE                             37
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   9
-- WARNINGS                                 0
