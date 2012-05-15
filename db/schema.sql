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
  `descripcion_act` varchar(50) DEFAULT NULL,
  `cod_materia` int(11) NOT NULL,
  PRIMARY KEY (`cod_actividad`),
  UNIQUE KEY `cod_actividad` (`cod_actividad`),
  KEY `codMateria` (`cod_materia`),
  CONSTRAINT `codMateria` FOREIGN KEY (`cod_materia`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Actividad`
--

/*!40000 ALTER TABLE `Actividad` DISABLE KEYS */;
LOCK TABLES `Actividad` WRITE;
INSERT INTO `educar_dev`.`Actividad` VALUES  (1,'practica 1',1),
 (3,'practica 1',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Alumnos`
--

/*!40000 ALTER TABLE `Alumnos` DISABLE KEYS */;
LOCK TABLES `Alumnos` WRITE;
INSERT INTO `educar_dev`.`Alumnos` VALUES  (1,'coria','gaston','1990-05-05','15467809','calle 1 240',4),
 (3336109,'depetris','eduardo','1212-12-12','4652120','calle 1 240',5);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Cargo`
--

/*!40000 ALTER TABLE `Cargo` DISABLE KEYS */;
LOCK TABLES `Cargo` WRITE;
INSERT INTO `educar_dev`.`Cargo` VALUES  (3,'holaa'),
 (4,'nuevoCargo');
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
INSERT INTO `educar_dev`.`Dicta` VALUES  (25467843,1),
 (33361078,1),
 (33361078,2);
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
INSERT INTO `educar_dev`.`Docente` VALUES  (3337,'lala','lala','1567-12-12',4567,'lalala'),
 (25467843,'zareta','lucas','1978-12-12',343456,'moldes 54'),
 (31334567,'gonzales','pedro','1912-12-12',77654,'san juan 134'),
 (33361078,'jope','carlos','2000-12-12',4554677,'laprida 120');
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
INSERT INTO `educar_dev`.`Facultad` VALUES  (1,'facultad Fisica Quimica'),
 (2,'Facultad Quimica'),
 (4,'NUEVA');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Materia`
--

/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
LOCK TABLES `Materia` WRITE;
INSERT INTO `educar_dev`.`Materia` VALUES  (1,'metafisica dofs',25467843,2),
 (2,'fisica',31334567,2),
 (11,'Aleman sin',31334567,2),
 (13,'alquimica 3',25467843,1),
 (14,'test',NULL,2);
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
  CONSTRAINT `FKDniAlumno` FOREIGN KEY (`dni_alumno`) REFERENCES `TieneActividad` (`dni_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKcodActivdad` FOREIGN KEY (`cod_actividad`) REFERENCES `TieneActividad` (`codigo_a`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKdniDoncte` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Resolucion`
--

/*!40000 ALTER TABLE `Resolucion` DISABLE KEYS */;
LOCK TABLES `Resolucion` WRITE;
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
INSERT INTO `educar_dev`.`Trabaja` VALUES  (1,33361078,3,44),
 (2,25467843,3,55),
 (2,33361078,4,1);
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
INSERT INTO `educar_dev`.`cursa` VALUES  (1,1),
 (3336109,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `educar_dev`.`users` VALUES  (12,'root','1','root'),
 (62,'3336109','36109','Alumno'),
 (63,'1','85245','Alumno'),
 (64,'33361078','61078','Docente'),
 (65,'31334567','34567','Docente'),
 (66,'25467843','67843','Docente'),
 (67,'a','1','admin'),
 (68,'b','1','admin'),
 (69,'3337','3337','Docente');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
