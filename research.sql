-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: research
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `research`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `research` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `research`;

--
-- Table structure for table `citation`
--

DROP TABLE IF EXISTS `citation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `citation` (
  `REFID` int(5) NOT NULL AUTO_INCREMENT,
  `SRCID` int(5) NOT NULL,
  `DATEFOUND` date DEFAULT NULL,
  `REFBODY` varchar(500) NOT NULL,
  `LOCDETAIL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`REFID`),
  KEY `SRCID` (`SRCID`),
  CONSTRAINT `citation_ibfk_1` FOREIGN KEY (`SRCID`) REFERENCES `sources` (`srcid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citation`
--

LOCK TABLES `citation` WRITE;
/*!40000 ALTER TABLE `citation` DISABLE KEYS */;
INSERT INTO `citation` VALUES (1,1,'2019-02-22','Renewing Scriptural','p 151'),(2,1,'2019-02-26','Generating Civilization','p 151'),(3,2,'2019-02-25','American Scholars','p 8'),(4,3,'2019-02-24','Compares events to prophetic passages','book topic'),(5,3,'2019-02-27','book topic: historical event interpreted as fulfilled prophecy passages from the bible','Jeffery\'s library'),(6,3,'2019-02-27','topic: hitorical events as fulfilled prophecies','Jeffery\'s library'),(7,1,'2019-02-27','\"History will be viewed in the study as a drama in which  religion plays the most significant role\"','p 37'),(12,3,'2019-02-26','Thief dummy entry','somewhere'),(13,3,'2019-02-26','Thief dummy entry','somewhere'),(17,10,'2019-02-27','dummy reference','p 101'),(20,13,'2019-02-26','Dummy citation','p 101');
/*!40000 ALTER TABLE `citation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sources`
--

DROP TABLE IF EXISTS `sources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sources` (
  `SRCID` int(5) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) NOT NULL,
  `AUTHOR` varchar(50) NOT NULL,
  `PUBLICATION` varchar(50) NOT NULL,
  `SRCLOC` varchar(50) NOT NULL,
  PRIMARY KEY (`SRCID`),
  UNIQUE KEY `TITLE` (`TITLE`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sources`
--

LOCK TABLES `sources` WRITE;
/*!40000 ALTER TABLE `sources` DISABLE KEYS */;
INSERT INTO `sources` VALUES (1,'Founders of Faith','Harold Rosen','Palabra Publications','Jeffery\'s library'),(2,'The Varieties of Religious Experience','William James','---','Personal Google Play Books'),(3,'Thief in the Night','William Sears','','Jeffery\'s library'),(5,'The Joy that is Sweetest','staff','American Baha\'i','p. 16, vol 39 num 6'),(7,'Sweet Neighbors Come in All Colors','Lisa Blecker','Bellwood Press','Baha\'i Book Store'),(10,'More Than Two Colors','Andrea Hope','Brilliant Star','Jeffery\'s library'),(11,'Uprooting Racism','editorial staff','Brilliant Star Vol. 49 No. 1','Jeffery\'s library'),(13,'The Electric Meme','Robert Aunger','','personal library');
/*!40000 ALTER TABLE `sources` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-28 11:24:50
