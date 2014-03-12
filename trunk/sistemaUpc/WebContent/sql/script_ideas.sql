SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `DB_Daemon` ;
CREATE SCHEMA IF NOT EXISTS `DB_Daemon` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `DB_Daemon` ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `centro_formacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centro_formacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `centro_formacion` (
  `idcentro_formacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `tipo` INT NULL,
  `url` VARCHAR(45) NULL,
  `logo` VARCHAR(150) NULL,
  PRIMARY KEY (`idcentro_formacion`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `persona` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NULL,
  `paterno` VARCHAR(50) NULL,
  `materno` VARCHAR(45) NULL,
  `sexo` INT NULL,
  `tipo_documento` INT NULL,
  `numero_doc` VARCHAR(45) NULL,
  `celular` VARCHAR(12) NULL,
  `idcentro_formacion` INT NOT NULL,
  PRIMARY KEY (`idpersona`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `idpersona` INT NOT NULL,
  `correo` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `tipo_usuario` INT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `publicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `publicacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `publicacion` (
  `idpublicacion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NULL,
  `descripcion` TEXT NULL,
  `archivo` VARCHAR(150) NULL,
  `idusuario` INT NOT NULL,
  `estado` INT NULL,
  `usuario_acesor` INT NULL,
  `fecha_creacion` DATETIME NULL,
  `palabra_clave` VARCHAR(250) NULL,
  `fecha_publicacion` DATETIME NULL,
  PRIMARY KEY (`idpublicacion`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comentario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `comentario` (
  `idcomentario` INT NOT NULL AUTO_INCREMENT,
  `descripcion` TEXT NULL,
  `idpublicacion` INT NOT NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idcomentario`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `usuario_permitido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_permitido` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `usuario_permitido` (
  `idcomentario` INT NOT NULL,
  `idusuario` INT NOT NULL,
  `puntos` INT NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `asesoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asesoria` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `asesoria` (
  `idasesoria` INT NOT NULL AUTO_INCREMENT,
  `observacion` VARCHAR(45) NULL,
  `calificacion` INT NULL,
  `fecha` DATETIME NULL,
  `idpublicacion` INT NOT NULL,
  PRIMARY KEY (`idasesoria`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `codigo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `codigo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `codigo` (
  `idcodigo` INT NOT NULL AUTO_INCREMENT,
  `Descripcion_Codigo` VARCHAR(45) NULL,
  `IdGrupo` INT NULL,
  `Grupo` VARCHAR(45) NULL,
  PRIMARY KEY (`idcodigo`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `respuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `respuesta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `respuesta` (
  `idrespuesta` INT NOT NULL AUTO_INCREMENT,
  `texto` TEXT NULL,
  `idcomentario` INT NOT NULL,
  `idusuario` INT NOT NULL,
  PRIMARY KEY (`idrespuesta`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- INSERTs
-- -----------------------------------------------------

Insert into Codigo(
  Descripcion_Codigo,
  IdGrupo,
  Grupo)
  Values('Administrador', 1, 'Roles'),
  ('Supervisor', 1, 'Roles'),
  ('Asesor', 1, 'Roles'),
  ('Estudiante', 1, 'Roles'),
  ('Evaluador de Innovador', 1, 'Roles'),
  ('Publicada', 2, 'Estado_Publicacion'),
  ('Aprobada', 2, 'Estado_Publicacion'),
  ('Rechazada', 2, 'Estado_Publicacion');


select * from codigo;

-- -------------------------------
-- DROP PROCEDURE IF EXISTS usp_sel_BuscarPersonas; 
-- 
-- DELIMITER // 
-- CREATE PROCEDURE usp_sel_BuscarPersonas() 
-- 
-- BEGIN 
-- 
-- Select * from persona
-- 
-- END 
-- -- --------------------------------
-- 
-- call mysp()