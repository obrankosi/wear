CREATE TABLE Alumnos (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	dni INT NOT NULL PRIMARY KEY,
	nombre VARCHAR(90) NOT NULL,
	apellido VARCHAR(90) NOT NULL,
	fechaNac DATE NOT NULL,
	telefono VARCHAR(90),
	direccion VARCHAR(90)
);

DROP TRIGGER triggerAltaAlumnos;
DELIMITER $$
CREATE TRIGGER triggerAltaAlumnos
	AFTER INSERT ON educar_dev.alumnos
		FOR EACH ROW
			BEGIN
				INSERT INTO educar_dev.users (username, password, role) VALUES (NEW.dni, RIGHT(NEW.dni, 5), "Alumno");
			END$$
DELIMITER ;