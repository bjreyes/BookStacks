-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstacks
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquiler` (
  `idalquiler` int(11) NOT NULL AUTO_INCREMENT,
  `codAlquiler` varchar(45) DEFAULT NULL,
  `fechaEntrega` varchar(40) DEFAULT NULL,
  `fechaSalida` varchar(40) DEFAULT NULL,
  `montoPagar` decimal(5,0) DEFAULT NULL,
  `nomClienteAlquiler` varchar(100) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL,
  `estadoAlquiler` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idalquiler`,`persona_idpersona`),
  KEY `fk_alquiler_persona1_idx` (`persona_idpersona`),
  CONSTRAINT `fk_alquiler_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquilerdisco`
--

DROP TABLE IF EXISTS `alquilerdisco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquilerdisco` (
  `idalquilerDisco` int(11) NOT NULL AUTO_INCREMENT,
  `disco_iddisco` int(11) NOT NULL,
  `alquiler_idalquiler` int(11) NOT NULL,
  PRIMARY KEY (`idalquilerDisco`,`disco_iddisco`,`alquiler_idalquiler`),
  KEY `fk_alquilerDisco_disco1_idx` (`disco_iddisco`),
  KEY `fk_alquilerDisco_alquiler1_idx` (`alquiler_idalquiler`),
  CONSTRAINT `fk_alquilerDisco_alquiler1` FOREIGN KEY (`alquiler_idalquiler`) REFERENCES `alquiler` (`idalquiler`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquilerDisco_disco1` FOREIGN KEY (`disco_iddisco`) REFERENCES `disco` (`iddisco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquilerdisco`
--

LOCK TABLES `alquilerdisco` WRITE;
/*!40000 ALTER TABLE `alquilerdisco` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquilerdisco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquilerlibros`
--

DROP TABLE IF EXISTS `alquilerlibros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquilerlibros` (
  `idalquilerLibros` int(11) NOT NULL AUTO_INCREMENT,
  `alquiler_idalquiler` int(11) NOT NULL,
  `libro_idlibro` int(11) NOT NULL,
  PRIMARY KEY (`idalquilerLibros`,`alquiler_idalquiler`,`libro_idlibro`),
  KEY `fk_alquilerLibros_alquiler1_idx` (`alquiler_idalquiler`),
  KEY `fk_alquilerLibros_libro1_idx` (`libro_idlibro`),
  CONSTRAINT `fk_alquilerLibros_alquiler1` FOREIGN KEY (`alquiler_idalquiler`) REFERENCES `alquiler` (`idalquiler`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquilerLibros_libro1` FOREIGN KEY (`libro_idlibro`) REFERENCES `libro` (`idlibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquilerlibros`
--

LOCK TABLES `alquilerlibros` WRITE;
/*!40000 ALTER TABLE `alquilerlibros` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquilerlibros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquilerrevista`
--

DROP TABLE IF EXISTS `alquilerrevista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquilerrevista` (
  `idalquilerRevista` int(11) NOT NULL AUTO_INCREMENT,
  `revista_idrevista` int(11) NOT NULL,
  `alquiler_idalquiler` int(11) NOT NULL,
  PRIMARY KEY (`idalquilerRevista`,`revista_idrevista`,`alquiler_idalquiler`),
  KEY `fk_alquilerRevista_revista1_idx` (`revista_idrevista`),
  KEY `fk_alquilerRevista_alquiler1_idx` (`alquiler_idalquiler`),
  CONSTRAINT `fk_alquilerRevista_alquiler1` FOREIGN KEY (`alquiler_idalquiler`) REFERENCES `alquiler` (`idalquiler`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquilerRevista_revista1` FOREIGN KEY (`revista_idrevista`) REFERENCES `revista` (`idrevista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquilerrevista`
--

LOCK TABLES `alquilerrevista` WRITE;
/*!40000 ALTER TABLE `alquilerrevista` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquilerrevista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `idautor` int(11) NOT NULL AUTO_INCREMENT,
  `nomAutor` varchar(45) DEFAULT NULL,
  `apePatAutor` varchar(45) DEFAULT NULL,
  `apeMatAutor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idautor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Joanne','Rowling','Galbraith'),(2,'Stephen','King','Amell'),(3,'Arthur','Conan','Doyle');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disco`
--

DROP TABLE IF EXISTS `disco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disco` (
  `iddisco` int(11) NOT NULL AUTO_INCREMENT,
  `codDiscol` varchar(45) DEFAULT NULL,
  `nomDisco` varchar(45) DEFAULT NULL,
  `tamanoDisco` varchar(45) DEFAULT NULL,
  `genero_idgenero` int(11) NOT NULL,
  `precioPorDiaDisco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddisco`,`genero_idgenero`),
  KEY `fk_disco_genero1_idx` (`genero_idgenero`),
  CONSTRAINT `fk_disco_genero1` FOREIGN KEY (`genero_idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disco`
--

LOCK TABLES `disco` WRITE;
/*!40000 ALTER TABLE `disco` DISABLE KEYS */;
/*!40000 ALTER TABLE `disco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `nomGenero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Historico'),(2,'Comedia'),(3,'Cultural'),(4,'Infantil');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `codLibro` varchar(45) DEFAULT NULL,
  `tituloLibro` varchar(200) DEFAULT NULL,
  `numPagLibro` int(11) DEFAULT NULL,
  `idiomaLibro` varchar(100) DEFAULT NULL,
  `autor_idautor` int(11) NOT NULL,
  `genero_idgenero` int(11) NOT NULL,
  `precioPorDiaLibro` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`idlibro`,`autor_idautor`,`genero_idgenero`),
  KEY `fk_libro_autor_idx` (`autor_idautor`),
  KEY `fk_libro_genero1_idx` (`genero_idgenero`),
  CONSTRAINT `fk_libro_autor` FOREIGN KEY (`autor_idautor`) REFERENCES `autor` (`idautor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_genero1` FOREIGN KEY (`genero_idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioPersona` varchar(255) DEFAULT NULL,
  `contrasenaPersona` varchar(255) DEFAULT NULL,
  `nombrePersona` varchar(225) DEFAULT NULL,
  `apellidoMatPersona` varchar(225) DEFAULT NULL,
  `apellidoPatPersona` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (3,'breyes','admin','Bruno','Reyes','Busalleu'),(4,'waguirre','admin','Willy','Aguirre','Rodriguez'),(5,'rtorres','admin','Roberto','Torres','Avales'),(6,'ralvarez','admin','Roberto','Alvarez','Espinosa');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendacion`
--

DROP TABLE IF EXISTS `recomendacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recomendacion` (
  `idrecomendacion` int(11) NOT NULL AUTO_INCREMENT,
  `tipoObjRecomendacion` varchar(255) DEFAULT NULL,
  `nomObjRecomendacion` varchar(255) DEFAULT NULL,
  `autorObjRecomendacion` varchar(255) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL,
  PRIMARY KEY (`idrecomendacion`,`persona_idpersona`),
  KEY `fk_recomendacion_persona1_idx` (`persona_idpersona`),
  CONSTRAINT `fk_recomendacion_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendacion`
--

LOCK TABLES `recomendacion` WRITE;
/*!40000 ALTER TABLE `recomendacion` DISABLE KEYS */;
INSERT INTO `recomendacion` VALUES (1,'Libro','El Principito','Antoine de Saint-Exupéry',3);
/*!40000 ALTER TABLE `recomendacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revista`
--

DROP TABLE IF EXISTS `revista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revista` (
  `idrevista` int(11) NOT NULL AUTO_INCREMENT,
  `codRevista` varchar(45) DEFAULT NULL,
  `tituloRevista` varchar(45) DEFAULT NULL,
  `edicionRevista` varchar(45) DEFAULT NULL,
  `numPagRevista` varchar(45) DEFAULT NULL,
  `genero_idgenero` int(11) NOT NULL,
  `precioPorDiaRevista` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrevista`,`genero_idgenero`),
  KEY `fk_revista_genero1_idx` (`genero_idgenero`),
  CONSTRAINT `fk_revista_genero1` FOREIGN KEY (`genero_idgenero`) REFERENCES `genero` (`idgenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revista`
--

LOCK TABLES `revista` WRITE;
/*!40000 ALTER TABLE `revista` DISABLE KEYS */;
/*!40000 ALTER TABLE `revista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-15 15:51:26
