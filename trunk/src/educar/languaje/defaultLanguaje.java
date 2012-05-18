package educar.languaje;

public interface defaultLanguaje {

    public static final String ERROR = "Error";
    public static final String CLOSE_WINDOW = "Cerrar";

    public static final String WELCOME = "Welcome to Educar";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
    public static final String LOGIN = "Login";

    public static final String MANAGE_TEACHER = "Gestionar Docente";
    public static final String MANAGE_STUDENT = "Gestionar Estudiante";
    public static final String MANAGE_CHARGE = "Gestionar Cargo";
    public static final String MANAGE_FACULTY = "Gestionar Facultad";
    public static final String MANAGE_SUBJECT = "Gestionar Materia";

    public static final String ADD_TEACHER = "Agregar Docente";
    public static final String MODIFY_TEACHER = "Modificar Docente";
    public static final String DELETE_TEACHER = "Borrar Docente";

    public static final String ADD_STUDENT = "Agregar Alumno";
    public static final String MODIFY_STUDENT = "Modificar Alumno";
    public static final String DELETE_STUDENT = "Borrar Alumno";
    public static final String ADD_CHARGE = "Agregar Cargo";
    public static final String MODIFY_CHARGE = "Modificar Cargo";
    public static final String DELETE_CHARGE = "Borrar Cargo";

    public static final String ADD_FACULTY = "Agregar Facultad";
    public static final String MODIFY_FACULTY = "Modificar Facultad";
    public static final String DELETE_FACULTY = "Borrar Facultad";

    // subject = materia
    public static final String ADD_SUBJECT = "Agregar Materia";
    public static final String MODIFY_SUBJECT = "Modificar Materia";
    public static final String DELETE_SUBJECT = "Borrar Materia";

    public static final String ADD = "Guardar";
    public static final String CLEAR = "Limpiar";
    public static final String SEARCH = "Buscar";

    public static final String DELETE = "Borrar";
    public static final String MODIFY = "Modificar";
    public static final String REMOVE = "Remover";
    public static final String ASIGNAR = "Asignar";
    public static final String SUBIR = "SUBIR";

    public static final String ALUMNOSPANEL = "ALUMNOS";
    public static final String DOCENTESPANEL = "DOCENTES";
    public static final String MATERIAPANEL = "MATERIA";
    public static final String FACULTADPANEL = "FACULTAD";
    public static final String CARGOSPANEL = "CARGOS";
    public static final String DEDICACIONDOCENTEPANEL = "DEDICACION \r\n DOCENTE";
    public static final String ASIGNACIONDOCENTEPANEL = "ASIGNACION DOCENTE";
    public static final String UPLOAD = "SUBIR";
    public static final String ACTIVIDADOCENTEPANEL = "ACTIVIDAD";
    public static final String CORREGIRDOCENTEPANEL = "CORREGIR";
    public static final String CARGARSOLUCIONALUMNOPANEL = "CARGAR SOLUCI\u00D3N";
    public static final String INSCRIBIRMALUMNOPANEL = "INCRIPCI\u00D3N MATERIA";

