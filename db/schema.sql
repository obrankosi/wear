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
  `dni_a` int(11) NOT NULL,
  `nombre_a` varchar(30) NOT NULL,
  `nro_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `apellido_a` varchar(30) NOT NULL,
  `edad_a` int(11) NOT NULL,
  `fechaNac_a` date NOT NULL,
  `telefono_a` varchar(30) DEFAULT NULL,
  `direccion_a` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dni_a`),
  UNIQUE KEY `dni_a` (`dni_a`),
  UNIQUE KEY `nro_alumno` (`nro_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
				INSERT INTO educar_dev.users (username, password, role) VALUES (NEW.dni_a, RIGHT(NEW.dni_a, 5), "Alumno");
END $$

DELIMITER ;

--
-- Definition of table `educar_dev`.`Cargo`
--

DROP TABLE IF EXISTS `educar_dev`.`Cargo`;
CREATE TABLE  `educar_dev`.`Cargo` (
  `cod_cargo` int(11) NOT NULL,
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
UNLOCK TABLES;
/*!40000 ALTER TABLE `Docente` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Facultad`
--

DROP TABLE IF EXISTS `educar_dev`.`Facultad`;
CREATE TABLE  `educar_dev`.`Facultad` (
  `cod_facultad` int(11) NOT NULL,
  `descripcion_fac` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_facultad`),
  UNIQUE KEY `cod_facultad` (`cod_facultad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Facultad`
--

/*!40000 ALTER TABLE `Facultad` DISABLE KEYS */;
LOCK TABLES `Facultad` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Facultad` ENABLE KEYS */;


--
-- Definition of table `educar_dev`.`Materia`
--

DROP TABLE IF EXISTS `educar_dev`.`Materia`;
CREATE TABLE  `educar_dev`.`Materia` (
  `cod_materia` int(11) NOT NULL,
  `nombre_mat` varchar(50) NOT NULL,
  `dni_docente` int(11) NOT NULL,
  PRIMARY KEY (`cod_materia`),
  UNIQUE KEY `cod_materia` (`cod_materia`),
  KEY `dniDocente` (`dni_docente`),
  CONSTRAINT `dniDocente` FOREIGN KEY (`dni_docente`) REFERENCES `Docente` (`dni_docente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `educar_dev`.`Materia`
--

/*!40000 ALTER TABLE `Materia` DISABLE KEYS */;
LOCK TABLES `Materia` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Materia` ENABLE KEYS */;


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
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

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
 (30,'jua','carlos','admin'),
 (31,'34574548','74548','Alumno'),
 (32,'3457454','57454','Alumno'),
 (33,'12345678','45678','Alumno');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
