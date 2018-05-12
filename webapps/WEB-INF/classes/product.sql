-- MySQL dump 10.13  Distrib 5.5.25, for Win32 (x86)
--
-- Host: localhost    Database: jdbcdemo
-- ------------------------------------------------------
-- Server version	5.5.25

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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'admin','12345');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) DEFAULT NULL,
  `dir_id` bigint(11) DEFAULT NULL,
  `salePrice` decimal(10,2) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `cutoff` double(2,2) DEFAULT NULL,
  `costPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dir_id` (`dir_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`dir_id`) REFERENCES `productdir` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'罗技M100',2,490.00,'罗技','罗技',0.90,30.00),(3,'罗技M115',2,99.00,'罗技','罗技',0.60,38.00),(4,'罗技M125',3,80.00,'罗技','罗技',0.90,39.00),(5,'罗技木星轨迹球',3,182.00,'罗技','罗技',0.80,80.00),(6,'罗技火星轨迹球',3,349.00,'罗技','罗技',0.87,290.00),(7,'罗技G9X',3,680.00,'罗技','罗技',0.70,470.00),(8,'罗技M215',2,89.00,'罗技','罗技',0.79,30.00),(10,'罗技M4a1',2,200.00,'联想','方正',0.60,99.00),(11,'罗技M505',2,148.00,'罗技','罗技',0.92,72.00),(12,'罗技M555',2,275.00,'罗技','罗技',0.88,140.00),(13,'罗技M905',2,458.00,'罗技','罗技',0.88,270.00),(14,'罗技MX1100',2,550.00,'罗技','罗技',0.76,300.00),(15,'罗技M950',2,678.00,'罗技','罗技',0.78,320.00),(17,'罗技G1',4,1550.00,'罗技','罗技',0.80,490.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdir`
--

DROP TABLE IF EXISTS `productdir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdir` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `dirName` varchar(30) DEFAULT NULL,
  `parent_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5570501 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdir`
--

LOCK TABLES `productdir` WRITE;
/*!40000 ALTER TABLE `productdir` DISABLE KEYS */;
INSERT INTO `productdir` VALUES (1,'鼠标',NULL),(2,'无线鼠标',1),(3,'有线鼠标',1),(4,'游戏鼠标',1),(5,'儿童鼠标',1),(6,'鼠标',NULL),(7,'无线鼠标',1),(8,'有线鼠标',1),(9,'游戏鼠标',1),(10,'儿童鼠标',1),(13,'鼠标',NULL),(14,'无线鼠标',1),(15,'有线鼠标',1),(16,'游戏鼠标',1),(17,'儿童鼠标',1),(18,'鼠标',NULL),(19,'无线鼠标',1),(20,'有线鼠标',1);
/*!40000 ALTER TABLE `productdir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productstock`
--

DROP TABLE IF EXISTS `productstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productstock` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(11) DEFAULT NULL,
  `storeNum` int(10) DEFAULT NULL,
  `lastIncomeDate` datetime DEFAULT NULL,
  `lastOutcomeDate` datetime DEFAULT NULL,
  `warningNum` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productstock`
--

LOCK TABLES `productstock` WRITE;
/*!40000 ALTER TABLE `productstock` DISABLE KEYS */;
INSERT INTO `productstock` VALUES (1,1,182,'2013-03-12 20:33:00','2013-03-12 20:33:04',20),(2,2,27,'2013-03-02 20:33:28','2013-03-09 20:33:40',20),(3,3,89,'2013-02-28 20:34:13','2013-03-12 20:34:19',20),(4,5,19,'2013-03-01 20:34:43','2013-03-12 20:34:48',20),(5,6,3,'2013-02-01 20:35:12','2013-03-02 20:35:16',5),(6,7,2,'2013-02-02 20:35:59','2013-02-27 20:36:05',3),(7,8,120,'2013-03-12 20:36:31','2013-03-12 20:36:33',20),(8,9,58,'2013-03-02 20:36:50','2013-03-12 20:36:53',20),(9,11,28,'2013-03-02 20:37:12','2013-03-12 20:37:15',20),(10,12,8,'2013-03-02 20:37:35','2013-03-09 20:37:38',5),(11,13,3,'2013-03-02 20:37:58','2013-03-12 20:38:01',5),(12,14,6,'2013-03-02 20:38:20','2013-03-07 20:38:23',5),(13,15,2,'2013-02-02 20:38:38','2013-02-24 20:38:44',5),(14,16,3,'2013-02-02 20:39:05','2013-02-06 20:39:09',3),(15,17,49,'2013-03-02 20:39:36','2013-03-12 20:39:40',20),(16,18,14,'2013-03-02 20:39:57','2013-03-09 20:40:01',10),(17,20,7,'2013-03-02 20:40:22','2013-03-03 20:40:25',5);
/*!40000 ALTER TABLE `productstock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-20 17:41:45
