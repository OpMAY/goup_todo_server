#Spring Project v a.2
##업데이트
####0.Build
 - 이제 모든 설정 파일이 Github에 올라가게 됩니다. (`log4j.xml` 제외)
####1.Properties
 - 모든 properties는 Github에 올라가게 됩니다.
 - 모든 설정들은 `key.properties`, `config.properties`로 통일됩니다.
 - `.properties`의 모든 파일들의 value는 암호화됩니다.
 - `.properties`의 모든 value는 프로젝트를 빌드할 때 복호화됩니다.
 - 이제 PropertyResource Annotation을 사용하지 않고도 Value Annotation이 사용가능합니다.

####2.Middleware
 - 이제 package_path를 사용하지 않아도 자동으로 Class Casting이 완료됩니다.
 JSON 및 JSONArray는 자동으로 Class Casting이 완료됩니다. (Ref : `mapper.xml`, `Middleware Package`)

##Database Init
```
CREATE DATABASE  IF NOT EXISTS `flowtest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flowtest`;
-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flowtest
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `arrayrecursivetest`
--

DROP TABLE IF EXISTS `arrayrecursivetest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arrayrecursivetest` (
  `no` int NOT NULL AUTO_INCREMENT,
  `recursives` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrayrecursivetest`
--

LOCK TABLES `arrayrecursivetest` WRITE;
/*!40000 ALTER TABLE `arrayrecursivetest` DISABLE KEYS */;
INSERT INTO `arrayrecursivetest` VALUES (1,'[{\"package_path\":\"com.model.Recursive\",\"no\":1,\"name\":\"kimwoosik\",\"price\":1000},{\"package_path\":\"com.model.Recursive\",\"no\":2,\"name\":\"kimwoosik\",\"price\":1000}]');
/*!40000 ALTER TABLE `arrayrecursivetest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arraytest`
--

DROP TABLE IF EXISTS `arraytest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arraytest` (
  `no` int NOT NULL AUTO_INCREMENT,
  `usertest` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arraytest`
--

LOCK TABLES `arraytest` WRITE;
/*!40000 ALTER TABLE `arraytest` DISABLE KEYS */;
INSERT INTO `arraytest` VALUES (1,'[{\"no\":0,\"email\":\"zlzldntlr@naver.com\",\"id\":\"zlzldntlr\",\"name\":\"김우식\",\"grant\":\"normal\",\"access_token\":\"token\"},{\"no\":0,\"email\":\"zlzldntlr@naver.com\",\"id\":\"zlzldntlr\",\"name\":\"김우식\",\"grant\":\"normal\",\"access_token\":\"token\"},{\"no\":0,\"email\":\"zlzldntlr@naver.com\",\"id\":\"zlzldntlr\",\"name\":\"김우식\",\"grant\":\"normal\",\"access_token\":\"token\"}]');
/*!40000 ALTER TABLE `arraytest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shedlock`
--

DROP TABLE IF EXISTS `shedlock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shedlock` (
  `name` varchar(64) NOT NULL COMMENT '스케줄잠금이름',
  `lock_until` timestamp(3) NULL DEFAULT NULL COMMENT '잠금기간',
  `locked_at` timestamp(3) NULL DEFAULT NULL COMMENT '잠금일시',
  `locked_by` varchar(255) DEFAULT NULL COMMENT '잠금신청자',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shedlock`
--

LOCK TABLES `shedlock` WRITE;
/*!40000 ALTER TABLE `shedlock` DISABLE KEYS */;
INSERT INTO `shedlock` VALUES ('OftenShedLockJob','2021-08-29 19:18:03.025','2021-08-29 19:18:00.016','LAPTOP-TJQ3AASD'),('testShedLockJob','2021-08-23 03:47:03.028','2021-08-23 03:47:00.023','LAPTOP-TJQ3AASD');
/*!40000 ALTER TABLE `shedlock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `no` int NOT NULL AUTO_INCREMENT,
  `testcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'asdfs'),(3,'asdf');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `no` int NOT NULL AUTO_INCREMENT,
  `usertest` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'{\"no\":0,\"email\":\"zlzldntlr@naver.com\",\"id\":\"zlzldntlr\",\"name\":\"김우식\",\"grant\":\"normal\",\"access_token\":\"token\"}'),(3,'test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-19 23:49:21

```