    // MODELOS
    public static final String ACTUALIZACIONFALLIDA = "NO se puede actualizar";
    public static final String ACTUALIZACIONEXITOSO = "actualizacion realizada";
    public static final String CARGADOEXITOSO = "Cargado Exitoso";
    public static final String BORRADOEXITOSO = "Borrardo Exitoso";
    public static final String FALTANCOMPLETARCAMPOS = "falta completar campos";
    public static final String S1 = "El docente : ";
    public static final String S2 = " No dicta esta materia ";
    public static final String S3 = "Asignacion cargada";
    public static final String S4 = " Ya esta Asignado a esta materia ";
    public static final String S5 = "dni_docente = null";
    public static final String S6 = "el borrado del docente encargado fue exitoso";
    public static final String S7 = "el borrado del docente encargado No se puedo realizar ";
    public static final String S8 = "no hay docente que borrar";
    public static final String S9 = "la materia ya tiene docente encargado, borrelo primero y luego podra asignarle uno nuevo";
    public static final String S10 = "dni: ";
    public static final String S11 = " | "; // NO SE CAMBIA
    public static final String S12 = "nombre : ";
    public static final String S13 = " apellido: ";
    public static final String S14 = "Atencion la materia tiene docente encargado";
    public static final String S15 = "No se puede borrar el Cargo ,este esta ligado con un Docente";
    public static final String S16 = "el cargo no existe";
    public static final String S17 = "Cargo agregado correctamente";
    public static final String S18 = "verifique los datos ingresados sean validos";
    public static final String S19 = "El Cargo no Existe";
    public static final String S20 = "el docente ya posee cargo";
    public static final String S21 = "el cargo ya esta ocupado";
    public static final String S22 = "El dni del alumno no existe ";
    public static final String S23 = "borrado del alumno exitoso";
    public static final String S24 = "el alumno no se puede borrar, ya que esta cursando materias";
    public static final String S25 = "alumno agregado correctamente. Se creo el Usuario para el alumno ";
    public static final String S26 = "verifique los datos ingresados sean validos";
    public static final String S27 = "ingreso mal el campo Dni o Tele (NUMEROS) o Fecha (aaaa-mm-dd)";
    public static final String S28 = "el alumno no existe";
    public static final String S29 = "El dni del doncente no existe ";
    public static final String S30 = "borrado del docente exitoso";
    public static final String S31 = "No se puede borrar el docente verifique que no tenga materia a cargos o tareas";
    public static final String S32 = "docente agregado correctamente. Se creo el Usuario para docente";
    public static final String S33 = "verifique los datos ingresados sean validos";
    public static final String S34 = "el docente no existe";
    public static final String S35 = "no se pudo guardar la materia";
    public static final String S36 = "borrado de la materia exitosa";
    public static final String S37 = "No se puede borrar la materia, Ya que posee un Docente a cargo. elimine este cargo";
    public static final String S38 = "La materia a borrar no existe";
    public static final String S39 = "materia no encontrada";
    public static final String S40 = "no se encontro la facultad";
    public static final String S41 = "no se pudo borrar la facultad";
    public static final String S42 = "El codigo de facultad no existe";
    public static final String S43 = "Borrado de la facultad exitoso";
    public static final String S44 = "Facultad Agregada";
    public static final String S45 = "Datos No validos";
    public static final String S46 = "Datos incompletos";
    public static final String S47 = "La facultad no existe";
    public static final String S48 = "Nro Actividad: ";
    public static final String S49 = "materia: ";
    public static final String S50 = "Incripto correctamente Correctamente";
    public static final String S51 = "verifique los  datos ingresados sean validos";
    public static final String S52 = "Usted ya esta incripto en Dicha Materia";
    public static final String S53 = "yyyy-MM-dd";
    public static final String S54 = "H:mm:ss";
    public static final String S55 = "Resolucion subida Correctamente";
    public static final String S56 = "Usted ya subio una resolucion de esta Actividad el dia : ";
    public static final String S57 = "por favor selecciones una actividad";
    public static final String S58 = "Faltar Completar Campo Resolucion";
    public static final String S59 = "NO HA SELECCIONADO UNA ACTIVIDAD";
    public static final String S60 = "";
    public static final String S61 = "nro materia: ";
    public static final String S62 = "materia: ";
    public static final String S63 = "facultad: ";
    public static final String S64 = "act_nro: ";
    public static final String S65 = "No hay actividad que borrar, seleccion una";
    public static final String S66 = "se agrego la actividad";
    public static final String S67 = "la actividad no tiene resoluciones cargadas";
    public static final String S68 = "El alumno todavia no cargo la solucion";
    public static final String S69 = "Se a cargado la nota";
    public static final String S70 = "Res_nro: ";
    public static final String S71 = "alumno: ";
    public static final String S72 = "hrEnvio: ";
    public static final String S73 = "fecha: ";
    public static final String S74 = "Atencion el alumno ya posee una correccion";
    public static final String S75 = "Administrador Agregado";
    public static final String S76 = "No se pudo agregar administrador, verifique que el nombre de usuario no exista";
    public static final String S77 = "Ingrese los campos faltantes";
    public static final String S78 = "Administrador Borrado con exito";
    public static final String S79 = "NO se pudo borrar el administrador ";
    public static final String S80 = "El nombre de usuario  no existe  o  campos vacios";

    // VIEW ALUMNO
    public static final String S81 = "Solucion Actividad";
    public static final String S82 = "Descripicion Actividad";
    public static final String S83 = "Nota ";
    public static final String S84 = "SELECCI\u00D3NE LA ACTIVIDAD Y INGRESE LA SOLUCI\u00D3N A SUBIR ";
    public static final String S85 = "LISTA DE ACTIVIDADES";
    public static final String S86 = "Codigo Materia";
    public static final String S87 = "SELECCI\u00D3NE LA MATERIA A INCRIBIRSE ";
    public static final String S88 = "LISTA DE MATERIA";
    public static final String S89 = "LISTA DE MATERIA";
    public static final String S90 = "( A INCRIBIRME )";
    public static final String S100 = "(  INCRIPTO  )";

