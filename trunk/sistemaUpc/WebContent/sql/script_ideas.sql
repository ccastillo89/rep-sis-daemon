SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `usuario` (
  `idusuario` INT NOT NULL ,
  `correo` VARCHAR(100) NULL ,
  `password` VARCHAR(100) NULL ,
  `tipo_usuario` INT NULL ,
  PRIMARY KEY (`idusuario`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `publicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `publicacion` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `publicacion` (
  `idpublicacion` INT NOT NULL ,
  `titulo` VARCHAR(100) NULL ,
  `descripcion` TEXT NULL ,
  `archivo` VARCHAR(150) NULL ,
  `idusuario` INT NOT NULL ,
  `estado` INT NULL ,
  `usuario_acesor` INT NOT NULL ,
  `fecha_creacion` DATETIME NULL ,
  `palabra_clave` VARCHAR(250) NULL ,
  `fecha_publicacion` DATETIME NULL ,
  PRIMARY KEY (`idpublicacion`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comentario` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `comentario` (
  `idcomentario` INT NOT NULL ,
  `descripcion` TEXT NULL ,
  `idusuario` INT NOT NULL ,
  `idpublicacion` INT NOT NULL ,
  `puntos` INT NULL ,
  PRIMARY KEY (`idcomentario`, `idusuario`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `usuario_permitido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_permitido` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `usuario_permitido` (
  `idcomentario` INT NOT NULL ,
  `idusuario` INT NOT NULL )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `centro_formacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centro_formacion` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `centro_formacion` (
  `idcentro_formacion` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `tipo` INT NULL ,
  `url` VARCHAR(45) NULL ,
  `logo` VARCHAR(150) NULL ,
  PRIMARY KEY (`idcentro_formacion`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `persona` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `persona` (
  `idpersona` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `nombres` VARCHAR(50) NULL ,
  `paterno` VARCHAR(50) NULL ,
  `materno` VARCHAR(45) NULL ,
  `sexo` INT NULL ,
  `tipo_documento` INT NULL ,
  `numero_doc` VARCHAR(45) NULL ,
  `celular` VARCHAR(12) NULL ,
  `idcentro_formacion` INT NOT NULL ,
  PRIMARY KEY (`idpersona`, `idcentro_formacion`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `asesoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asesoria` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `asesoria` (
  `idasesoria` INT NOT NULL ,
  `observacion` VARCHAR(45) NULL ,
  `calificacion` INT NULL ,
  `fecha` DATETIME NULL ,
  `idcomentario` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`idasesoria`, `idcomentario`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `codigo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `codigo` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `codigo` (
  `idcodigo` INT NOT NULL ,
  `Descripcion_Codigo` VARCHAR(45) NULL ,
  `IdGrupo` INT NULL ,
  `Grupo` VARCHAR(45) NULL ,
  PRIMARY KEY (`idcodigo`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `respuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `respuesta` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `respuesta` (
  `idrespuesta` INT NOT NULL ,
  `texto` TEXT NULL ,
  `idusuario` INT NOT NULL ,
  `comentarios_idcomentarios` INT NOT NULL ,
  PRIMARY KEY (`idrespuesta`, `idusuario`, `comentarios_idcomentarios`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `opcion_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opcion_menu` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `opcion_menu` (
  `idopcion_menu` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idopcion_menu`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `usuario_has_opciones_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_has_opciones_menu` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `usuario_has_opciones_menu` (
  `idusuario` INT NOT NULL ,
  `idopciones_menu` INT NOT NULL ,
  PRIMARY KEY (`idusuario`, `idopciones_menu`) )
ENGINE = InnoDB;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
