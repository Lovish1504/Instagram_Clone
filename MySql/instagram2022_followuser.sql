-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: instagram2022
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `followuser`
--

DROP TABLE IF EXISTS `followuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `followuser` (
  `followerid` int NOT NULL AUTO_INCREMENT,
  `followby` varchar(45) DEFAULT NULL,
  `followto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`followerid`),
  KEY `fk_username_idx` (`followby`),
  KEY `fk_user_idx` (`followto`),
  CONSTRAINT `fk_user` FOREIGN KEY (`followto`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_username` FOREIGN KEY (`followby`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followuser`
--

LOCK TABLES `followuser` WRITE;
/*!40000 ALTER TABLE `followuser` DISABLE KEYS */;
INSERT INTO `followuser` VALUES (13,NULL,NULL),(14,NULL,NULL),(16,'Anjali','aakansh'),(17,'Anjali','aardhya'),(18,'aardhya','aakansh'),(19,'aardhya','Anjali'),(21,'aakansh','Anjali'),(22,'aakansh','aardhya'),(24,NULL,NULL),(25,'lovish','Anjali'),(28,NULL,NULL),(29,NULL,NULL),(30,NULL,NULL),(31,NULL,NULL),(32,NULL,NULL),(33,NULL,NULL),(34,NULL,NULL),(35,'shannon','aakansh'),(36,'shannon','aardhya'),(37,'shannon','Anjali'),(41,'lovish','aardhya'),(42,'lovish','aakansh'),(43,'lovish','shannon'),(44,'anjali','lovish'),(45,'anjali','shannon'),(46,'n','lovish'),(47,'n','aakansh'),(48,'n','aardhya'),(49,'n','Anjali'),(50,'prizam','lovish'),(51,'prizam','aakansh'),(52,'prizam','aardhya'),(53,'prizam','Anjali');
/*!40000 ALTER TABLE `followuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-22 12:24:23