    // VIEW DOCENTE
    public static final String S101 = "SUBIR ACTIVIDAD";
    public static final String S102 = "LISTA DE MATERIA";
    public static final String S103 = "DESCRIPCION ACTIVIDAD";
    public static final String S104 = "CODIGO MATERIA";
    public static final String S105 = "SELECCIONE LA MATERIA E INGRESE LA ACTIVIDAD A CARGAR";
    public static final String S106 = "BORRAR ACTIVIDAD";
    public static final String S107 = "LISTA DE ACTIVIDADES";
    public static final String S108 = "DESCRIPCION ACTIVIDAD";
    public static final String S109 = "CODIGO MATERIA";
    public static final String S110 = "SELECCIONE LA ACTIVIDAD A ELIMINAR ";
    public static final String S111 = "D.N.I";
    public static final String S112 = "NOMBRE";
    public static final String S113 = "RESOLUCION";
    public static final String S114 = "NOTA";
    public static final String S115 = "SELECCIONE LA RESOLUCION E INGRESE LA NOTA A CARGAR";
    public static final String S116 = "MIS ACTIVIDADES";
    public static final String S117 = "LISTA DE RESOLUCIONES";
    public static final String S118 = "ACTIVIDAD";

    // VIEW ADMINISTRADOR
    public static final String S119 = "ADMINISTRADOR  ";
    public static final String S120 = "                           ALTA DOCENTE                            ";
    public static final String S121 = "Inserte los Datos del Docente a dar de Alta";
    public static final String S122 = "LISTA DE DOCENTES";
    public static final String S123 = " D.N.I ";
    public static final String S124 = "NOMBRE";
    public static final String S125 = "APELLIDO";
    public static final String S126 = "DIRECCI\u00D3N";
    public static final String S127 = "FECHA NACIMIENTO";
    public static final String S128 = "TELEFONO";
    public static final String S129 = "                         MODIFICACION DOCENTE                            ";
    public static final String S130 = "Buscar Docente a Modificar";
    public static final String S131 = "                      MODIFICAR FACULTAD                         ";
    public static final String S132 = "Inserte el Codigo de la Facultad ";
    public static final String S133 = "LISTA DE FACULTADES";
    public static final String S134 = "CODIGO";
    public static final String S135 = "NOMBRE FACULTAD";
    public static final String S136 = "                          ALTA FACULTAD                            ";
    public static final String S137 = "Inserte el Nombre de la Facultad  a Guardar";
    public static final String S138 = "LISTA DE FACULTADES";
    public static final String S139 = "NOMBRE FACULTAD";
    public static final String S140 = "                           MODIFICAR ALUMNO                         ";
    public static final String S141 = "Buscar Alumno a Modificar";
    public static final String S142 = "LISTA DE ALUMNOS";
    public static final String S143 = " DNI alumno";
    public static final String S144 = "                            ALTA ALUMNO                           ";
    public static final String S145 = "Inserte los Datos del Alumno a dar de Alta";
    public static final String S146 = "LISTA DE ALUMNOS";
    public static final String S147 = "                          MODIFICAR CARGO                          ";
    public static final String S148 = "Inserte el Codigo del Cargo";
    public static final String S149 = "LISTA DE CARGOS";
    public static final String S150 = "NOMBRE CARGO";
    public static final String S151 = "                        ALTA CARGO                        ";
    public static final String S152 = "Inserte el Nombre del Cargo  a Guardar";
    public static final String S153 = "                             MODIFICAR MATERIA                          ";
    public static final String S154 = "Inserte el Codigo de la Materia ";
    public static final String S155 = "Inserte el Codigo de la Materia ";
    public static final String S156 = "NOMBRE MATERIA";
    public static final String S157 = "CODIGO FACULTAD";
    public static final String S158 = "                      ALTA MATERIA                         ";
    public static final String S159 = "Inserte el Nombre de la Materia  a Guardar";
    public static final String S160 = "LISTA DE MATERIAS";
    public static final String S161 = "MODIFICAR DEDICACION DOCENTE";
    public static final String S162 = "Seleccione los Datos del Docente para Modificar su Dedicacion";
    public static final String S163 = "FACULTAD";
    public static final String S164 = "CARGO";
    public static final String S165 = "DEDICACION(horas)";
    public static final String S166 = "Lista de Docente con su Dedicacion";
    public static final String S167 = "ALTA DEDICACION DOCENTE";
    public static final String S168 = "Seleccione los Datos del Docente a dar de Alta su Dedicacion";
    public static final String S169 = "DEDICACION";
    public static final String S170 = "DNI";
    public static final String S171 = "(en horas)";
    public static final String S172 = "ENCARGADO  MATERIA";
    public static final String S173 = "Seleccione la Materia y DocenteEncargado";
    public static final String S174 = "MATERIA";
    public static final String S175 = "DOCENTE";
    public static final String S176 = "(a cargo)";
    public static final String S177 = "DESIGNACION MATERIA";
    public static final String S178 = "Seleccione la Materia y Docente para asignarlo a una Materia  ";
    public static final String S179 = "(a designar)";
    public static final String S180 = "Docentes Ligados  a Materias";

}
