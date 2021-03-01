# finclaw database structure description document

[toc]

## 1. Back-end data object description

**Special Note：**

- *Form used to fill out form Objects, such as registration or submission of information
- *VO used to return information about an object
- *PO used to interact with the database

### 1.1 Bank Usecase

#### 1.1.1 Project management related

##### 1.1.1.1 ProjectForm

```java
public class ProjectForm{
	private Integer userID;//ID of the creator
    private String projectName;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.2 ProjectVO

```java
public class ProjectVO{
	private Integer projectID;
	private Integer userID;//ID of the creator
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.3 Project

```java
public class Project{
	private Integer projectID;
	private Integer userID;//ID of the creator
	private Integer modelID;//One project corresponds to one model
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.4 AttendanceVO

```java
//记录一条项目参与记录
public class AttendanceVO{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;//Whether the bank chooses this data provider's data training
	private boolean isReady;//Is the data provider ready for the data
}
```

##### 1.1.1.5 Attendance

```java
public class Attendance{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;
	private boolean isReady;
}
```

#### 1.1.2 Federal learning related

##### 1.1.2.1 Model

```java
public class Model{
	private Integer modelID;
	private String mid;
	private String jid;
	private String modelVerion;//Identify the current version of the model together with mid

	private String modelName;//Need to specify when load_bind, use mname to identify when predict
}
```

#### 1.1.3 Lending related

##### 1.1.3.1 LendingForm

```java
public class LendingForm{
	private Integer bankID;//userID of bank
	private Integer lenderID；//The userID of the small and micro enterprise loaned
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;//Annual interest rate
	private String phoneNumber;//Bank manager contact information
	private String description;//Loan description
}
```

##### 1.1.3.2 LendingHistoryVO

```java
public class LendingHistoryVO{
	private Integer lendingHistoryID;
	private Integer bankID;//userID of bank
	private Integer lenderID；//The userID of the small and micro enterprise loaned
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;//Annual interest rate
	private String phoneNumber;//Bank manager contact information
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

##### 1.1.3.3 LendingHistory

```java
public class LendingHistory{
	private Integer lendingHistoryID;
	private Integer bankID;//Bank userID
	private Integer lenderID；//The userID of the small and micro enterprise loaned
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;//Annual interest rate
	private String phoneNumber;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

### 1.2 Data provider use case

#### 1.2.1 Server information related

##### 1.2.1.1 serverInfoForm

```java
//Each time you participate in a project, you must fill in the server information, because a user may use different servers to participate in different projects
public class serverInfoForm{
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;//Data provider data storage location
}
```

##### 1.2.1.2 serverInfoVO

```java
public class serverInfoVO{
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;
}
```

##### 1.2.1.3 serverInfo

```java
public class serverInfo{
    private Integer serverInfoID;//A server can only use one ID to participate in one project, so use serverInfoID to identify
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;
}
```

### 1.3 Micro-enterprise use cases

#### 1.3.1 Borrowing related

##### 1.3.1.1 LoanApplicationForm

```java
public class LoanApplicationForm{
	private Integer userID;
	private double amount;//Expected borrowing
	private String phoneNumber;//Lender's phone number
	private String certificationCode;//Social unified certification code
	private String registrationCode;//Registration Number
	private String companyName;
}
```

##### 1.3.1.2 LoanApplicationVO

```java
public class LoanApplicationVO{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;//Expected borrowing
	private String phoneNumber;//Lender's phone number
	private String certificationCode;//Social unified certification code
	private String registrationCode;//Registration Number
	private String companyName;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

##### 1.3.1.3 LoanApplication

```java
public class LoanApplication{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;//Expected borrowing
	private String phoneNumber;//Lender's phone number
	private String certificationCode;//Social unified certification code
	private String registrationCode;//Registration Number
	private String companyName;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

### 1.4 Platform worker usecases

#### 1.4.1 Data certification related

##### 1.4.1.1 FileInfoVO

```java
public class FileInfo {
    private Integer fileID;
    private Integer userID;
    private String fileName;
    private String filePath;
    private Timestamp uploadTime;
}
```

### 1.5 Common part use case

#### 1.5.1 Login and registration related

##### 1.5.1.1 UserLoginForm

```java
public class UserLoginForm {
    private String email;
    private String password;
}
```

##### 1.5.1.2 UserRegisterForm

```java
public class UserRegisterForm {
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private UserType role;//What identity do you want to register as
}
```

##### 1.5.1.3 UserVO

```java
public class UserVO {
    private Integer userID;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
    private UserType role;
}
```

##### 1.5.1.4 User

```java
public class User {
    private Integer userID;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
    private UserType role;
}
```

#### 1.5.2 Account management related

##### 1.5.2.1 UserForm

```java
public class UserForm {
    private String email;
    private String username;
    private String phoneNumber;
}
```

### 1.6 Monitor usecases

#### 1.6.1 Project monitoring related

##### 1.6.1.1 MonitorVO

```Java
public class MonitorVO {
    private int monitorID;
    private int userID;
    private int projectID;
    private String operation;
    private Timestamp operateTime;
}
```

##### 1.6.1.2 Monitor

```Java
public class Monitor {
    private int monitorID;
    private int userID;
    private int projectID;
    private String operation;
    private Timestamp operateTime;
}
```

#### 1.6.2 Monitoring and management related

##### 1.6.2.1 MonitorForm

```Java
public class MonitorForm {
    private int monitorID;
    private int userID;
    private int projectID;
    private String operation;
    private Timestamp operateTime;
    private String userName;
}
```



##  2. Database Design

### 2.1 user table

| field       | type         | Allow empty | Default value   | description                                      |
| ----------- | ------------ | ----------- | --------------- | ------------------------------------------------ |
| userID      | INT          | NO          | Self-increasing | User's ID number (unique)                        |
| email       | varchar(255) | NO          | NULL            | User Email                                       |
| password    | varchar(255) | NO          | NULL            | User Password                                    |
| username    | varchar(255) | NO          | NULL            | User Name                                        |
| phoneNumber | varchar(255) | NO          | NULL            | User phone number                                |
| role        | varchar(255) | NO          | NULL            | User role (4+1, there are unauthenticated users) |

### 2.2 project table

| field       | type         | Allow empty | Default value   | description                                                  |
| ----------- | ------------ | ----------- | --------------- | ------------------------------------------------------------ |
| projectID   | INT          | NO          | Self-increasing | Item Number                                                  |
| userID      | INT          | NO          | NULL            | The user who created the project                             |
| projectName | varchar(255) | NO          | NULL            | Project name                                                 |
| description | varchar(255) | YES         | NULL            | Project description                                          |
| startTime   | timestamp    | YES         | NULL            | Project start time                                           |
| endTime     | timestamp    | YES         | NULL            | Project end time                                             |
| status      | varchar(255) | YES         | NULL            | The status of the project, not yet started or running or finished |
| modelID     | INT          | YES         | NULL            | A project corresponds to a model                             |

### 2.3 attendance table

Record which projects the partner company has participated in

| field     | type | Allow empty | Default value | description                                                 |
| --------- | ---- | ----------- | ------------- | ----------------------------------------------------------- |
| userID    | INT  | NO          | NULL          | The account ID of the data provider                         |
| projectID | INT  | NO          | NULL          | Project code                                                |
| isChosen  | INT  | NO          | 0             | Whether the bank chooses this data provider's data training |
| isReady   | INT  | NO          | 0             | Is the data provider ready for the data                     |

### 2.4 model table

Record the information of the model corresponding to the project, mainly record the model_id, model_version, job_id and other information returned after submit for subsequent load_bind and predict operations

| field        | type         | Allow empty | Default value   |                                           description |
| ------------ | ------------ | ----------- | --------------- | ----------------------------------------------------: |
| modelID      | INT          | NO          | Self-increasing |                                           Primary key |
| mid          | varchar(255) | YES         | NULL            | Identify the model version together with modelVersion |
| jid          | varchar(255) | YES         | NULL            |                            Used to query model status |
| modelVersion | varchar(255) | YES         | NULL            |                   Identify the model version with mid |
| modelName    | varchar(255) | YES         | NULL            |                      Model name, used when predicting |

### 2.5 lendingHistory table

| field            | type         | Allow empty | Default value   | description                                   |
| ---------------- | ------------ | ----------- | --------------- | --------------------------------------------- |
| lendingHistoryID | INT          | NO          | Self-increasing | Identification of loan records                |
| bankID           | INT          | NO          | NULL            | UserID of the borrowing bank                  |
| lenderID         | INT          | NO          | NULL            | UserID of the borrower                        |
| bankName         | varchar(255) | NO          | NULL            | The name of the borrowing bank                |
| amount           | DECIMAL      | NO          | NULL            | Willingness to borrow                         |
| interestRate     | DECIMAL      | NO          | NULL            | Annual interest rate                          |
| phoneNumber      | varchar(255) | NO          | NULL            | Bank contact number                           |
| hasDealt         | INT          | NO          | 0               | Set to 1 when the borrower completes the loan |

### 2.6 serverInfo table

| field          | type         | Allow empty | Default value   | description                                                  |
| -------------- | ------------ | ----------- | --------------- | ------------------------------------------------------------ |
| serverInfoID   | INT          | NO          | Self-increasing | Primary key                                                  |
| userID         | INT          | NO          | NULL            | A user may use different servers to refer to different projects |
| projectID      | INT          | NO          | NULL            |                                                              |
| ipAddress      | varchar(255) | NO          | NULL            |                                                              |
| serverName     | varchar(255) | NO          | NULL            |                                                              |
| serverPassword | varchar(255) | NO          | NULL            |                                                              |
| filePath       | varchar(255) | NO          | NULL            | Data file path                                               |

### 2.7 loanApplication table

| field             | type         | Allow empty | Default value   | description                                   |
| ----------------- | ------------ | ----------- | --------------- | --------------------------------------------- |
| loanApplicationID | INT          | NO          | Self-increasing | Primary key                                   |
| userID            | INT          | NO          | NULL            | Account ID of the borrower                    |
| amount            | DECIMAL      | NO          | NULL            | Willingness to borrow                         |
| certificationCode | varchar(255) | NO          | NULL            | Social unified certification code             |
| registrationCode  | varchar(255) | NO          | NULL            | Registration code                             |
| companyName       | varchar(255) | NO          | NULL            | Company Name                                  |
| phoneNumber       | varchar(255) | NO          | NULL            | Lender's phone number                         |
| hasDealt          | INT          | NO          | 0               | Set to 1 when the borrower completes the loan |

### 2.8 FileInfo table

Record file information uploaded by users

| field      | type         | Allow empty | Default value   |                               description |
| ---------- | ------------ | ----------- | --------------- | ----------------------------------------: |
| fileID     | INT          | NO          | Self-increasing |                               Primary key |
| userID     | INT          | NO          | NULL            |            The user who uploaded the file |
| fileName   | varchar(255) | NO          | NULL            |                                 file name |
| filePath   | varchar(255) | NO          | NULL            | The path where the server stores the file |
| uploadTime | varchar(255) | NO          | NULL            |                               Upload time |

### 2.9 Monitor table

Record project changes and user operations

| field       | type         | Allow empty | Default value   |                             description |
| ----------- | ------------ | ----------- | --------------- | --------------------------------------: |
| monitorID   | INT          | NO          | Self-increasing |                             Primary key |
| userID      | INT          | NO          | NULL            | ID of the user performing the operation |
| projectID   | INT          | NO          | NULL            |                Corresponding project ID |
| operation   | varchar(255) | NO          | NULL            |                          Operation type |
| operateTime | timestamp    | NO          | Current time    |   Timestamp when the operation occurred |



## 3. Appendix

### 3.1 Database creation table sql file

```
-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: FinClaw
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+08:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User`
(
    `userID`      int(11)      NOT NULL AUTO_INCREMENT,
    `email`       varchar(255) NOT NULL,
    `password`    varchar(255) NOT NULL,
    `username`    varchar(255) NOT NULL,
    `phoneNumber` varchar(255) NOT NULL,
    `role`        varchar(255) NOT NULL,
    PRIMARY KEY (`userID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FinClawUser`
--

BEGIN;
/*!40000 ALTER TABLE `User`
    DISABLE KEYS */;
INSERT INTO `User`
VALUES (1, '123@qq.com', '123456', 'root', 12345678911, 'Admin');
INSERT INTO `User`
VALUES (2, '123456@qq.com', '123456', 'root1', 12345678911, 'Admin');
INSERT INTO `User`
VALUES (3, 'huaqi@qq.com', '123456', '花旗银行', 12345678911, 'Bank');
INSERT INTO `User`
VALUES (4, 'jd@qq.com', '123456', 'JD', 12345678911, 'DataProvider');
INSERT INTO `User`
VALUES (5, 'mt@qq.com', '123456', 'MT', 12345678911, 'DataProvider');
INSERT INTO `User`
VALUES (6, 'bd@qq.com', '123456', 'BD', 12345678911, 'DataProvider');
INSERT INTO `User`
VALUES (7, 'a@qq.com', '123456', 'A', 12345678911, 'Company');
INSERT INTO `User`
VALUES (8, 'b@qq.com', '123456', 'B', 12345678911, 'UnauthorizedCompany');
/*!40000 ALTER TABLE `User`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Project`
--

DROP TABLE IF EXISTS `Project`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Project`
(
    `projectID`   int(11)      NOT NULL AUTO_INCREMENT,
    `userID`      int(11)      NOT NULL,
    `projectName` varchar(255) NOT NULL,
    `description` varchar(255),
    `startTime`   timestamp,
    `endTime`     timestamp,
    `status`      varchar(255),
    `modelID`     varchar(255),
    PRIMARY KEY (`projectID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Project`
--

BEGIN;
/*!40000 ALTER TABLE `Project`
    DISABLE KEYS */;
INSERT INTO `Project`
VALUES (1, 3, '南京市活动1', '企业信用预测', NOW(), date_add(NOW(), interval 10 day), 'Running', null);
INSERT INTO `Project`
VALUES (2, 3, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 1 month), 'Running', null);
INSERT INTO `Project`
VALUES (3, 3, '南京市活动2', '企业信用预测', NOW(), date_add(NOW(), interval 2 month), 'Running', null);
/*!40000 ALTER TABLE `Project`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Attendance`
--

DROP TABLE IF EXISTS `Attendance`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attendance`
(
    `userID`    int(11) NOT NULL,
    `projectID` int(11) NOT NULL,
    `isChosen`  int(11),
    `isReady`   int(11)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attendance`
--

BEGIN;
/*!40000 ALTER TABLE `Attendance`
    DISABLE KEYS */;
INSERT INTO `Attendance`
VALUES (4, 1, 1, 1);
INSERT INTO `Attendance`
VALUES (5, 1, 1, 1);
INSERT INTO `Attendance`
VALUES (6, 1, 1, 1);
/*!40000 ALTER TABLE `Attendance`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Model`
--

DROP TABLE IF EXISTS `Model`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Model`
(
    `modelID`      int(11) NOT NULL AUTO_INCREMENT,
    `mid`          varchar(255),
    `modelVersion` varchar(255),
    `modelName`    varchar(255),
    `jid`          varchar(255),
    PRIMARY KEY (`modelID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Model`
--

BEGIN;
/*!40000 ALTER TABLE `Model`
    DISABLE KEYS */;
INSERT INTO `Model`
VALUES (1, 'null', 'null', 'SVM', 'null');
INSERT INTO `Model`
VALUES (2, 'null', 'null', 'Regression', 'null');
INSERT INTO `Model`
VALUES (3, 'null', 'null', 'NeuralNetwork', 'null');
INSERT INTO `Model`
VALUES (4, 'null', 'null', 'SecureBoost', 'null');
/*!40000 ALTER TABLE `Model`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `Monitor`
--

DROP TABLE IF EXISTS `Monitor`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Monitor`
(
    `monitorID`   int(11)      NOT NULL AUTO_INCREMENT,
    `userID`      int(11)      NOT NULL,
    `projectID`   int(11)      NOT NULL,
    `operation`   varchar(255) NOT NULL,
    `operateTime` timestamp,
    PRIMARY KEY (`monitorID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Monitor`
--

BEGIN;
/*!40000 ALTER TABLE `Monitor`
    DISABLE KEYS */;
INSERT INTO `Monitor`
VALUES (1, 3, 1, 'Add', date_add(NOW(), interval 10 day));
INSERT INTO `Monitor`
VALUES (2, 3, 1, 'Add', date_add(NOW(), interval 1 month));
INSERT INTO `Monitor`
VALUES (3, 3, 2, 'Delete', date_add(NOW(), interval 2 month));
/*!40000 ALTER TABLE `Monitor`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `lendingHistory`
--

DROP TABLE IF EXISTS `lendingHistory`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lendingHistory`
(
    `lendingHistoryID` int(11)      NOT NULL AUTO_INCREMENT,
    `bankID`           int(11)      NOT NULL,
    `lenderID`         int(11)      NOT NULL,
    `bankName`         varchar(255) NOT NULL,
    `amount`           DECIMAL      NOT NULL,
    `interestRate`     DECIMAL      NOT NULL,
    `phoneNumber`      varchar(255) NOT NULL,
    `hasDealt`         int(11)      NOT NULL,
    PRIMARY KEY (`lendingHistoryID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lendingHistory`
--

BEGIN;
/*!40000 ALTER TABLE `lendingHistory`
    DISABLE KEYS */;
INSERT INTO `lendingHistory`
VALUES (1, 3, 7, '花旗银行', 100000, 0.1, 12345678911, 0);
/*!40000 ALTER TABLE `lendingHistory`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `serverInfo`
--

DROP TABLE IF EXISTS `serverInfo`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serverInfo`
(
    `serverInfoID`   int(11)      NOT NULL AUTO_INCREMENT,
    `userID`         int(11)      NOT NULL,
    `projectID`      int(11)      NOT NULL,
    `ipAddress`      varchar(255) NOT NULL,
    `serverName`     varchar(255) NOT NULL,
    `serverPassword` varchar(255) NOT NULL,
    `filePath`       varchar(255) NOT NULL,
    PRIMARY KEY (`serverInfoID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serverInfo`
--

BEGIN;
/*!40000 ALTER TABLE `serverInfo`
    DISABLE KEYS */;
INSERT INTO `serverInfo`
VALUES (1, 4, 1, 'null', 'null', 'null', 'null');
INSERT INTO `serverInfo`
VALUES (2, 5, 1, 'null', 'null', 'null', 'null');
INSERT INTO `serverInfo`
VALUES (3, 6, 1, 'null', 'null', 'null', 'null');
/*!40000 ALTER TABLE `serverInfo`
    ENABLE KEYS */;
COMMIT;


--
-- Table structure for table `loanApplication`
--

DROP TABLE IF EXISTS `loanApplication`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loanApplication`
(
    `loanApplicationID` int(11)      NOT NULL AUTO_INCREMENT,
    `userID`            int(11)      NOT NULL,
    `amount`            DECIMAL      NOT NULL,
    `certificationCode` varchar(255) NOT NULL,
    `registrationCode`  varchar(255) NOT NULL,
    `companyName`       varchar(255) NOT NULL,
    `phoneNumber`       varchar(255) NOT NULL,
    `hasDealt`          int(11)      NOT NULL,
    PRIMARY KEY (`loanApplicationID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanApplication`
--

BEGIN;
/*!40000 ALTER TABLE `loanApplication`
    DISABLE KEYS */;
INSERT INTO `loanApplication`
VALUES (1, 7, 100000, 'null', 'null', 'A', 12345678911, false);
/*!40000 ALTER TABLE `loanApplication`
    ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `lendingHistory`
--

DROP TABLE IF EXISTS `lendingHistory`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lendingHistory`
(
    `lendingHistoryID` int(11)      NOT NULL AUTO_INCREMENT,
    `bankID`           int(11)      NOT NULL,
    `lenderID`         DECIMAL      NOT NULL,
    `bankName`         varchar(255) NOT NULL,
    `amount`           DECIMAL      NOT NULL,
    `interestRate`     DECIMAL      not null,
    `phoneNumber`      varchar(255) NOT NULL,
    `hasDealt`         int(11)      NOT NULL,
    PRIMARY KEY (`lendingHistoryID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lendingHistory`
--

BEGIN;
/*!40000 ALTER TABLE `lendingHistory`
    DISABLE KEYS */;
INSERT INTO `lendingHistory`
VALUES (1, 1, 1, 'Citi', 20000.00, 0.17, 12345678911, false);
/*!40000 ALTER TABLE `lendingHistory`
    ENABLE KEYS */;
COMMIT;

--
-- Table structure for table `File`
--

DROP TABLE IF EXISTS `File`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `File`
(
    `fileID`     int(11)      NOT NULL AUTO_INCREMENT,
    `fileName`   varchar(255) NOT NULL,
    `uploadTime` timestamp DEFAULT current_timestamp,
    `userID`     int(11)      NOT NULL,
    `filePath`   varchar(255) NOT NULL,
    PRIMARY KEY (`fileID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `File`
--

BEGIN;
/*!40000 ALTER TABLE `File`
    DISABLE KEYS */;
INSERT INTO `File`
VALUES (1, 'test.csv', NOW(), 1, 'D:/user');
/*!40000 ALTER TABLE `File`
    ENABLE KEYS */;
COMMIT;



/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2020-04-12 10:08:42
SET FOREIGN_KEY_CHECKS = 1;
```

