-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sy
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin`
(
    `ano`      int         NOT NULL,
    `password` varchar(20) NOT NULL,
    `id`       int         NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin`
    DISABLE KEYS */;
INSERT INTO `admin` (`ano`, `password`, `id`)
VALUES (1, '1', 1),
       (2, '2', 2),
       (3, '3', 3),
       (4, '4', 4),
       (5, '5', 5);
/*!40000 ALTER TABLE `admin`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cou`
--

DROP TABLE IF EXISTS `cou`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cou`
(
    `cno` int NOT NULL,
    `id`  int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cou`
--

LOCK TABLES `cou` WRITE;
/*!40000 ALTER TABLE `cou`
    DISABLE KEYS */;
INSERT INTO `cou` (`cno`, `id`)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (13, 13),
       (14, 14),
       (15, 15);
/*!40000 ALTER TABLE `cou`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_c`
--

DROP TABLE IF EXISTS `s_c`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_c`
(
    `sno`   varchar(32) NOT NULL,
    `cno`   int         NOT NULL,
    `score` double      NOT NULL,
    `id`    int         NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_c`
--

LOCK TABLES `s_c` WRITE;
/*!40000 ALTER TABLE `s_c`
    DISABLE KEYS */;
INSERT INTO `s_c` (`sno`, `cno`, `score`, `id`)
VALUES ('2205221133', 1, 1, 2),
       ('2205221139', 1, 4, 3),
       ('2205221123', 2, 3, 4),
       ('2205221123', 3, 3, 5),
       ('2205221124', 3, 3, 6),
       ('2205221125', 1, 3, 7),
       ('2205221123', 6, 0, 9),
       ('2205221123', 7, 0, 10),
       ('2205221123', 1, 11, 11),
       ('2205221123', 15, 23, 12),
       ('2205220011', 1, 2, 13);
/*!40000 ALTER TABLE `s_c`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu`
(
    `ca`   varchar(32) NOT NULL,
    `sno`  varchar(32) NOT NULL,
    `name` varchar(20) NOT NULL,
    `sex`  varchar(20) NOT NULL,
    `id`   int         NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu`
    DISABLE KEYS */;
INSERT INTO `stu` (`ca`, `sno`, `name`, `sex`, `id`)
VALUES ('100000000000000020', '2205220001', '小芳', '女', 1),
       ('100000000000000040', '2205220002', '小红', '女', 2),
       ('320682200408317633', '2205221123', '陈', '男', 3),
       ('320922200411080016', '2205221133', '殷', '男', 4),
       ('321023200404270418', '2205221139', '翟', '男', 5),
       ('321023200404270418', '2205221100', 'a', '男', 6),
       ('321023200404270410', '2205221101', 'b', '男', 7),
       ('321023200404270414', '2205221102', 'c', '男', 8),
       ('321023200404270417', '2205221103', 'd', '男', 9),
       ('321023200404270419', '2205221104', 'e', '男', 10),
       ('321023200404270414', '2205221103', 'dd', '女', 11),
       ('100000000000000022', '2205221001', 'dgB', '女', 12),
       ('100000000000000041', '2205220003', 'sc', '女', 13),
       ('321023200404270418', '2200221100', 'cs', '男', 14),
       ('321023200304270417', '2205220011', 'dx', '男', 15),
       ('321023200204180427', '2205221124', 'mh', '女', 16);
/*!40000 ALTER TABLE `stu`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22  2:17:40
