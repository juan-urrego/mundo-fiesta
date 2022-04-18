-- MySQL dump 10.13  Distrib 5.6.50, for Linux (x86_64)
--
-- Host: localhost    Database: heroku_0326fe9c4e696ac
-- ------------------------------------------------------
-- Server version	5.6.50-log

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
-- Table structure for table `caracteristicas`
--

DROP TABLE IF EXISTS `caracteristicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicas` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_color` varchar(50) NOT NULL,
  `car_dimension` varchar(20) NOT NULL,
  `car_personaje_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `FKjgf6ncci9eae65lhadyal1fqx` (`car_personaje_id`),
  CONSTRAINT `FKjgf6ncci9eae65lhadyal1fqx` FOREIGN KEY (`car_personaje_id`) REFERENCES `personajes` (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=805 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicas`
--

LOCK TABLES `caracteristicas` WRITE;
/*!40000 ALTER TABLE `caracteristicas` DISABLE KEYS */;
INSERT INTO `caracteristicas` VALUES (4,'plata','pequeño',108),(14,'plata','pequeño',108),(24,'plata','pequeño',108),(34,'plata','pequeño',108),(44,'plata','pequeño',108),(54,'plata','pequeño',108),(64,'plata','pequeño',108),(74,'plata','pequeño',108),(84,'plata','pequeño',108),(94,'plata','pequeño',108),(104,'fucsia','mediano',108),(114,'fucsia','mediano',108),(124,'fucsia','mediano',108),(134,'fucsia','mediano',108),(144,'fucsia','mediano',108),(154,'fucsia','mediano',108),(164,'fucsia','mediano',108),(174,'fucsia','mediano',108),(184,'fucsia','mediano',108),(194,'fucsia','mediano',108),(204,'fucsia','mediano',108),(214,'azul','grande',108),(224,'azul','grande',108),(234,'azul','grande',108),(244,'azul','grande',108),(254,'azul','grande',108),(264,'azul','grande',108),(274,'azul','grande',108),(284,'azul','grande',108),(294,'azul','grande',108),(304,'azul','grande',108),(314,'azul','grande',108),(324,'azul','grande',108),(334,'dorado','15 años',108),(344,'fucsia','15 años',108),(354,'azul clarito','15 años',108),(364,'dorado','15 años',108),(374,'dorado','50 años',108),(384,'lila','50 años',108),(394,'negro','50 años',108),(404,'rojo','50 años',108),(414,'no aplica','no aplica',5),(424,'no aplica','no aplica',6),(434,'no aplica','no aplica',20),(444,'no aplica','no aplica',30),(454,'no aplica','no aplica',108),(464,'no aplica','no aplica',108),(474,'no aplica','no aplica',108),(484,'no aplica','no aplica',108),(494,'no aplica','no aplica',108),(504,'no aplica','no aplica',108),(514,'no aplica','no aplica',108),(524,'no aplica','no aplica',108),(534,'no aplica','no aplica',108),(544,'no aplica','no aplica',108),(554,'no aplica','no aplica',108),(564,'no aplica','no aplica',108),(574,'no aplica','no aplica',108),(584,'no aplica','no aplica',108),(594,'no aplica','no aplica',108),(604,'no aplica','no aplica',108),(614,'no aplica','no aplica',108),(624,'no aplica','no aplica',108),(634,'no aplica','no aplica',108),(644,'no aplica','no aplica',108),(654,'no aplica','grande',108),(664,'no aplica','mediano',108),(674,'no aplica','pequeño',108),(684,'no aplica','pequeño',108),(694,'no aplica','mediano',108),(704,'no aplica','grande',108),(714,'no aplica','grande',108),(724,'no aplica','mediana',108),(734,'no aplica','pequeña',108),(744,'no aplica','pequeña',108),(754,'no aplica','pequeña',108),(764,'no aplica','grande',108),(774,'no aplica','no aplica',108),(784,'no aplica','no aplica',108),(794,'no aplica','mediana',108),(804,'no aplica','mediana',108);
/*!40000 ALTER TABLE `caracteristicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (4,'Cumpleaños'),(14,'Baby shower'),(24,'Despedida'),(34,'Anchetas'),(44,'Rellenos'),(54,'Cajas y empaques'),(64,'Otros');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles`
--

DROP TABLE IF EXISTS `detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalles` (
  `det_id` int(11) NOT NULL AUTO_INCREMENT,
  `det_categoria_id` int(11) NOT NULL,
  `det_tipo_producto_id` int(11) NOT NULL,
  PRIMARY KEY (`det_id`),
  KEY `FKckras7k9ctq3vv17jrld4wg4p` (`det_categoria_id`),
  KEY `FKtnqrcl0ymp25ls1ak73oesuvt` (`det_tipo_producto_id`),
  CONSTRAINT `FKckras7k9ctq3vv17jrld4wg4p` FOREIGN KEY (`det_categoria_id`) REFERENCES `categorias` (`cat_id`),
  CONSTRAINT `FKtnqrcl0ymp25ls1ak73oesuvt` FOREIGN KEY (`det_tipo_producto_id`) REFERENCES `tipos_productos` (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=805 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles`
--

LOCK TABLES `detalles` WRITE;
/*!40000 ALTER TABLE `detalles` DISABLE KEYS */;
INSERT INTO `detalles` VALUES (4,4,1),(14,4,1),(24,4,1),(34,4,1),(44,4,1),(54,4,1),(64,4,1),(74,4,1),(84,4,1),(94,4,1),(104,4,1),(114,4,1),(124,4,1),(134,4,1),(144,4,1),(154,4,1),(164,4,1),(174,4,1),(184,4,1),(194,4,1),(204,4,1),(214,4,1),(224,4,1),(234,4,1),(244,4,1),(254,4,1),(264,4,1),(274,4,1),(284,4,1),(294,4,1),(304,4,1),(314,4,1),(324,4,1),(334,4,1),(344,4,1),(354,4,1),(364,4,1),(374,4,1),(384,4,1),(394,4,1),(404,4,1),(414,4,1),(424,4,1),(434,4,1),(444,4,1),(454,4,2),(464,4,2),(474,4,2),(484,4,2),(494,4,2),(504,14,3),(514,14,3),(524,14,3),(534,14,9),(544,14,9),(554,14,6),(564,14,6),(574,4,6),(584,4,6),(594,4,8),(604,14,8),(614,24,3),(624,34,5),(634,34,5),(644,34,5),(654,44,7),(664,44,7),(674,44,7),(684,34,11),(694,34,11),(704,34,11),(714,54,11),(724,54,11),(734,54,11),(744,54,4),(754,54,4),(764,54,4),(774,54,4),(784,54,4),(794,54,4),(804,54,4);
/*!40000 ALTER TABLE `detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenes`
--

DROP TABLE IF EXISTS `imagenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagenes` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_cloud_id` varchar(255) NOT NULL,
  `img_url` varchar(255) NOT NULL,
  `img_nombre` varchar(50) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`img_id`),
  KEY `FKg3s2t79c6lgrwbk29wvqscjyj` (`categoria_id`),
  CONSTRAINT `FKg3s2t79c6lgrwbk29wvqscjyj` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes`
--

LOCK TABLES `imagenes` WRITE;
/*!40000 ALTER TABLE `imagenes` DISABLE KEYS */;
INSERT INTO `imagenes` VALUES (4,'ypnbhneu5kuas0ynj0zd','http://res.cloudinary.com/universidad-de-antioquia/image/upload/v1646086581/ypnbhneu5kuas0ynj0zd.png','serpentinas1',4);
/*!40000 ALTER TABLE `imagenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `ped_id` int(11) NOT NULL AUTO_INCREMENT,
  `ped_date_stamp` varchar(255) NOT NULL,
  `ped_domicilio` bit(1) NOT NULL,
  `fk_ped_usr_id` int(11) NOT NULL,
  PRIMARY KEY (`ped_id`),
  KEY `FK1xtlbpiv9gel7ujulajx2ceto` (`fk_ped_usr_id`),
  CONSTRAINT `FK1xtlbpiv9gel7ujulajx2ceto` FOREIGN KEY (`fk_ped_usr_id`) REFERENCES `usuarios` (`usr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=505 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (74,'1/3/2022 5:05:611','',4),(84,'1/3/2022 5:05:611','',4),(94,'1/3/2022 5:05:611','',4),(104,'1/3/2022 5:05:611','',4),(114,'1/3/2022 5:05:611','',4),(124,'1/3/2022 5:05:611','',4),(134,'1/3/2022 5:05:611','',4),(144,'1/3/2022 5:05:611','',4),(154,'1/3/2022 5:05:611','',4),(164,'1/3/2022 5:05:611','',4),(174,'1/3/2022 5:05:611','',4),(184,'1/3/2022 5:05:611','',4),(194,'1/3/2022 5:05:611','',4),(204,'1/3/2022 5:05:611','',4),(214,'1/3/2022 5:05:611','',4),(224,'1/3/2022 5:05:611','',4),(234,'1/3/2022 5:05:611','',4),(244,'1/3/2022 5:05:611','',4),(254,'1/3/2022 5:05:611','',4),(264,'1/3/2022 5:05:611','',4),(274,'1/3/2022 5:05:611','',4),(284,'1/3/2022 5:05:611','',4),(294,'1/3/2022 5:05:611','',4),(304,'1/3/2022 5:05:611','',4),(314,'1/3/2022 5:05:611','',4),(324,'1/3/2022 5:05:611','',4),(334,'1/3/2022 5:05:611','',4),(344,'1/3/2022 5:05:611','',4),(354,'1/3/2022 5:05:611','',4),(364,'1/3/2022 5:05:611','',4),(374,'1/3/2022 5:05:611','',4),(384,'1/3/2022 5:05:611','',4),(394,'1/3/2022 5:05:611','',4),(404,'1/3/2022 5:05:611','',4),(414,'1/3/2022 5:05:611','',4),(424,'1/3/2022 5:05:611','',4),(434,'1/3/2022 5:05:611','',4),(444,'1/3/2022 5:05:611','',4),(454,'1/3/2022 5:05:611','',4),(464,'1/3/2022 5:05:611','',4),(474,'1/3/2022 5:05:611','',4),(484,'1/3/2022 5:05:611','',4),(494,'1/3/2022 5:05:611','',4),(504,'1/3/2022 5:05:611','',4);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personajes` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (5,'PRINCESAS'),(6,'SOFIA'),(7,'FROZEN'),(8,'MOHANA'),(9,'BARBIE'),(10,'MINNIE'),(11,'LOL'),(12,'PEPA'),(13,'DR JUGUETES'),(14,'UNICORNIO'),(15,'COLA SIRENA'),(16,'SIRENA'),(17,'SKY'),(18,'LLUVIA DE AMOR'),(19,'MUJER MARAVILLA'),(20,'FLAMENCO'),(21,'TIK TOK'),(22,'FLAMENCO'),(23,'CORAZON'),(24,'MARIO'),(25,'DINOSAURIO'),(26,'DRAGON BALL'),(27,'BALON'),(28,'SPACE JAM'),(29,'GAME ON'),(30,'CAPITAN AMERICA'),(31,'BATMAN'),(32,'SUPER MAN'),(33,'HOMBRE ARAÑA'),(34,'SELVA'),(35,'GRANJA'),(36,'PATRULLA NIÑO'),(37,'PJ MASK'),(38,'DR JUGUETES'),(39,'BOB ESPONJA'),(40,'MICKEY'),(41,'MINNIONS'),(42,'FORNITE'),(43,'SONIC'),(44,'CARS'),(45,'JORGE'),(46,'VENGADORES'),(47,'TOY STORY'),(48,'AMONGUS'),(49,'MEDELLIN'),(50,'CALI'),(51,'PASTO'),(52,'AMERICA DE CALI'),(53,'MILLONARIOS'),(54,'NACIONAL'),(55,'JUNIOR'),(56,'PRINCESAS'),(57,'SOFIA'),(58,'FROZEN'),(59,'MOHANA'),(60,'BARBIE'),(61,'MINNIE'),(62,'LOL'),(63,'PEPA'),(64,'DR JUGUETES'),(65,'UNICORNIO'),(66,'COLA SIRENA'),(67,'SIRENA'),(68,'SKY'),(69,'LLUVIA DE AMOR'),(70,'MUJER MARAVILLA'),(71,'FLAMENCO'),(72,'TIK TOK'),(73,'FLAMENCO'),(74,'CORAZON'),(75,'MARIO'),(76,'DINOSAURIO'),(77,'DRAGON BALL'),(78,'BALON'),(79,'SPACE JAM'),(80,'GAME ON'),(81,'CAPITAN AMERICA'),(82,'BATMAN'),(83,'SUPER MAN'),(84,'HOMBRE ARAÑA'),(85,'SELVA'),(86,'GRANJA'),(87,'PATRULLA NIÑO'),(88,'PJ MASK'),(89,'DR JUGUETES'),(90,'BOB ESPONJA'),(91,'MICKEY'),(92,'MINNIONS'),(93,'FORNITE'),(94,'SONIC'),(95,'CARS'),(96,'JORGE'),(97,'VENGADORES'),(98,'TOY STORY'),(99,'AMONGUS'),(100,'MEDELLIN'),(101,'CALI'),(102,'PASTO'),(103,'AMERICA DE CALI'),(104,'MILLONARIOS'),(105,'NACIONAL'),(106,'JUNIOR'),(108,'NO APLICA');
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_descripcion` varchar(255) NOT NULL,
  `pro_nombre` varchar(255) NOT NULL,
  `pro_precio` double NOT NULL,
  `pro_caracteristica_id` int(11) DEFAULT NULL,
  `pro_detalle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FKac2rnu1lhh03lwc7lvia04hpd` (`pro_caracteristica_id`),
  KEY `FKj79s90xokg8sbr68kyv9xhngn` (`pro_detalle_id`),
  CONSTRAINT `FKac2rnu1lhh03lwc7lvia04hpd` FOREIGN KEY (`pro_caracteristica_id`) REFERENCES `caracteristicas` (`car_id`),
  CONSTRAINT `FKj79s90xokg8sbr68kyv9xhngn` FOREIGN KEY (`pro_detalle_id`) REFERENCES `detalles` (`det_id`)
) ENGINE=InnoDB AUTO_INCREMENT=805 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (4,'asdududdududududu','#1',500,4,4),(14,'asdududdududududu','#2',500,14,14),(24,'asdududdududududu','#3',500,24,24),(34,'asdududdududududu','#4',500,34,34),(44,'asdududdududududu','#5',500,44,44),(54,'asdududdududududu','#6',500,54,54),(64,'asdududdududududu','#7',500,64,64),(74,'asdududdududududu','#8',500,74,74),(84,'asdududdududududu','#9',500,84,84),(94,'asdududdududududu','?',500,94,94),(104,'asdududdududududu','#0',500,104,104),(114,'asdududdududududu','#1',500,114,114),(124,'asdududdududududu','#2',500,124,124),(134,'asdududdududududu','#3',500,134,134),(144,'asdududdududududu','#4',500,144,144),(154,'asdududdududududu','#5',500,154,154),(164,'asdududdududududu','#6',500,164,164),(174,'asdududdududududu','#7',500,174,174),(184,'asdududdududududu','#8',500,184,184),(194,'asdududdududududu','#9',500,194,194),(204,'asdududdududududu','?',500,204,204),(214,'asdududdududududu','?',500,214,214),(224,'asdududdududududu','0',500,224,224),(234,'asdududdududududu','1',500,234,234),(244,'asdududdududududu','2',500,244,244),(254,'asdududdududududu','3',500,254,254),(264,'asdududdududududu','4',500,264,264),(274,'asdududdududududu','5',500,274,274),(284,'asdududdududududu','6',500,284,284),(294,'asdududdududududu','7',500,294,294),(304,'asdududdududududu','8',500,304,304),(314,'asdududdududududu','9',500,314,314),(324,'asdududdududududu','0',500,324,324),(334,'asdududdududududu','0',900,334,334),(344,'asdududdududududu','0',900,344,344),(354,'asdududdududududu','0',900,354,354),(364,'asdududdududududu','0',900,364,364),(374,'asdududdududududu','0',900,374,374),(384,'asdududdududududu','0',900,384,384),(394,'asdududdududududu','0',900,394,394),(404,'asdududdududududu','0',900,404,404),(414,'asdududdududududu','vela pesonaje',1000,414,414),(424,'asdududdududududu','vela pesonaje',1000,424,424),(434,'asdududdududududu','vela pesonaje',1000,434,434),(444,'asdududdududududu','vela pesonaje',1000,444,444),(454,'asdududdududududu','1',1200,454,454),(464,'asdududdududududu','104',1200,464,464),(474,'asdududdududududu','37',1200,474,474),(484,'asdududdududududu','59',1200,484,484),(494,'asdududdududududu','91',1200,494,494),(504,'asdududdududududu','mamá niño',1500,504,504),(514,'asdududdududududu','cumple dorado',1500,514,514),(524,'asdududdududududu','cumple multicolor',1500,524,524),(534,'asdududdududududu','papá niño',1500,534,534),(544,'asdududdududududu','papá niña',1500,544,544),(554,'asdududdududududu','niño',1500,554,554),(564,'asdududdududududu','niña',1500,564,564),(574,'asdududdududududu','cumple plata',1500,574,574),(584,'asdududdududududu','cumple dorado',1500,584,584),(594,'asdududdududududu','topper cumpleaños',1500,594,594),(604,'asdududdududududu','topper baby shower',1500,604,604),(614,'asdududdududududu','kit novia',1500,614,614),(624,'asdududdududududu','cumpleaños x12',1500,624,624),(634,'asdududdududududu','feliz dia x12',1500,634,634),(644,'asdududdududududu','amor x12',1500,644,644),(654,'asdududdududududu','relleno grande',1500,654,654),(664,'asdududdududududu','relleno mediano',1500,664,664),(674,'asdududdududududu','relleno pequeño',1500,674,674),(684,'asdududdududududu','base ancheta cumpleaños',1500,684,684),(694,'asdududdududududu','base ancheta cumpleaños',1500,694,694),(704,'asdududdududududu','base ancheta cumpleaños',1500,704,704),(714,'asdududdududududu','base ancheta cumpleaños',1500,714,714),(724,'asdududdududududu','base ancheta cumpleaños',1500,724,724),(734,'asdududdududududu','base ancheta cumpleaños',1500,734,734),(744,'asdududdududududu','caja kraft',1500,744,744),(754,'asdududdududududu','craft impresa amor ref1',1500,754,754),(764,'asdududdududududu','craft impresa ref 7 estrellas',1500,764,764),(774,'asdududdududududu','candy alargada craft',2000,774,774),(784,'asdududdududududu','candy book viejitos',2000,784,784),(794,'asdududdududududu','impresa ref1 sonrie',2000,794,794),(804,'asdududdududududu','impresa ref4 cactus',2000,804,804);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_pedidos`
--

DROP TABLE IF EXISTS `productos_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos_pedidos` (
  `pro_ped_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_ped_cantidad` int(11) NOT NULL,
  `pro_ped_producto_id` int(11) NOT NULL,
  `pro_ped_pedido_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pro_ped_id`),
  KEY `FKp10p0cy8yw8ugm2g70y9m28ys` (`pro_ped_producto_id`),
  KEY `FK11sfxp799ekm9myl94udy6w7f` (`pro_ped_pedido_id`),
  CONSTRAINT `FK11sfxp799ekm9myl94udy6w7f` FOREIGN KEY (`pro_ped_pedido_id`) REFERENCES `pedidos` (`ped_id`),
  CONSTRAINT `FKp10p0cy8yw8ugm2g70y9m28ys` FOREIGN KEY (`pro_ped_producto_id`) REFERENCES `productos` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=525 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_pedidos`
--

LOCK TABLES `productos_pedidos` WRITE;
/*!40000 ALTER TABLE `productos_pedidos` DISABLE KEYS */;
INSERT INTO `productos_pedidos` VALUES (94,100,4,74),(104,100,4,84),(114,100,4,94),(124,69,14,104),(134,69,14,114),(144,69,14,124),(154,69,14,134),(164,69,14,144),(174,69,14,154),(184,69,14,164),(194,69,14,174),(204,69,14,184),(214,69,14,194),(224,69,14,204),(234,69,14,214),(244,69,14,224),(254,69,14,234),(264,69,14,244),(274,69,14,254),(284,69,14,264),(294,69,14,274),(304,69,14,284),(314,69,14,294),(324,69,14,304),(334,69,14,314),(344,69,14,324),(354,69,14,334),(364,69,14,344),(374,69,14,354),(384,69,14,364),(394,69,14,374),(404,69,14,384),(414,69,14,394),(424,69,14,404),(434,69,14,414),(444,69,14,424),(454,69,14,434),(464,69,14,444),(474,69,14,454),(484,69,14,464),(494,69,14,474),(504,69,14,484),(514,69,14,494),(524,100,4,504);
/*!40000 ALTER TABLE `productos_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `rol_id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`rol_id`),
  UNIQUE KEY `UK_rn4x84cv8llunnoky04okfkci` (`rol_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (4,'ROLE_ADMIN'),(14,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_productos`
--

DROP TABLE IF EXISTS `tipos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_productos` (
  `tipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`tipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_productos`
--

LOCK TABLES `tipos_productos` WRITE;
/*!40000 ALTER TABLE `tipos_productos` DISABLE KEYS */;
INSERT INTO `tipos_productos` VALUES (1,'Velas'),(2,'Serpentina'),(3,'Kit'),(4,'Caja'),(5,'Pics'),(6,'Tiara'),(7,'Relleno'),(8,'Topper'),(9,'Liston'),(11,'Empaque'),(12,'Bolsas');
/*!40000 ALTER TABLE `tipos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_roles`
--

DROP TABLE IF EXISTS `usuario_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_roles` (
  `usr_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`usr_id`,`rol_id`),
  KEY `FKbt9i9yrb9ug88xnh82n9m60pr` (`rol_id`),
  CONSTRAINT `FK6dw5cuptxmmae97edgy9mv29y` FOREIGN KEY (`usr_id`) REFERENCES `usuarios` (`usr_id`),
  CONSTRAINT `FKbt9i9yrb9ug88xnh82n9m60pr` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_roles`
--

LOCK TABLES `usuario_roles` WRITE;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
INSERT INTO `usuario_roles` VALUES (4,4);
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `usr_id` int(11) NOT NULL AUTO_INCREMENT,
  `usr_direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `usr_identificacion` int(11) NOT NULL,
  `usr_nombre` varchar(255) NOT NULL,
  `usr_telefono` int(11) NOT NULL,
  `usr_tipo_cliente` varchar(20) DEFAULT NULL,
  `usr_tipo_identificacion` varchar(2) NOT NULL,
  `usr_password` varchar(255) NOT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UK_civx477i2t4g2b865hfqfsi8s` (`usr_identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (4,'direccion','admin',999999999,'admin',123,'admin','cc','$2a$10$Dia9Bn/WvmmCnVVxXFnVyuMZIjDNAgUzS.IR7ntpdIFgpKlV3XQDG');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'heroku_0326fe9c4e696ac'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-17 23:53:54
