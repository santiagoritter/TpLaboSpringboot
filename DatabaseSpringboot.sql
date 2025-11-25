-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdd_paginaweb
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adopcion`
--

DROP TABLE IF EXISTS `adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adopcion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_mascota` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopcion`
--

LOCK TABLES `adopcion` WRITE;
/*!40000 ALTER TABLE `adopcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `adopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alertas_stock`
--

DROP TABLE IF EXISTS `alertas_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alertas_stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_alerta` datetime(6) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  `tipo_vacuna` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alertas_stock`
--

LOCK TABLES `alertas_stock` WRITE;
/*!40000 ALTER TABLE `alertas_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `alertas_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `id` int NOT NULL,
  `id_usuario` int DEFAULT NULL,
  `monto_total` int DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrito_has_producto`
--

DROP TABLE IF EXISTS `carrito_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito_has_producto` (
  `id_Carrito` int DEFAULT NULL,
  `id_Producto` int DEFAULT NULL,
  KEY `id_Carrito` (`id_Carrito`),
  KEY `id_Producto` (`id_Producto`),
  CONSTRAINT `carrito_has_producto_ibfk_1` FOREIGN KEY (`id_Carrito`) REFERENCES `carrito` (`id`),
  CONSTRAINT `carrito_has_producto_ibfk_2` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_has_producto`
--

LOCK TABLES `carrito_has_producto` WRITE;
/*!40000 ALTER TABLE `carrito_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invitacion`
--

DROP TABLE IF EXISTS `invitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invitacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `email_invitado` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `id_invitado` int DEFAULT NULL,
  `id_invitante` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invitacion`
--

LOCK TABLES `invitacion` WRITE;
/*!40000 ALTER TABLE `invitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `invitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `id` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `id_Duenio` int DEFAULT NULL,
  `id_Tipo` int DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `raza` varchar(255) DEFAULT NULL,
  `visitas` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Duenio` (`id_Duenio`),
  KEY `id_Tipo` (`id_Tipo`),
  CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`id_Duenio`) REFERENCES `usuario` (`id`),
  CONSTRAINT `mascota_ibfk_2` FOREIGN KEY (`id_Tipo`) REFERENCES `tipo_mascota` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (1,'Michi',3,1,2,5,'Siames',50),(2,'Firulais',5,NULL,1,15,'Labrador',10),(3,'Piolín',1,3,3,0,'Canario',5),(10,'Rocky',5,1,1,20,'Bulldog',500),(11,'Lola',3,1,2,5,'Siames',350),(12,'Toby',2,1,1,10,'Caniche',200),(13,'Simba',4,1,2,8,'Persa',150);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` int NOT NULL,
  `fecha_llegada` date DEFAULT NULL,
  `fecha_salida` date DEFAULT NULL,
  `id_Carrito` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Carrito` (`id_Carrito`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_Carrito`) REFERENCES `carrito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL,
  `precio` int DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descuento` tinyint(1) DEFAULT NULL,
  `mascota_que_lo_consume` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mascota_que_lo_consume` (`mascota_que_lo_consume`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`mascota_que_lo_consume`) REFERENCES `tipo_mascota` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (2,12500,'Juguete resistente .','Juguete Hueso Goma','Juguetes',0,1),(3,45000,'Cama lavable de 100e.','Cama Moises Premium','Accesorios',1,1),(4,60500,'Nutrición espec','Alimento Gato Urinary','Excellent',0,2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profecional`
--

DROP TABLE IF EXISTS `profecional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profecional` (
  `id` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `anios_experencia` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profecional`
--

LOCK TABLES `profecional` WRITE;
/*!40000 ALTER TABLE `profecional` DISABLE KEYS */;
INSERT INTO `profecional` VALUES (1,'Dr. House','Veterinario','Cirujano',15),(2,'Dr. Strange','Vet','General',10),(3,'Dra. Ana','Medica','Especialista Aves',5);
/*!40000 ALTER TABLE `profecional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_mascota`
--

DROP TABLE IF EXISTS `tipo_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_mascota` (
  `id` int NOT NULL,
  `nombre_tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_mascota`
--

LOCK TABLES `tipo_mascota` WRITE;
/*!40000 ALTER TABLE `tipo_mascota` DISABLE KEYS */;
INSERT INTO `tipo_mascota` VALUES (1,'Perro'),(2,'Gato'),(3,'Ave');
/*!40000 ALTER TABLE `tipo_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_Usuario` int DEFAULT NULL,
  `id_Mascota` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_Profecional` int DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_Vacunas` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Vacunas` (`id_Vacunas`),
  KEY `id_Profecional` (`id_Profecional`),
  KEY `id_Usuario` (`id_Usuario`),
  KEY `id_Mascota` (`id_Mascota`),
  CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`id_Vacunas`) REFERENCES `vacunas` (`id`),
  CONSTRAINT `turno_ibfk_2` FOREIGN KEY (`id_Profecional`) REFERENCES `profecional` (`id`),
  CONSTRAINT `turno_ibfk_3` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `turno_ibfk_4` FOREIGN KEY (`id_Mascota`) REFERENCES `mascota` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,3,3,'2026-03-15',3,'Consulta especializada para ave',NULL);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juan','Perez','juan.perez@mail.com','root',30),(2,'Maria','Gomez','maria.gomez@mail.com','root',25),(3,'Pedro','Adopta','pedro.adopta@mail.com','root',45);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacuna_stock`
--

DROP TABLE IF EXISTS `vacuna_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacuna_stock` (
  `tipo` varchar(45) NOT NULL,
  `duracion_meses` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `stock_minimo` int DEFAULT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacuna_stock`
--

LOCK TABLES `vacuna_stock` WRITE;
/*!40000 ALTER TABLE `vacuna_stock` DISABLE KEYS */;
INSERT INTO `vacuna_stock` VALUES ('Antirrabica',12,10,3),('Gripe Aviar',12,5,1),('Quintuple',6,1,5);
/*!40000 ALTER TABLE `vacuna_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacunas`
--

DROP TABLE IF EXISTS `vacunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacunas` (
  `id` int NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `id_Mascota` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Mascota` (`id_Mascota`),
  CONSTRAINT `vacunas_ibfk_1` FOREIGN KEY (`id_Mascota`) REFERENCES `mascota` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacunas`
--

LOCK TABLES `vacunas` WRITE;
/*!40000 ALTER TABLE `vacunas` DISABLE KEYS */;
INSERT INTO `vacunas` VALUES (10,'Antirrabica','2026-10-01',1),(30,'Gripe Aviar','2026-10-01',3);
/*!40000 ALTER TABLE `vacunas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-24 23:10:49
