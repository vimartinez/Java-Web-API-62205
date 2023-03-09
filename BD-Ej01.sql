 database jwa;


CREATE TABLE jwa.Users (
	Id INT UNIQUE NOT NULL,
	nombreApellido varchar(100) NULL,
	mail varchar(100) NOT NULL,
	mailVerificado BOOL DEFAULT false NULL,
	clave varchar(100) NOT NULL,
	Direccion varchar(100) NULL,
	fechaNacimiento DATETIME NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

INSERT INTO jwa.Users
(Id, nombreApellido, mail, mailVerificado, clave, Direccion, fechaNacimiento)
VALUES(1, "Pablo Perez", 'pablo@gmail.com', 0,  MD5('1234'), NULL, '2002-04-03 14:00:45');

INSERT INTO jwa.Users
(Id, nombreApellido, mail, mailVerificado, clave, Direccion, fechaNacimiento)
VALUES(2, "José Gomez", 'jose@gmail.com', 1,  MD5('12345'), "Corrientes 341 2 B, CABA", '1995-06-11 10:50:00');

INSERT INTO jwa.Users
(Id, nombreApellido, mail, mailVerificado, clave, Direccion, fechaNacimiento)
VALUES(3, "Mónica Solari", 'monica@gmail.com', 1,  MD5('123'), "Av San Martin 987, San Rafael, Mendoza", '1994-08-27 14:00:00');

COMMIT;

Select * from Users;