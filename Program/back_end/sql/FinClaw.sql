
-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: FinClaw
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
    PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FinClawUser`
--

BEGIN;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1, '123@qq.com', '123456', 'root', 12345678911, 'Admin');
INSERT INTO `User` VALUES (2, '123456@qq.com', '123456', 'root1', 12345678911, 'Admin');
INSERT INTO `User` VALUES (3, 'huaqi@qq.com', '123456', '花旗银行', 12345678911, 'Bank');
INSERT INTO `User` VALUES (4, 'jd@qq.com', '123456', 'JD', 12345678911, 'DataProvider');
INSERT INTO `User` VALUES (5, 'mt@qq.com', '123456', 'MT', 12345678911, 'DataProvider');
INSERT INTO `User` VALUES (6, 'bd@qq.com', '123456', 'BD', 12345678911, 'DataProvider');
INSERT INTO `User` VALUES (7, 'a@qq.com', '123456', 'A', 12345678911, 'Company');
INSERT INTO `User` VALUES (8, 'b@qq.com', '123456', 'B', 12345678911, 'Unauthorized');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Project`
--

DROP TABLE IF EXISTS `Project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Project` (
                           `projectID` int(11) NOT NULL AUTO_INCREMENT,
                           `userID` int(11) NOT NULL,
                           `projectName` varchar(255) NOT NULL,
                           `description` varchar(255),
                           `startTime` timestamp,
                           `endTime` timestamp,
                           `status` varchar(255),
                           `modelID` varchar(255),
                           PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Project`
--

BEGIN;
/*!40000 ALTER TABLE `Project` DISABLE KEYS */;
INSERT INTO `Project` VALUES (1, 3, '南京市活动1', '企业信用预测', NOW(), date_add(NOW(), interval 10 day), 'Running',null);
INSERT INTO `Project` VALUES (2, 3, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 1 month), 'Running',null);
INSERT INTO `Project` VALUES (3, 3, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 2 month), 'Running',null);
/*!40000 ALTER TABLE `Project` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Attendance`
--

DROP TABLE IF EXISTS `Attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attendance` (
                              `userID` int(11) NOT NULL,
                              `projectID` int(11) NOT NULL,
                              `isChosen` int(11) NOT NULL,
                              `isReady` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attendance`
--

BEGIN;
/*!40000 ALTER TABLE `Attendance` DISABLE KEYS */;
INSERT INTO `Attendance` VALUES (4, 1, 1, 1);
INSERT INTO `Attendance` VALUES (5, 1, 1, 1);
INSERT INTO `Attendance` VALUES (6, 1, 1, 1);
/*!40000 ALTER TABLE `Attendance` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Model`
--

DROP TABLE IF EXISTS `Model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Model` (
                         `modelID` int(11) NOT NULL AUTO_INCREMENT,
                         `mid` varchar(255) NOT NULL,
                         `modelVersion` varchar(255) NOT NULL,
                         `modelName` varchar(255) NOT NULL,
                         PRIMARY KEY (`modelID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Model`
--

BEGIN;
/*!40000 ALTER TABLE `Model` DISABLE KEYS */;
INSERT INTO `Model` VALUES (1,'null','null', 'SVM');
INSERT INTO `Model` VALUES (2,'null','null', 'Regression');
INSERT INTO `Model` VALUES (3,'null','null', 'NeuralNetwork');
INSERT INTO `Model` VALUES (4,'null','null', 'SecureBoost');
/*!40000 ALTER TABLE `Model` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Monitor`
--

DROP TABLE IF EXISTS `Monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Monitor` (
                           `monitorID` int(11)NOT NULL AUTO_INCREMENT,
                           `userID` int(11) NOT NULL,
                           `projectID` int(11) NOT NULL,
                           `operation` varchar(255) NOT NULL,
                           `operateTime` timestamp,
                           PRIMARY KEY (`monitorID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Monitor`
--

BEGIN;
/*!40000 ALTER TABLE `Monitor` DISABLE KEYS */;
INSERT INTO `Monitor` VALUES (1, 3, 1, 'Add', date_add(NOW(), interval 10 day));
INSERT INTO `Monitor` VALUES (2, 3, 1, 'Add', date_add(NOW(), interval 1 month));
INSERT INTO `Monitor` VALUES (3, 3, 2, 'Delete', date_add(NOW(), interval 2 month));
/*!40000 ALTER TABLE `Monitor` ENABLE KEYS */;
COMMIT;



--
-- Table structure for table `lendingHistory`
--

DROP TABLE IF EXISTS `lendingHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lendingHistory` (
    `lendingHistoryID` int(11) NOT NULL AUTO_INCREMENT,
    `bankID` int(11) NOT NULL,
    `lenderID` int(11) NOT NULL,
    `bankName` varchar(255) NOT NULL,
    `amount` DECIMAL NOT NULL,
    `interestRate` DECIMAL NOT NULL,
    `phoneNumber` varchar(255) NOT NULL,
    `hasDealt` int(11) NOT NULL,
    PRIMARY KEY (`lendingHistoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lendingHistory`
--

BEGIN;
/*!40000 ALTER TABLE `lendingHistory` DISABLE KEYS */;
INSERT INTO `lendingHistory` VALUES (1, 3, 7, '花旗银行', 100000, 0.1, 12345678911, 0);
/*!40000 ALTER TABLE `lendingHistory` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `serverInfo`
--

DROP TABLE IF EXISTS `serverInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serverInfo` (
                              `userID` int(11) NOT NULL,
                              `projectID` int(11) NOT NULL,
                              `ipAddress` varchar(255) NOT NULL,
                              `serverName` varchar(255) NOT NULL,
                              `serverPassword` varchar(255) NOT NULL,
                              `filePath` varchar(255) NOT NULL,
                              PRIMARY KEY (`userId`,`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serverInfo`
--

BEGIN;
/*!40000 ALTER TABLE `serverInfo` DISABLE KEYS */;
INSERT INTO `serverInfo` VALUES (4, 1, 'null', 'null', 'null', 'null');
INSERT INTO `serverInfo` VALUES (5, 1, 'null', 'null', 'null', 'null');
INSERT INTO `serverInfo` VALUES (6, 1, 'null', 'null', 'null', 'null');
/*!40000 ALTER TABLE `serverInfo` ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `loanApplication`
--

DROP TABLE IF EXISTS `loanApplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanApplication` (
                                   `loanApplicationID` int(11) NOT NULL AUTO_INCREMENT,
                                   `userID` int(11) NOT NULL,
                                   `amount` DECIMAL NOT NULL,
                                   `certificationCode` varchar(255) NOT NULL,
                                   `registrationCode` varchar(255) NOT NULL,
                                   `companyName` varchar(255) NOT NULL,
                                   `phoneNumber` varchar(255) NOT NULL,
                                   `hasDealt` int(11) NOT NULL,
                                   PRIMARY KEY (`loanApplicationID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanApplication`
--

BEGIN;
/*!40000 ALTER TABLE `loanApplication` DISABLE KEYS */;
INSERT INTO `loanApplication` VALUES (1, 7, 100000, 'null', 'null', 'A', 12345678911, 0);
/*!40000 ALTER TABLE `loanApplication` ENABLE KEYS */;
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