-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.61-0ubuntu0.11.04.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema educar_dev
--

CREATE DATABASE IF NOT EXISTS educar_dev;
USE educar_dev;

--
-- Definition of table `educar_dev`.`Actividad`
--

DROP TABLE IF EXISTS `educar_dev`.`Actividad`;
CREATE TABLE  `educar_dev`.`Actividad` (
  `cod_actividad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_act` text,
  `cod_materia` int(11) NOT NULL,
  PRIMARY KEY (`cod_actividad`),
  UNIQUE KEY `cod_actividad` (`cod_actividad`),
  KEY `codMateria` (`cod_materia`),
  CONSTRAINT `codMateria` FOREIGN KEY (`cod_materia`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Actividad`
--

/*!40000 ALTER TABLE `Actividad` DISABLE KEYS */;
LOCK TABLES `Actividad` WRITE;
INSERT INTO `educar_dev`.`Actividad` VALUES  (2,'Universidad Nacional de Río Cuarto\nFacultad de Ciencias Exactas, Fco-Qcas y Naturales\nDepartamento de Computación\nAsignatura: ANÁLISIS Y DISEÑO DE SISTEMAS – BASES DE DATOS\nAño 2012\n\nProyecto - Taller Integrador 2012\n\nDocentes:\nAnálisis y Diseño de Sistemas:\nResponsable: Paola Martelloto\nAuxiliares: Franco Brusatti y Marcelo Uva.\n\nBases de Datos:\nResponsable: Fabio Zorzan\nAuxiliares: Sandra Angeli, Ariel Arsaute y Mariana Frutos-\n\n\nObjetivos\nEl taller tiene como finalidad llevar a la práctica los contenidos estudiados durante la teoría y la\npráctica.\nLas Metodologías de Desarrollo de Software tienen como objetivo definir un conjunto de técnicas\ntradicionales y modernas de modelado de sistemas que permitan desarrollar un software de\ncalidad, incluyendo heurísticas de construcción y criterios de comparación de modelos de\nsistemas. Para tal esto se describen, fundamentalmente, herramientas de Análisis y Diseño\nOrientado a Objetos (UML), sus diagramas, especificación, y criterios de aplicación de las mismas.\nDentro de este taller se trabajará con una de las metodologías clasificadas dentro de las\nconocidas como “ágiles”. La metodología a utilizar será SCRUM.\nUno de los objetivos del proyecto es integrar conocimientos de las materias Análisis y Diseño de\nSistemas y Bases de Datos. Esta integración viene dada principalmente en el desarrollo de un\nsoftware con acceso a una Base de datos relacional a diseñar e implementar como parte del\nproyecto.\n\nEnunciado\nLa Universidad Nacional de Río Cuarto es un institución de educación superior que tiene como\nfinalidades esenciales la preparación de profesionales socialmente responsables a base de la\ninvestigación, conservación, promoción y difusión de la ciencia y de la cultura, haciendo énfasis\nen sus valores autóctonos con miras a lograr el mejor desarrollo y superación del hombre.\nEn la última década los procesos de enseñanza-aprendizaje han sufrido muchos cambios. La\nUniversidad se ha visto ante la necesidad de satisfacer las necesidades de formación,\nactualización y capacitación a personas que por causas diferentes no pueden asistir al sistema\ntradicional presencial, ofreciendo a los diferentes sectores de la sociedad, programas pertinentes\ny de calidad para apoyar así a los interesados en acrecentar su formación profesional, logrando\ncon esto llevar la educación a diferentes ámbitos del país y del extranjero.\nEs por todo lo anterior que la Universidad ha solicitado a un grupo de Analistas en Computación el\ndesarrollo de una plataforma de educación a distancia. En dicha plataforma se requiere almacenar\ny manipular información sobre alumnos, docentes, materias y actividades a realizar por los\nalumnos en las materias. De los alumnos y docentes se requieren sus datos personales. Cada\nmateria tiene un código, nombre y el equipo de docentes asignado, pero sólo uno de ellos es el\nresponsable. En cada materia se deberá definir actividades(código y descripción) destinadas a los\nalumnos. Por cada actividad planteada, los alumnos deberán resolverla y enviar una resolución.\nLas resoluciones enviadas por los alumnos, deberán tener un código único, fecha y hora del envío\nde la actividad. Posteriormente la resolución será evaluada por un docente quién calificará el\ntrabajo con una nota.\nCada alumno posee, además de los datos personales, un número de alumno. Es oportuno aclarar\nque cada docente, además de los datos personales, posee un cargo y dedicación. El cargo y\ndedicación del docente depende de la facultad a la que pertenece. Un docente puede pertenecer\na más de una facultad. Las facultades poseen un código y descripción. Los cargos que puede\ntener un docente por facultad tienen un código y descripción. La dedicación es la cantidad de\nhoras que posee un docente en un determinado cargo. Tener en cuenta que un docente puede\ntener dos cargos iguales, pero en facultades diferentes, estos cargos pueden tener dedicaciones\ndiferentes.\n\nMetodología de trabajado\nEl trabajo se realizará en grupos de 3-5 alumnos. Uno de los objetivos del taller es el trabajo\ngrupal, ya que ésta es una de las situaciones más comunes a la cual se enfrentarán dentro del\nmercado.\nLa asistencia a las clases del taller será obligatoria para todos los integrantes del grupo, una\ncondición más de regularización de la asignatura Análisis y Diseño de Sistemas.\nLa realización del taller estará organizado por actividades.\n\nActividades a realizar\nFecha 23/03\n1. Presentación del proyecto-taller y armado de grupos.\n2. Investigar en la bibliografía sugerida y elaborar un informe describiendo y\nexplicando la metodología de desarrollo SCRUM. Elaborar un cuadro comparativo\nentre las denominadas metodologías ágiles y las metodologías clásicas. Beneficios\ny desventajas de cada una de ellas.\n3. Presentación del repositorio SubVersion www.subversion.tigris.org\n4. Cada grupo deberá crear un repositorio en algún servidor de acceso público tal\ncomo GoogleCode http://code.google.com/intl/es-AR/ o Sourceforge\nwww.sourceforge.net\n\nFecha 30/03\n5. Cada grupo deberá presentar un informe escrito con lo solicitado en el punto 2 del\nencuentro anterior.\n6. Se realizará una puesta en común evaluando las características de la metodología en\ncuestión.\n7. Identicar los siguientes roles dentro del proyecto.\nProduct Owner\nScrumMaster (o Facilitador)\nEquipo de desarrollo\nStakeholders\nManagers\n8. Cada grupo analizará el enunciado planteado detectando todas las historias de usuario\no funcionalidades a realizar.\n\nFecha 13/04 al ---------\n9. Elaborar el documento con el product backlog.\n10. Elaborar el documento sprint backlog, determinar cantidad de sprints, como así\ntambién, elaborar la lista priorizada de cada Sprint.\n11. Cada grupo desarrollará un sprint completo, utilizando UML para la creación de\nmodelos. Todo el desarrollo del sprint/iteración deberá estar documentada\nminuciosamente.\n12. El cuerpo docente determinará el tiempo destinado para el sprint diseñado por los\nalumnos.\na) Elaborar, utilizando un diagrama de clases de UML, el dominio del sistema.\nb) Para cada historia de usuario, el grupo deberá utilizar una plantilla genérica\n(proporcionada por el cuerpo docente) para documentar el requerimiento.\nc) Para cada historia de usuario el grupo deberá utilizar diagramas de actividades\no de estados para modelar su comportamiento(junto con el cuerpo docente será\ndefinido el tipo de diagrama).\nd) Utilizando un diagrama de clases de UML definir el diseño de cada historia de\nusuario.\ne) $$$$ Definir el diseño de datos persistentes con un diagrama de clases de\nUML.\nf) Definir la base de datos relacional.\ng) Implementar cada historia de usuario junto con la base de datos. Se sugieren\npara la implementación las herramientas: JDK-Java, Eclipse y MySQL o\nPostgreSQL.\n\nFecha 20/03 (Bases de Datos)\nDiseño de la base de datos relacional\na) Diseñar el diagrama de Entidades y Relaciones.\nb) Realizar el pasaje del modelo E-R a Relacional (con claves foráneas).\nFecha 27/04 (Bases de Datos)\nImplementación de la estructura de la base de datos\na) Definir el diccionario de datos creando:\ni.\nLa base de datos.\nii.\nLas tablas componentes con todas las restricciones que el problema requiere (claves\nprimarias, claves foráneas indicando que hacer al borrar o actualizar, etc.). Implementar las\nrestricciones de tipos.\nb) Generar un script SQL para la carga de información en la base de datos (archivo de texto con el\ncódigo SQL para la inserción de datos).\nFecha 11/06\nConsultas y acceso a la base de datos via JDBC\na) Realizar un Programa Java que permita:\ni.\nInsertar materias.\nii.\nEliminar materias.\niii.\nListar todas las materias que dicta un docente(responsable).\nb) Resolver las siguientes consultas:\ni.\nDevolver un listado con el promedio de cada alumno de las actividades entregadas en\nuna materia determinada.\nii.\nDevolver los docentes que tienen mas de un cargo.\niii.\nDefinir consultas propias (no menos de dos), donde por lo menos una utilice\nsubconsultas.\n\nFecha ------- al ---------\na) Retrospectiva\nb) Demo. El grupo mostrará el resultado del sprint.\n\n',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Actividad` ENABLE KEYS */;


--
-- Definition of trigger `educar_dev`.`triggerBorrarActvidadAlumnos`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerBorrarActvidadAlumnos`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerBorrarActvidadAlumnos` BEFORE DELETE ON `Actividad` FOR EACH ROW BEGIN
   DELETE FROM educar_dev.TieneActividad  WHERE educar_dev.TieneActividad.codigo_a = OLD.cod_actividad ;  
END $$

DELIMITER ;

--
-- Definition of table `educar_dev`.`Alumnos`
--

DROP TABLE IF EXISTS `educar_dev`.`Alumnos`;
CREATE TABLE  `educar_dev`.`Alumnos` (
  `dni` int(11) NOT NULL,
  `apellido_a` varchar(30) NOT NULL,
  `nombre_a` varchar(30) NOT NULL,
  `fechaNac_a` date NOT NULL,
  `telefono_a` varchar(30) DEFAULT NULL,
  `direccion_a` varchar(50) DEFAULT NULL,
  `nro_alumno` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`dni`) USING BTREE,
  UNIQUE KEY `dni_a` (`dni`),
  UNIQUE KEY `nro_alumno` (`nro_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Alumnos`
--

/*!40000 ALTER TABLE `Alumnos` DISABLE KEYS */;
LOCK TABLES `Alumnos` WRITE;
INSERT INTO `educar_dev`.`Alumnos` VALUES  (32328847,'Coria','Saul Usbaldo','1986-05-20','3584016736','Calle 1 240',2),
 (33361090,'Depetris','Eduardo','1988-04-12','358628527','calle 1 240',1),
 (35543985,'Marchissio','Elian','1990-03-15','358567893','elCodito 123',3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Alumnos` ENABLE KEYS */;


--
-- Definition of trigger `educar_dev`.`triggerAltaAlumnos`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerAltaAlumnos`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerAltaAlumnos` AFTER INSERT ON `Alumnos` FOR EACH ROW BEGIN
   INSERT INTO educar_dev.users (username, password, role) VALUES (NEW.dni, RIGHT(NEW.dni, 5), "Alumno");
END $$

DELIMITER ;

--
-- Definition of trigger `educar_dev`.`triggerUpdateUserPorAlumnos`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerUpdateUserPorAlumnos`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerUpdateUserPorAlumnos` AFTER UPDATE ON `Alumnos` FOR EACH ROW BEGIN
   UPDATE educar_dev.users SET educar_dev.users.username = NEW.dni 
WHERE educar_dev.users.username = OLD.dni ;  
END $$

DELIMITER ;

--
-- Definition of trigger `educar_dev`.`triggerBajaUserPorAlumnos`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerBajaUserPorAlumnos`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerBajaUserPorAlumnos` AFTER DELETE ON `Alumnos` FOR EACH ROW BEGIN
   DELETE FROM educar_dev.users  WHERE educar_dev.users.username = OLD.dni ;  
END $$

DELIMITER ;

--
-- Definition of table `educar_dev`.`Cargo`
--

DROP TABLE IF EXISTS `educar_dev`.`Cargo`;
CREATE TABLE  `educar_dev`.`Cargo` (
  `cod_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_cargo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_cargo`),
  UNIQUE KEY `cod_cargo` (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Cargo`
--

/*!40000 ALTER TABLE `Cargo` DISABLE KEYS */;
LOCK TABLES `Cargo` WRITE;
INSERT INTO `educar_dev`.`Cargo` VALUES  (1,'Director Facultad'),
 (2,'Secretario'),
 (3,'Consejero');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Cargo` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Dicta`
--

DROP TABLE IF EXISTS `educar_dev`.`Dicta`;
CREATE TABLE  `educar_dev`.`Dicta` (
  `dni_doc` int(11) NOT NULL,
  `cod_mat` int(11) NOT NULL,
  PRIMARY KEY (`dni_doc`,`cod_mat`),
  KEY `cfCodMat` (`cod_mat`),
  CONSTRAINT `cfCodMat` FOREIGN KEY (`cod_mat`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE,
  CONSTRAINT `cfDniDoc` FOREIGN KEY (`dni_doc`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Dicta`
--

/*!40000 ALTER TABLE `Dicta` DISABLE KEYS */;
LOCK TABLES `Dicta` WRITE;
INSERT INTO `educar_dev`.`Dicta` VALUES  (26347598,1),
 (27345798,1),
 (29453060,1),
 (30347598,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Dicta` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Docente`
--

DROP TABLE IF EXISTS `educar_dev`.`Docente`;
CREATE TABLE  `educar_dev`.`Docente` (
  `dni_docente` int(11) NOT NULL,
  `apellido_d` varchar(20) NOT NULL,
  `nombre_d` varchar(20) NOT NULL,
  `fechaNac_d` date NOT NULL,
  `tel_d` int(11) DEFAULT NULL,
  `direccion_d` varchar(30) NOT NULL,
  PRIMARY KEY (`dni_docente`),
  UNIQUE KEY `dni_docente` (`dni_docente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Docente`
--

/*!40000 ALTER TABLE `Docente` DISABLE KEYS */;
LOCK TABLES `Docente` WRITE;
INSERT INTO `educar_dev`.`Docente` VALUES  (26347598,'Martellotto','Paola','1981-11-11',4765234,'Las Heras 234'),
 (27345798,'Uba','Marcelo','1980-03-11',4675234,'Alejandro Alem 12'),
 (29453060,'Brusatti','Franco','1982-03-11',4657234,'Julio Roca 1256'),
 (30347598,'Corol','Alberto','1976-01-11',4756134,'La Madrid 34');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Docente` ENABLE KEYS */;


--
-- Definition of trigger `educar_dev`.`triggerAltaDocente`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerAltaDocente`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerAltaDocente` AFTER INSERT ON `Docente` FOR EACH ROW BEGIN
   INSERT INTO educar_dev.users (username, password, role) VALUES (NEW.dni_docente, RIGHT(NEW.dni_docente, 5), "Docente");
END $$

DELIMITER ;

--
-- Definition of trigger `educar_dev`.`triggerUpdateUserPorDocente`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerUpdateUserPorDocente`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerUpdateUserPorDocente` AFTER UPDATE ON `Docente` FOR EACH ROW BEGIN
   UPDATE educar_dev.users SET educar_dev.users.username = NEW.dni_docente 
WHERE educar_dev.users.username = OLD.dni_docente;  
END $$

DELIMITER ;

--
-- Definition of trigger `educar_dev`.`triggerBajaUserPorDocente`
--

DROP TRIGGER /*!50030 IF EXISTS */ `educar_dev`.`triggerBajaUserPorDocente`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER  `educar_dev`.`triggerBajaUserPorDocente` AFTER DELETE ON `Docente` FOR EACH ROW BEGIN
   DELETE FROM educar_dev.users  WHERE educar_dev.users.username = OLD.dni_docente;  
END $$

DELIMITER ;

--
-- Definition of table `educar_dev`.`Facultad`
--

DROP TABLE IF EXISTS `educar_dev`.`Facultad`;
CREATE TABLE  `educar_dev`.`Facultad` (
  `cod_facultad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_fac` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_facultad`),
  UNIQUE KEY `cod_facultad` (`cod_facultad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Facultad`
--

/*!40000 ALTER TABLE `Facultad` DISABLE KEYS */;
LOCK TABLES `Facultad` WRITE;
INSERT INTO `educar_dev`.`Facultad` VALUES  (2,'Ciencias Economicas'),
 (3,'Ciencias Exactas'),
 (4,'Agronomia');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Facultad` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Materia`
--

DROP TABLE IF EXISTS `educar_dev`.`Materia`;
CREATE TABLE  `educar_dev`.`Materia` (
  `cod_materia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_mat` varchar(50) NOT NULL,
  `dni_docente` int(11) DEFAULT NULL,
  `facultad` int(11) NOT NULL,
  PRIMARY KEY (`cod_materia`),
  UNIQUE KEY `cod_materia` (`cod_materia`),
  KEY `codFacultad` (`facultad`),
  KEY `dniDocente` (`dni_docente`),
  CONSTRAINT `codFacultad` FOREIGN KEY (`facultad`) REFERENCES `Facultad` (`cod_facultad`) ON UPDATE CASCADE,
  CONSTRAINT `dniDocente` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Materia`
--

/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
LOCK TABLES `Materia` WRITE;
INSERT INTO `educar_dev`.`Materia` VALUES  (1,'Analisis Y Dieseño de Sistemas',26347598,3),
 (2,'Algoritmos II',NULL,3),
 (3,'Derecho privado I',30347598,2),
 (4,'Chancho',NULL,4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Materia` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Resolucion`
--

DROP TABLE IF EXISTS `educar_dev`.`Resolucion`;
CREATE TABLE  `educar_dev`.`Resolucion` (
  `codigo_res` int(11) NOT NULL AUTO_INCREMENT,
  `hr_envio` time NOT NULL,
  `fecha_res` date NOT NULL,
  `dni_docente` int(11) NOT NULL,
  `cod_actividad` int(11) NOT NULL,
  `dni_alumno` int(11) NOT NULL,
  `res_actividad` text,
  `nota` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigo_res`),
  KEY `FKdniDoncte` (`dni_docente`),
  KEY `FKcodActivdad` (`cod_actividad`),
  KEY `FKDniAlumno` (`dni_alumno`),
  CONSTRAINT `FKcodActivdad` FOREIGN KEY (`cod_actividad`) REFERENCES `TieneActividad` (`codigo_a`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKDniAlumno` FOREIGN KEY (`dni_alumno`) REFERENCES `TieneActividad` (`dni_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKdniDoncte` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Resolucion`
--

/*!40000 ALTER TABLE `Resolucion` DISABLE KEYS */;
LOCK TABLES `Resolucion` WRITE;
INSERT INTO `educar_dev`.`Resolucion` VALUES  (2,'11:43:07','2012-05-18',26347598,2,33361090,'Planteamiento\n\nEl problema SAT se trata de un problema donde interesa saber si una expresión booleana con variables y sin cuantificadores tiene \nasociada una asignación de valores para sus variables que hace que la expresión sea verdadera. Por ejemplo, una instancia de SAT \nsería el saber si existen valores para x_1,, x_2, , x_3, , x_4 tales que la expresión:\n\n    (x_1 or \neg x_3 or x_4) and (\neg x_2 or x_3 or \neg x_4)\n\n\nes cierta. Por el contrario, el problema de si la expresion en cuestion adquiere valor falso para todas las combinaciones de sus \nvariables, se denomina UNSAT.2\n\nComplejidad\n\nEl problema sigue perteneciendo a la clase de complejidad NP-completo aunque se restrinja el número de literales por cláusula a un \nmáximo de 3. En este caso se conoce como 3 SAT. Cuando el número máximo de literales por cláusula es dos, el problema tiene \ncomplejidad polinómica y se conoce como problema 2 SAT.\n\n\nEl Teorema de Cook demuestra que el problema de la satisfactibilidad booleana es NP-completo, y de hecho, este fue el primer \nproblema de decisión que se demostró ser NP-completos. Sin embargo, más allá de este teorema, algoritmos eficientes y resistentes al \ncambio de tamaño del problema para SAT se han desarrollado desde la última década y han contribuido con poderosos avances en nuestra \ncapacidad para resolver el problema de satisfactibilidad automáticamente.\n\n3-Satisfactibilidad\n\n\nLa 3-satisfactibilidad es un caso especial de -satisfactibilidad (-SAT), o simplemente satisfactibilidad (SAT), en la que cada cláusula contiene exactamente 3 literales. Fue uno de 21 problemas NP-completos de Karp.\n\nPartiendo de SAT (el caso general) se reduce a 3-SAT y SAT 3 -en 1 y se puede demostrar que son NP-completos, entonces podemos \nusarlos para demostrar también otros problemas NP-completos. Esto se hace mostrando cómo una solución a otro problema podría ser \nutilizado para resolver 3-SAT Un ejemplo de este tipo de reducción es el problema del Clique. Por lo general, es más fácil de \nutilizar reducción de 3-SAT que cuando se está tratando de probar que algun otro problema es NP-completo. El SAT 3-puede ser más \nlimitado a la 3SAT Uno-en-tres, cuando lo que pedimos sea sólo una de las variables verdadera en cada cláusula, en vez de por lo \nmenos una. 3SAT Uno-en-tres sigue siendo NP-completo.\n\nExtensiones de SAT\n\nUna extensión significativa a la popularidad que ganó desde 2003 es el problema de las teorías satisfactibilidad módulo, que permite \nenriquecer las fórmulas en la FNC con lineales, vectores, la restricción de que todas las variables sean distintas, y no interpretar \nfunciones, etc. Estas extensiones son típicamente NP-completas, pero resultan bastante eficaces para la resolución que son capaces \nde hacer frente a muchos tipos de restricciones de género.\n\n\nEl problema parece ser más difícil satisfactibilidad (PSPACE-completo) si permitimos que los cuantificadores para todos y existencial, que enlace las variables booleanas.\n\nSi se utiliza sólo cuantificadores Este sigue siendo el problema SAT Si permitimos que sólo los cuantificadores Se convierte en el \nproblema de la tautología: Co-NP-completo. Si dejamos que ellos, el problema se llama el problema de la fórmula booleana \ncuantificados (QBF), que puede se ha demostrado PSPACE completa. Se cree ampliamente que los problemas son PSPACE completa-es son \nmás difíciles que cualquier problema en NP, aunque esto aún no ha sido demostrada. . El problema de la máxima satisfactibilidad, una \ngeneralización de SAT, para pedir el número máximo de cláusulas que pueden ser satisfechas por ninguna asignación. Este problema \ntiene aproximación de con algoritmos eficientes, sino que es NP-difícil de resolver con precisión. Peor aún, el problema es APX-\ncompleto, lo que significa que no hay ningún sistema de aproximación polinomial de tiempo a este problema a menos que P = NP.\n\nAlgoritmos\n\nHay diversas clases de algoritmos de alto rendimiento para la solución de los casos de SAT en la práctica: las variantes modernas de \nel Algoritmo DPLL, como el algoritmo de paja y los algoritmos estocásticos de búsqueda local, como WalkSAT. Una resolución del tipo \nSAT Algoritmo DPLL emplea un procedimiento sistemático de rastreo para buscar a explorar el espacio (del tamaño exponencial) los \nvalores de las variables que se ajusten. El procedimiento básico de este sistema de búsqueda fue innovador en dos artículos a \nprincipios de los años 60 y es, hoy en día, normalmente se conoce como el algoritmo de Davis-Putnam-Loveland-Logemann Algoritmo DPLL.\n\n\nEl solucionador SAT moderno (desarrollado en los últimos diez años), mejora el algoritmo de base para encontrar el tipo de Algoritmo \nDPLL. eficiente con el análisis de conflictos, la cláusula de aprendizaje, no cronológico de rastreo (alias backjumping) y la \npropagación de la unidad vieron dos literales (Dos vistos literales), brazo ajustable, y reinicios aleatorios. Es empíricamente \nque tales añadidos a la búsqueda sistemática de base son esenciales para resolver el problema de casos SAT extensos que se \nplantean en la automatización de diseño electrónico. Los solucionadores modernos SAT también están causando un impacto significativo \nen los ámbitos de la verificación de software, la resolución de las limitaciones en la inteligencia artificial, y la investigación \noperativa, entre otros. Algunos salocucionadores potente disponibles entan en el dominio público, y son muy fáciles de usar. En \nparticular, el MINISAT, que ganó la competencia de la SAT de 2005, sólo alrededor de 600 líneas de código.\n\n\nAlgoritmos Genéticos y otros métodos estocásticos de búsqueda local para el uso general también se utilizan para resolver problemas \nSAT, especialmente cuando no hay o sólo un conocimiento limitado de la estructura específica de los casos del problema a ser \nresuelto. Ciertos tipos de grandes instancias aleatorias satisfactibles de SAT se puede resolver por la propagación de la vio \nliterales. En particular en el diseño y verificación de hardware, la lógica satisfactibilidad y otras propiedades de una fórmula \nproposicional a veces se decidió sobre la base de una representación de la fórmula como un diagrama de decisión binario (BDD). La \nsatisfactibilidad proposicional tiene varias generalizaciones, incluyendo satisfactibilidad al problema de la fórmula booleana \ncuantificados para la lógica clásica de primer y segundo orden (LCPO y LCSO, respectivamente), a los problemas de la satisfacción de \nlas limitaciones para la programación de enteros 0 -- 1, y el problema de la satisfactibilidad máximo. Muchos otros problemas de la \ndecisión, como los problemas de coloración de grafos, problemas de planificación y programación de problemas, puede ser codificado \nen SAT',10);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Resolucion` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`TieneActividad`
--

DROP TABLE IF EXISTS `educar_dev`.`TieneActividad`;
CREATE TABLE  `educar_dev`.`TieneActividad` (
  `dni_alumno` int(11) NOT NULL,
  `codigo_a` int(11) NOT NULL,
  PRIMARY KEY (`dni_alumno`,`codigo_a`),
  KEY `cfCodActividad` (`codigo_a`),
  CONSTRAINT `cfCodActividad` FOREIGN KEY (`codigo_a`) REFERENCES `Actividad` (`cod_actividad`) ON UPDATE CASCADE,
  CONSTRAINT `cfDniAlumno` FOREIGN KEY (`dni_alumno`) REFERENCES `Alumnos` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`TieneActividad`
--

/*!40000 ALTER TABLE `TieneActividad` DISABLE KEYS */;
LOCK TABLES `TieneActividad` WRITE;
INSERT INTO `educar_dev`.`TieneActividad` VALUES  (32328847,2),
 (33361090,2),
 (35543985,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `TieneActividad` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Trabaja`
--

DROP TABLE IF EXISTS `educar_dev`.`Trabaja`;
CREATE TABLE  `educar_dev`.`Trabaja` (
  `codigo_fac` int(11) NOT NULL,
  `dni_doc` int(11) NOT NULL,
  `codigo_cargo` int(11) NOT NULL,
  `hs_dedicacion` int(11) NOT NULL,
  PRIMARY KEY (`codigo_fac`,`dni_doc`),
  KEY `FKdniDoc` (`dni_doc`),
  KEY `FKcodCargo` (`codigo_cargo`),
  CONSTRAINT `FKcodCargo` FOREIGN KEY (`codigo_cargo`) REFERENCES `Cargo` (`cod_cargo`) ON UPDATE CASCADE,
  CONSTRAINT `FKcodFac` FOREIGN KEY (`codigo_fac`) REFERENCES `Facultad` (`cod_facultad`) ON UPDATE CASCADE,
  CONSTRAINT `FKdniDoc` FOREIGN KEY (`dni_doc`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Trabaja`
--

/*!40000 ALTER TABLE `Trabaja` DISABLE KEYS */;
LOCK TABLES `Trabaja` WRITE;
INSERT INTO `educar_dev`.`Trabaja` VALUES  (2,30347598,1,12),
 (3,27345798,3,30);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Trabaja` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`cursa`
--

DROP TABLE IF EXISTS `educar_dev`.`cursa`;
CREATE TABLE  `educar_dev`.`cursa` (
  `dni_a` int(11) NOT NULL,
  `cod_mat` int(11) NOT NULL,
  PRIMARY KEY (`dni_a`,`cod_mat`),
  KEY `cfCodMateria` (`cod_mat`),
  CONSTRAINT `cfCodMateria` FOREIGN KEY (`cod_mat`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE,
  CONSTRAINT `cfDniA` FOREIGN KEY (`dni_a`) REFERENCES `Alumnos` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`cursa`
--

/*!40000 ALTER TABLE `cursa` DISABLE KEYS */;
LOCK TABLES `cursa` WRITE;
INSERT INTO `educar_dev`.`cursa` VALUES  (32328847,1),
 (33361090,1),
 (35543985,1),
 (33361090,2),
 (35543985,3),
 (32328847,4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cursa` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`users`
--

DROP TABLE IF EXISTS `educar_dev`.`users`;
CREATE TABLE  `educar_dev`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(90) NOT NULL,
  `password` varchar(90) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `educar_dev`.`users` VALUES  (71,'root','root','root'),
 (72,'gladis_admin','123','admin'),
 (73,'29453060','53060','Docente'),
 (74,'27345798','45798','Docente'),
 (75,'26347598','47598','Docente'),
 (76,'30347598','47598','Docente'),
 (77,'33361090','61090','Alumno'),
 (78,'32328847','28847','Alumno'),
 (79,'35543985','43985','Alumno');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
