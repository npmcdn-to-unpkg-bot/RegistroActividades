--------------------------------------------------------
-- Archivo creado  - sábado-mayo-14-2016   
--------------------------------------------------------
REM INSERTING into ACTIVIDADES.TB_TIPO_IDENTIFICACION
SET DEFINE OFF;
Insert into ACTIVIDADES.TB_TIPO_IDENTIFICACION (NB_ID,VR_DESCRIPCION) values ('1','Cedula de ciudadania');
Insert into ACTIVIDADES.TB_TIPO_IDENTIFICACION (NB_ID,VR_DESCRIPCION) values ('2','Tarjeta identidad');
REM INSERTING into ACTIVIDADES.TB_TIPO_ACTIVIDAD
SET DEFINE OFF;
Insert into ACTIVIDADES.TB_TIPO_ACTIVIDAD (NB_ID,VR_NOMBRE,VR_DESCRIPCION) values ('1','Clase','Clases de catedra');
Insert into ACTIVIDADES.TB_TIPO_ACTIVIDAD (NB_ID,VR_NOMBRE,VR_DESCRIPCION) values ('2','Tutorias','Tutorias presenciales y virtuales');
Insert into ACTIVIDADES.TB_TIPO_ACTIVIDAD (NB_ID,VR_NOMBRE,VR_DESCRIPCION) values ('3','Investigación','Participación en grupo de investigación');
REM INSERTING into ACTIVIDADES.TB_PERSONA
SET DEFINE OFF;
Insert into ACTIVIDADES.TB_PERSONA (NB_ID,NB_IDTIPOIDENTIFICACION,VR_IDENTIFICACION,VR_NOMBRES,VR_APELLIDOS,VR_TELEFONO,VR_EMAIL) values ('1','1','98695639','Arbey de Jesus','Villegas Carvajal','2356645','arbeyvillegas@gmail.com');
REM INSERTING into ACTIVIDADES.TB_DOCENTE
SET DEFINE OFF;
Insert into ACTIVIDADES.TB_DOCENTE (NB_ID,NB_IDPERSONA) values ('1','1');
REM INSERTING into ACTIVIDADES.TB_SEMESTRE
SET DEFINE OFF;
Insert into ACTIVIDADES.TB_SEMESTRE (NB_ID,NB_ANIO,NB_PERIODO) values ('1','2016','1');
Insert into ACTIVIDADES.TB_SEMESTRE (NB_ID,NB_ANIO,NB_PERIODO) values ('2','2016','2');
