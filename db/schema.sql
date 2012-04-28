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
  `cod_actividad` int(11) NOT NULL,
  `descripcion_act` varchar(50) DEFAULT NULL,
  `cod_materia` int(11) NOT NULL,
  PRIMARY KEY (`cod_actividad`),
  UNIQUE KEY `cod_actividad` (`cod_actividad`),
  KEY `codMateria` (`cod_materia`),
  CONSTRAINT `codMateria` FOREIGN KEY (`cod_materia`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Actividad`
--

/*!40000 ALTER TABLE `Actividad` DISABLE KEYS */;
LOCK TABLES `Actividad` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Actividad` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Alumnos`
--

DROP TABLE IF EXISTS `educar_dev`.`Alumnos`;
CREATE TABLE  `educar_dev`.`Alumnos` (
  `dni` int(11) NOT NULL,
  `apellido_a` varchar(30) NOT NULL,
  `nombre_a` varchar(30) NOT NULL,
  `fechaNac_a` date NOT NULL,
  `edad_a` int(11) NOT NULL,
  `telefono_a` varchar(30) DEFAULT NULL,
  `direccion_a` varchar(50) DEFAULT NULL,
  `nro_alumno` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`dni`) USING BTREE,
  UNIQUE KEY `dni_a` (`dni`),
  UNIQUE KEY `nro_alumno` (`nro_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Alumnos`
--

/*!40000 ALTER TABLE `Alumnos` DISABLE KEYS */;
LOCK TABLES `Alumnos` WRITE;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Cargo`
--

/*!40000 ALTER TABLE `Cargo` DISABLE KEYS */;
LOCK TABLES `Cargo` WRITE;
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
  CONSTRAINT `cfDniDoc` FOREIGN KEY (`dni_doc`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE,
  CONSTRAINT `cfCodMat` FOREIGN KEY (`cod_mat`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Dicta`
--

/*!40000 ALTER TABLE `Dicta` DISABLE KEYS */;
LOCK TABLES `Dicta` WRITE;
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
  `edad_d` int(11) NOT NULL,
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
INSERT INTO `educar_dev`.`Docente` VALUES  (443,'xxx','xxx','2000-12-12',22,101,'xxx'),
 (888,'xxx','xxx','2000-12-12',22,0,'xxx'),
 (1014,'xxx','xxx','2000-12-12',22,0,'xxx'),
 (1140,'xxx','xxx','2000-12-12',22,101,'xxx'),
 (1234,'v','v','1223-12-12',33,1234,'v'),
 (3411,'ss','ss','2012-12-12',43,567,'ss'),
 (4444,'xxx','xxx','2000-12-12',22,0,'xxx'),
 (4445,'xxx','xxx','2000-12-12',22,34,'xxx'),
 (7777,'v','v','1223-12-12',33,1234,'v'),
 (8884,'xxx','xxx','2000-12-12',22,6578,'xxx'),
 (10140,'xxx','xxx','2000-12-12',22,101,'xxx'),
 (44444,'v','v','1223-12-12',33,1234,'v'),
 (65432,'laala','laala','2012-12-12',12,12,'laala'),
 (89563,'xxx','xxx','2000-12-12',22,45,'xxx'),
 (99777,'hhh','hhh','1212-12-12',55,77,'hhh'),
 (121212,'vcv','dcdfc','1212-12-12',22,34,'dfdf');
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
  `nombre` varchar(50) NOT NULL,
  `descripcion_fac` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_facultad`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Facultad`
--

/*!40000 ALTER TABLE `Facultad` DISABLE KEYS */;
LOCK TABLES `Facultad` WRITE;
INSERT INTO `educar_dev`.`Facultad` VALUES  (1,'matematica'),
 (2,'matematica');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Facultad` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Materia`
--

DROP TABLE IF EXISTS `educar_dev`.`Materia`;
CREATE TABLE  `educar_dev`.`Materia` (
  `cod_materia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_mat` varchar(50) NOT NULL,
  `dni_docente` int(11) NOT NULL,
  `facultad` int(11) NOT NULL,
  PRIMARY KEY (`cod_materia`),
  UNIQUE KEY `cod_materia` (`cod_materia`),
  KEY `codFacultad` (`facultad`),
  KEY `dniDocente` (`dni_docente`),
  CONSTRAINT `codFacultad` FOREIGN KEY (`facultad`) REFERENCES `Facultad` (`cod_facultad`) ON UPDATE CASCADE,
  CONSTRAINT `dniDocente` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Materia`
--

/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
LOCK TABLES `Materia` WRITE;
INSERT INTO `educar_dev`.`Materia` VALUES  (3,'matematica',443,1);
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
  `nota` int(11) NOT NULL,
  PRIMARY KEY (`codigo_res`),
  KEY `dniDoncte` (`dni_docente`),
  CONSTRAINT `dniDoncte` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `codigo_r` int(11) NOT NULL,
  PRIMARY KEY (`dni_alumno`,`codigo_a`,`codigo_r`),
  KEY `cfCodActividad` (`codigo_a`),
  KEY `cfCodResolucion` (`codigo_r`),
  CONSTRAINT `cfDniAlumno` FOREIGN KEY (`dni_alumno`) REFERENCES `Alumnos` (`dni`) ON UPDATE CASCADE,
  CONSTRAINT `cfCodActividad` FOREIGN KEY (`codigo_a`) REFERENCES `Actividad` (`cod_actividad`) ON UPDATE CASCADE,
  CONSTRAINT `cfCodResolucion` FOREIGN KEY (`codigo_r`) REFERENCES `Resolucion` (`codigo_res`) ON UPDATE CASCADE
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
  PRIMARY KEY (`codigo_fac`,`dni_doc`,`codigo_cargo`),
  KEY `dniDoc` (`dni_doc`),
  KEY `codCargo` (`codigo_cargo`),
  CONSTRAINT `codFac` FOREIGN KEY (`codigo_fac`) REFERENCES `Facultad` (`cod_facultad`) ON UPDATE CASCADE,
  CONSTRAINT `dniDoc` FOREIGN KEY (`dni_doc`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE,
  CONSTRAINT `codCargo` FOREIGN KEY (`codigo_cargo`) REFERENCES `Cargo` (`cod_cargo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Trabaja`
--

/*!40000 ALTER TABLE `Trabaja` DISABLE KEYS */;
LOCK TABLES `Trabaja` WRITE;
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
  CONSTRAINT `cfDniA` FOREIGN KEY (`dni_a`) REFERENCES `Alumnos` (`dni`) ON UPDATE CASCADE,
  CONSTRAINT `cfCodMateria` FOREIGN KEY (`cod_mat`) REFERENCES `Materia` (`cod_materia`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`cursa`
--

/*!40000 ALTER TABLE `cursa` DISABLE KEYS */;
LOCK TABLES `cursa` WRITE;
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `educar_dev`.`users` VALUES  (5,'edu','33361090','admin'),
 (14,'root','root','root'),
 (15,'juan','loka','admin'),
 (16,'saul','1','admin'),
 (18,'eduardo','1','admin'),
 (19,'eduardoo','1','admin'),
 (20,'a','1','admin'),
 (21,'aa','1','admin'),
 (22,'q','1','admin'),
 (23,'as','1','admin'),
 (24,'qwe','1','admin'),
 (25,'asd','12','admin'),
 (26,'asmdñ','1','admin'),
 (27,'','','admin'),
 (28,'mdcdkc','4','admin'),
 (29,'askdjfñl','12','admin'),
 (30,'jua','carlos','admin');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
