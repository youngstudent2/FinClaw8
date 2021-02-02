
-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Hotel
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
    `userID` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    `phoneNumber` varchar(255) NOT NULL,
    `role` varchar(255) NOT NULL,
    `cooperation` varchar(255),
    `cooperationID` varchar(255),
    PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FinClawUser`
--

BEGIN;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1, '123@qq.com', '123456', 'root', 12345678911, 'Manager','中国银行', null);
INSERT INTO `User` VALUES (2, '123456@qq.com', '123456', 'root1', 12345678911, 'DataManager','中国银行', null);
INSERT INTO `User` VALUES (3, 'ali@qq.com', '123456', 'ALi', 12345678911, 'Cooperation','阿里巴巴', 1);
INSERT INTO `User` VALUES (4, 'jd@qq.com', '123456', 'JD', 12345678911, 'Cooperation','京东', 2);
INSERT INTO `User` VALUES (5, 'mt@qq.com', '123456', 'MT', 12345678911, 'Cooperation','美团', 3);
INSERT INTO `User` VALUES (6, 'bd@qq.com', '123456', 'BD', 12345678911, 'Cooperation','字节跳动', 4);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `File`
--

DROP TABLE IF EXISTS `File`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `File` (
    `fileID` int(11) NOT NULL AUTO_INCREMENT,
    `fileName` varchar(255) NOT NULL,
    `uploadTime` timestamp DEFAULT current_timestamp,
    `operatorID` int(11) NOT NULL,
    `projectID` int(11) NOT NULL,
    `trainedTimes` int(11) DEFAULT 0,
    `filePath` varchar(255) NOT NULL,
    PRIMARY KEY (`fileID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `File`
--

BEGIN;
/*!40000 ALTER TABLE `File` DISABLE KEYS */;
INSERT INTO `File` VALUES (1, 'test.csv' ,NOW() ,1 ,1  ,0,'D:/user');
/*!40000 ALTER TABLE `File` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Monitor`
--

DROP TABLE IF EXISTS `Monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Monitor` (
   `monitorID` int(11) NOT NULL AUTO_INCREMENT,
   `userID` int(11) NOT NULL,
   `projectID` int(11) NOT NULL,
   `operateTime` timestamp default current_timestamp,
   `operation` varchar(255) NOT NULL,
    primary key (`monitorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Monitor`
--

BEGIN;
/*!40000 ALTER TABLE `Monitor` DISABLE KEYS */;
INSERT INTO `Monitor` VALUES (1, 1, 1, NOW(), 'Add');
/*!40000 ALTER TABLE `Monitor` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Cooperation`
--

DROP TABLE IF EXISTS `Cooperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cooperation` (
    `cooperationID` int(11) NOT NULL AUTO_INCREMENT,
    `cooperationName` varchar(255) NOT NULL,
    `phoneNumber` varchar(255) NOT NULL,
    `ipAddress` varchar(255),
    `serviceName` varchar(255),
    `servicePassword` varchar(255),
    PRIMARY KEY (`cooperationID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cooperation`
--

BEGIN;
/*!40000 ALTER TABLE `Cooperation` DISABLE KEYS */;
INSERT INTO `Cooperation` VALUES (1, '阿里巴巴', 12345678911, null, null, null);
INSERT INTO `Cooperation` VALUES (2, '京东', 12345678911, null, null, null);
INSERT INTO `Cooperation` VALUES (3, '美团', 12345678911, null, null, null);
INSERT INTO `Cooperation` VALUES (4, '字节跳动', 12345678911, null, null, null);

/*!40000 ALTER TABLE `Cooperation` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `Model`
--

DROP TABLE IF EXISTS `Model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Model` (
    `modelID` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`modelID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Model`
--

BEGIN;
/*!40000 ALTER TABLE `Model` DISABLE KEYS */;
INSERT INTO `Model` VALUES (1, 'SVM');
INSERT INTO `Model` VALUES (2, 'Regression');
INSERT INTO `Model` VALUES (3, 'NeuralNetwork');
INSERT INTO `Model` VALUES (4, 'SecureBoost');
/*!40000 ALTER TABLE `Model` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `Project`
--

DROP TABLE IF EXISTS `Project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Project` (
    `projectID` int(11) NOT NULL AUTO_INCREMENT,
    `projectName` varchar(255) NOT NULL,
    `description` varchar(255),
    `startTime` timestamp,
    `endTime` timestamp,
    `status` varchar(255),
    `fileID` int(11),
    `modelID` varchar(255),
    `modelVersion` varchar(255),
    PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Project`
--

BEGIN;
/*!40000 ALTER TABLE `Project` DISABLE KEYS */;
INSERT INTO `Project`(projectID, projectName, description, startTime, endTime, status) VALUES (1, '南京市活动1', '企业信用预测', NOW(), date_add(NOW(), interval 10 day), 'Running');
INSERT INTO `Project`(projectID, projectName, description, startTime, endTime, status) VALUES (2, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 1 month), 'Running');
INSERT INTO `Project`(projectID, projectName, description, startTime, endTime, status) VALUES (3, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 2 month), 'Running');
/*!40000 ALTER TABLE `Project` ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `Attend`
--

DROP TABLE IF EXISTS `Attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attend` (
    `cooperationID` int(11) NOT NULL,
    `projectID` int(11) NOT NULL,
    `ready` int(11) NOT NULL,
    `authority` int(11) NOT NULL,
    `filepath` varchar(255)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attend`
--

BEGIN;
/*!40000 ALTER TABLE `Attend` DISABLE KEYS */;
INSERT INTO `Attend` VALUES (1, 1, 0, 1, null);
INSERT INTO `Attend` VALUES (2, 1, 0, 1, null);
INSERT INTO `Attend` VALUES (3, 1, 0, 1, null);
INSERT INTO `Attend` VALUES (4, 1, 0, 1, null);
/*!40000 ALTER TABLE `Attend` ENABLE KEYS */;
COMMIT;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-12 10:08:42
SET FOREIGN_KEY_CHECKS = 1;