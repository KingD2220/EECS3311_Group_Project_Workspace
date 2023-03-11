CREATE DATABASE  IF NOT EXISTS `domain_objects` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `domain_objects`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: domain_objects
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `userName` varchar(30) NOT NULL,
  `hashPassWord` varchar(30) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('Admin','�gB��\\v��U�g�6#ȳ��E��x��F�'),('you','�gB��\\v��U�g�6#ȳ��E��x��F�');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `last_name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone_num` varchar(30) NOT NULL,
  `credit_card` varchar(30) NOT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  KEY `phone_num` (`phone_num`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`phone_num`) REFERENCES `reservation` (`phone_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Jackson','Micheal','22 JacksonVille','1237098564','1209456348234563',1),('Noah','Trevor','22 JacksonVille','5557088564','5209456340027457',2),('Gomez','Joe','35 Glenhaven','9950268564','9109456348022457',3),('Diaz','Trisha','207 Marley Cres','6470228856','6417456738070457',4),('De Bryune','Kevin','99 Manchester av','4160938852','7827456998070423',5),('Harvey','Terry','16 NewCastle st','4160158156','9264400178070423',6),('Austin','Steve','78 Keele st','5550168180','1940981178070482',7),('Jordan','Steve','65 Tork st','5190457187','7743911892070485',8);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `last_name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone_num` varchar(30) NOT NULL,
  PRIMARY KEY (`phone_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `arrival_date` varchar(30) NOT NULL,
  `departure_date` varchar(30) NOT NULL,
  `resNum` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone_num` varchar(30) NOT NULL,
  `credit_card` varchar(30) NOT NULL,
  PRIMARY KEY (`resNum`),
  UNIQUE KEY `phone_num` (`phone_num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('23-03-14','23-03-29',1,'Jackson','Micheal','22 JacksonVille','1237098564','1209456348234563'),('23-04-11','23-04-26',2,'Noah','Trevor','22 JacksonVille','5557088564','5209456340027457'),('23-03-20','23-03-31',3,'Gomez','Joe','35 Glenhaven','9950268564','9109456348022457'),('23-03-22','23-03-30',4,'Diaz','Trisha','207 Marley Cres','6470228856','6417456738070457'),('23-05-30','23-06-07',5,'De Bryune','Kevin','99 Manchester av','4160938852','7827456998070423'),('23-04-17','23-04-26',6,'Harvey','Terry','16 NewCastle st','4160158156','9264400178070423'),('23-03-21','23-03-31',7,'Austin','Steve','78 Keele st','5550168180','1940981178070482'),('23-07-11','23-07-19',8,'Jordan','Steve','65 Tork st','5190457187','7743911892070485');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `roomType` varchar(30) NOT NULL,
  `bedType` varchar(30) NOT NULL,
  `numberOfBeds` int NOT NULL,
  `occupancy` int NOT NULL,
  `roomSize` int NOT NULL,
  `fixedRatePerNight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-10 10:28:56
