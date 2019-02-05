CREATE DATABASE  IF NOT EXISTS `guidApp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `guidApp`;
-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: guidApp
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

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
-- Table structure for table `attractions`
--

DROP TABLE IF EXISTS `attractions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attractions` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `id_category` int(20) DEFAULT NULL,
  `id_creator` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attractions_1_idx` (`id_category`),
  KEY `fk_attractions_2_idx` (`id_creator`),
  CONSTRAINT `fk_attractions_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_attractions_2` FOREIGN KEY (`id_creator`) REFERENCES `users` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attractions`
--

LOCK TABLES `attractions` WRITE;
/*!40000 ALTER TABLE `attractions` DISABLE KEYS */;
/*!40000 ALTER TABLE `attractions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'musei'),(2,'natura'),(3,'architettura'),(4,'monumenti'),(5,'musica'),(6,'teatro'),(7,'arte'),(8,'cibo'),(9,'spettacolo'),(10,'artigianato'),(11,'danza'),(12,'fitness'),(13,'cinema'),(14,'giochi'),(15,'salute'),(16,'festa'),(17,'religione'),(18,'sport'),(19,'benessere'),(20,'cultura');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `place` varchar(256) DEFAULT NULL,
  `city` varchar(256) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `id_category` int(20) DEFAULT NULL,
  `id_creator` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_events_1_idx` (`id_category`),
  KEY `fk_events_2_idx` (`id_creator`),
  CONSTRAINT `fk_events_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_events_2` FOREIGN KEY (`id_creator`) REFERENCES `users` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (7,'titleee','placeee','cityyy','2001-10-26 20:32:52','2001-10-26 20:32:52',NULL,NULL,NULL),(8,'jam','pub','sora','2019-02-10 21:00:00','2019-02-11 02:00:00',NULL,NULL,NULL),(9,'prova','prova','prova','2019-01-21 20:00:00','2019-01-21 20:00:00',NULL,NULL,NULL),(10,'evento_prova','piazza','sq','2019-01-12 20:00:00','2019-01-12 22:00:00',NULL,5,NULL),(11,'evento_prova','piazza','sq','2019-01-12 20:00:00','2019-01-12 22:00:00',NULL,5,NULL),(13,'prova2','prova2','prova2','2018-01-22 21:00:00','2018-01-22 21:00:00',NULL,3,5),(14,'prova2','prova2','prova2','2018-01-22 21:00:00','2018-01-22 21:00:00','piazza la bomba',3,5);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `token` varchar(256) DEFAULT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (5,'2799454999896274886',5),(6,'6154333304184393978',4),(9,'642594339832426489',4),(10,'6278475066202992472',4),(11,'7986563104945070621',4),(12,'1284671219116027345',4),(13,'556817112607905499',4);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,'stefano','cortellessa','stefanocort94@gmail.com','ciao','stecort'),(5,'Davide','Iacobelli','davideiacobelli@gmail.com','scopodapazzi','iacobs'),(6,'luca','grillo','lucagrillo@gmail.com','ciao','cricri'),(7,'luca','grillo','lucagrillo@gmail.com','ciao','cricri'),(8,'davide','iacobelli','davideiacobs@gmail.com','ameche','davideiacobs');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'guidApp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-05 16:04:59
