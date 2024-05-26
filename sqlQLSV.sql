-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop` (
  `ma_lop` int NOT NULL AUTO_INCREMENT,
  `ten_lop` varchar(7) NOT NULL,
  PRIMARY KEY (`ma_lop`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (1,'21DTHD1'),(2,'21DTHD2'),(3,'21DTHA1'),(4,'21DTHA2');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_hoc` (
  `ma_mon` varchar(10) NOT NULL,
  `ten_mon_hoc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_mon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES ('CMP169','Trí tuệ nhân tạo'),('CMP175','Lập trình web');
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien` (
  `mssv` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ho_ten` varchar(50) NOT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `ma_lop` int DEFAULT NULL,
  PRIMARY KEY (`mssv`),
  KEY `FK_SINHVIEN_LOP` (`ma_lop`),
  CONSTRAINT `FK_SINHVIEN_LOP` FOREIGN KEY (`ma_lop`) REFERENCES `lop` (`ma_lop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES ('2180600145','canh@gmail.com','Nguyễn Văn Cảnh','2003-02-11',1),('2180607170','thanhngan.7170@gmail.com','Lê Thị Thanh Ngân','2003-03-16',1),('2180607413','dat@gmail.com','Đỗ Thành Đạt','2003-01-01',1);
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien_mon_hoc`
--

DROP TABLE IF EXISTS `sinh_vien_mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien_mon_hoc` (
  `mssv` varchar(10) NOT NULL,
  `ma_mon` varchar(10) NOT NULL,
  PRIMARY KEY (`mssv`,`ma_mon`),
  KEY `FKs151dmxl0rhttj0jbgkwjvu6` (`ma_mon`),
  CONSTRAINT `FK49a5ckv36d2wetrj75iyxsucn` FOREIGN KEY (`mssv`) REFERENCES `sinh_vien` (`mssv`),
  CONSTRAINT `FKs151dmxl0rhttj0jbgkwjvu6` FOREIGN KEY (`ma_mon`) REFERENCES `mon_hoc` (`ma_mon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien_mon_hoc`
--

LOCK TABLES `sinh_vien_mon_hoc` WRITE;
/*!40000 ALTER TABLE `sinh_vien_mon_hoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sinh_vien_mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-26 21:56:24
