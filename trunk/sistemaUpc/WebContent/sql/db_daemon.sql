CREATE DATABASE  IF NOT EXISTS `db_daemon` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_daemon`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: db_daemon
-- ------------------------------------------------------
-- Server version	5.5.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `paterno` varchar(50) DEFAULT NULL,
  `materno` varchar(45) DEFAULT NULL,
  `sexo` int(11) DEFAULT NULL,
  `tipo_documento` int(11) DEFAULT NULL,
  `numero_doc` varchar(45) DEFAULT NULL,
  `celular` varchar(12) DEFAULT NULL,
  `idcentro_formacion` int(11) NOT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Samuel','Flores','hernandez',1,11,'46683052','987924562',1),(2,'Manuel','Angeles','de la Cruz',1,11,'45782145','45688711',1),(3,'Carlos ','Castillo','Calderón',1,11,'45896325','LE ROBARON',1),(4,'Saul','Ramos','Llerena',1,11,'14521454','65478941',2),(5,'Ivan','Juárez','Sevilla',2,11,'45874521','987924525',3);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `idrespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `texto` text,
  `idcomentario` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idrespuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `idpersona` int(11) NOT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `tipo_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'smlflores18@gmail.com','123',1),(2,2,'manuela@manuelita.com','123',2),(3,3,'carlos@gmail.com','123',1),(4,4,'vagul@gmail.com','123',1),(5,5,'chivan@gmail.com','123',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_permitido`
--

DROP TABLE IF EXISTS `usuario_permitido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_permitido` (
  `idcomentario` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_permitido`
--

LOCK TABLES `usuario_permitido` WRITE;
/*!40000 ALTER TABLE `usuario_permitido` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_permitido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicacion` (
  `idpublicacion` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `archivo` varchar(150) DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `usuario_acesor` int(11) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `palabra_clave` varchar(250) DEFAULT NULL,
  `fecha_publicacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idpublicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
INSERT INTO `publicacion` VALUES (1,'Aplicacion SmarthPhone','Crear una Aplicacion Mostrar Ideas',NULL,1,1,NULL,'2014-03-12 00:00:00','smarthphone','2014-03-12 00:00:00'),(2,'Videoteca Online','Implementar una Videoteca Online',NULL,2,1,NULL,'2014-03-12 00:00:00','videoteca','2014-03-12 00:00:00'),(3,'Biblioteca Online','Desarrollar una Biblioteca Online',NULL,1,1,NULL,'2014-03-12 00:00:00','biblioteca','2014-03-12 00:00:00');
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asesoria`
--

DROP TABLE IF EXISTS `asesoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asesoria` (
  `idasesoria` int(11) NOT NULL AUTO_INCREMENT,
  `observacion` varchar(45) DEFAULT NULL,
  `calificacion` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idpublicacion` int(11) NOT NULL,
  PRIMARY KEY (`idasesoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asesoria`
--

LOCK TABLES `asesoria` WRITE;
/*!40000 ALTER TABLE `asesoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `asesoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo`
--

DROP TABLE IF EXISTS `codigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo` (
  `idcodigo` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion_Codigo` varchar(45) DEFAULT NULL,
  `IdGrupo` int(11) DEFAULT NULL,
  `Grupo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo`
--

LOCK TABLES `codigo` WRITE;
/*!40000 ALTER TABLE `codigo` DISABLE KEYS */;
INSERT INTO `codigo` VALUES (1,'Administrador',1,'Roles'),(2,'Supervisor',1,'Roles'),(3,'Asesor',1,'Roles'),(4,'Estudiante',1,'Roles'),(5,'Evaluador de Innovador',1,'Roles'),(6,'Publicada',2,'Estado_Publicacion'),(7,'Aprobada',2,'Estado_Publicacion'),(8,'Rechazada',2,'Estado_Publicacion'),(9,'Universidad',3,'Tipo_CentroFormacion'),(10,'Instituto',3,'Tipo_CentroFormacion'),(11,'DNI',4,'Tipo_Documento'),(12,'RUC',4,'Tipo_Documento');
/*!40000 ALTER TABLE `codigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `idpublicacion` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idcomentario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro_formacion`
--

DROP TABLE IF EXISTS `centro_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centro_formacion` (
  `idcentro_formacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `logo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idcentro_formacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro_formacion`
--

LOCK TABLES `centro_formacion` WRITE;
/*!40000 ALTER TABLE `centro_formacion` DISABLE KEYS */;
INSERT INTO `centro_formacion` VALUES (1,'Universidad Peruana de Ciencias Aplicadas',9,'www.upc.edu.pe',NULL),(2,'Cybertec',10,'www.cybertec.edu.pe',NULL),(3,'Universidad San Ignacio de Loyola',9,'www.usil.edu.pe',NULL),(4,'Universidad Cesar Vallejo',9,'www.ucv.com',NULL),(5,'Universidad San Martin de Porres',9,'www.usmp.com',NULL);
/*!40000 ALTER TABLE `centro_formacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-12 20:29:59
