# finclaw数据库结构说明文档

[toc]

## 1. 后端数据对象说明

**特别说明：**

- *Form 用于填写表单的对象，例如注册或提交信息
- *VO 用于返回某个对象的信息
- *PO用于与数据库交互

### 1.1 银行用例

#### 1.1.1 项目管理相关

##### 1.1.1.1 ProjectForm

```
public class ProjectForm{
	private Integer userID;//创建者的ID
    private String projectName;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.2 ProjectVO

```
public class ProjectVO{
	private Integer projectID;
	private Integer userID;//创建者的ID
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.3 Project

```
public class Project{
	private Integer projectID;
	private Integer userID;//创建者的ID
	private Integer modelID;//一个项目对应一个模型
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

##### 1.1.1.4 AttendanceVO

```
//记录一条项目参与记录
public class AttendanceVO{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;//银行是否选择这个数据提供方的数据训练
	private boolean isReady;//数据提供方是否准备好数据
}
```

##### 1.1.1.5 Attendance

```
public class Attendance{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;
	private boolean isReady;
}
```

#### 1.1.2 联邦学习相关

##### 1.1.2.1 Model

```
public class Model{
	private Integer modelID;
	private String mid;
	private String jid;
	private String modelVerion;//和mid一起标识当前版本模型
	private String modelName;//在load_bind时需要指明，predict时是使用mname来进行标识
}
```

#### 1.1.3 放贷相关

##### 1.1.3.1 LendingForm

```
public class LendingForm{
	private Integer bankID;//银行的userID
	private Integer lenderID；//贷款的小微企业的userID
	private String bankName;
	private double amount;//意愿贷款数额
	private double interestRate;//年利率
	private String phoneNumber;//银行经理联系方式
	private String description;//贷款说明
}
```

##### 1.1.3.2 LendingHistoryVO

```
public class LendingHistoryVO{
	private Integer lendingHistoryID;
	private Integer bankID;//银行的userID
	private Integer lenderID；//贷款的小微企业的userID
	private String bankName;
	private double amount;//意愿贷款数额
	private double interestRate;//年利率
	private String phoneNumber;
	private boolean hasDealt;//借款人完成借款时置为true
}
```

##### 1.1.3.3 LendingHistory

```
public class LendingHistory{
	private Integer lendingHistoryID;
	private Integer bankID;//银行的userID
	private Integer lenderID；//贷款的小微企业的userID
	private String bankName;
	private double amount;//意愿贷款数额
	private double interestRate;//年利率
	private String phoneNumber;
	private boolean hasDealt;//借款人完成借款时置为true
}
```

### 1.2 数据提供方用例

#### 1.2.1 服务器信息相关

##### 1.2.1.1 serverInfoForm

```
//每次参加项目都要填写服务器信息，因为一个用户可能用不同服务器参加不同项目
public class serverInfoForm{
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;//数据提供方数据存放位置
}
```

##### 1.2.1.2 serverInfoVO

```
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

```
public class serverInfo{
    private Integer serverInfoID;//一台服务器只能用一个ID参与一个项目，所以要用serverInfoID来标识
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;
}
```

### 1.3 小微企业用例

#### 1.3.1 借贷相关

##### 1.3.1.1 LoanApplicationForm

```
public class LoanApplicationForm{
	private Integer userID;
	private double amount;//预期借款额
	private String phoneNumber;//贷款人联系电话
	private String certificationCode;//社会统一认证代码
	private String registrationCode;//注册号
	private String companyName;
}
```

##### 1.3.1.2 LoanApplicationVO

```
public class LoanApplicationVO{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;//预期借款额
	private String phoneNumber;//贷款人联系电话
	private String certificationCode;//社会统一认证代码
	private String registrationCode;//注册号
	private String companyName;
	private boolean hasDealt;//借款人完成借款时置为true
}
```

##### 1.3.1.3 LoanApplication

```
public class LoanApplication{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;//预期借款额
	private String phoneNumber;//贷款人联系电话
	private String certificationCode;//社会统一认证代码
	private String registrationCode;//注册号
	private String companyName;
	private boolean hasDealt;//借款人完成借款时置为true
}
```

### 1.4 平台工作人员用例

#### 1.4.1 资料认证相关

##### 1.4.1.1 FileInfoVO

```
public class FileInfo {
    private Integer fileID;
    private Integer userID;
    private String fileName;
    private String filePath;
    private Timestamp uploadTime;
}
```

### 1.5 公共部分用例

#### 1.5.1 登录注册相关

##### 1.5.1.1 UserLoginForm

```
public class UserLoginForm {
    private String email;
    private String password;
}
```

##### 1.5.1.2 UserRegisterForm

```
public class UserRegisterForm {
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private UserType role;//希望以什么身份注册
}
```

##### 1.5.1.3 UserVO

```
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

```
public class User {
    private Integer userID;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
    private UserType role;
}
```

#### 1.5.2 账户管理相关

##### 1.5.2.1 UserForm

```
public class UserForm {
    private String email;
    private String username;
    private String phoneNumber;
}
```

##  2. 数据库设计

### 2.1 user表

| field       | type         | 允许空 | 缺省值 | description                   |
| ----------- | ------------ | ------ | ------ | ----------------------------- |
| userID      | INT          | 否     | 自增   | 用户的ID号（唯一）            |
| email       | varchar(255) | 否     | 无     | 用户邮箱                      |
| password    | varchar(255) | 否     | 无     | 用户密码                      |
| username    | varchar(255) | 否     | 无     | 用户名称                      |
| phoneNumber | varchar(255) | 否     | 无     | 用户手机号                    |
| role        | varchar(255) | 否     | 无     | 用户角色(4+1，还有未认证用户) |

### 2.2 project表

| field       | type         | 允许空 | 缺省值 | description                            |
| ----------- | ------------ | ------ | ------ | -------------------------------------- |
| projectID   | INT          | 否     | 自增   | 项目编号                               |
| userID      | INT          | 否     | 无     | 创建项目的用户                         |
| projectName | varchar(255) | 否     | 无     | 项目名称                               |
| description | varchar(255) | 是     | 无     | 项目描述                               |
| startTime   | timestamp    | 是     | 无     | 项目的开始时间                         |
| endTime     | timestamp    | 是     | 无     | 项目的结束时间                         |
| status      | varchar(255) | 是     | 无     | 项目的状态，尚未开始or正在运行or已结束 |
| modelID     | INT          | 是     | 无     | 一个项目对应一个model                  |

### 2.3 attendance表

记录合作企业参加了哪些项目

| field     | type | 允许空 | 缺省值 | description                          |
| --------- | ---- | ------ | ------ | ------------------------------------ |
| userID    | INT  | 否     | 无     | 数据提供方的账号ID                   |
| projectID | INT  | 否     | 无     | 项目代号                             |
| isChosen  | INT  | 是     | 0      | 银行是否选择这个数据提供方的数据训练 |
| isReady   | INT  | 是     | 0      | 数据提供方是否准备好数据             |

### 2.4 model表

记录项目对应的模型的信息，主要记录的是submit后返回的model_id,model_version,job_id等信息，用于后续load_bind和predict操作

| field        | type         | 允许空 | 缺省值 |                    description |
| ------------ | ------------ | ------ | ------ | -----------------------------: |
| modelID      | INT          | 否     | 自增   |                           主键 |
| mid          | varchar(255) | 是     | 无     | 和modelVersion一起标识模型版本 |
| jid          | varchar(255) | 是     | 无     |          用于query查询模型状态 |
| modelVersion | varchar(255) | 是     | 无     |          和mid一起标识模型版本 |
| modelName    | varchar(255) | 是     | 无     |        模型名称，predict时要用 |

### 2.5 lendingHistory表

| field            | type         | 允许空 | 缺省值 | description           |
| ---------------- | ------------ | ------ | ------ | --------------------- |
| lendingHistoryID | INT          | 否     | 自增   | 借款记录的标识        |
| bankID           | INT          | 否     | 无     | 借款银行的userID      |
| lenderID         | INT          | 否     | 无     | 借款方的userID        |
| bankName         | varchar(255) | 否     | 无     | 借款银行的名称        |
| amount           | DECIMAL      | 否     | 无     | 意愿借款数额          |
| interestRate     | DECIMAL      | 否     | 无     | 年利率                |
| phoneNumber      | varchar(255) | 否     | 无     | 银行联系电话          |
| hasDealt         | INT          | 否     | 0      | 借款方完成贷款时置为1 |

### 2.6 serverInfo表

| field          | type         | 允许空 | 缺省值 | description                            |
| -------------- | ------------ | ------ | ------ | -------------------------------------- |
| serverInfoID   | INT          | 否     | 自增   | 主键                                   |
| userID         | INT          | 否     | 无     | 一个用户可能用不同的服务器参见不同项目 |
| projectID      | INT          | 否     | 无     |                                        |
| ipAddress      | varchar(255) | 否     | 无     |                                        |
| serverName     | varchar(255) | 否     | 无     |                                        |
| serverPassword | varchar(255) | 否     | 无     |                                        |
| filePath       | varchar(255) | 否     | 无     | 数据文件路径                           |

### 2.7 loanApplication

| field             | type         | 允许空 | 缺省值 | description           |
| ----------------- | ------------ | ------ | ------ | --------------------- |
| loanApplicationID | INT          | 否     | 自增   | 主键                  |
| userID            | INT          | 否     | 无     |                       |
| amount            | DECIMAL      | 否     | 无     | 意愿借款数额          |
| certificationCode | varchar(255) | 否     | 无     | 社会统一认证代码      |
| registrationCode  | varchar(255) | 否     | 无     | 注册码                |
| companyName       | varchar(255) | 否     | 无     | 公司名称              |
| phoneNumber       | varchar(255) | 否     | 无     | 贷款人联系电话        |
| hasDealt          | INT          | 否     | 0      | 借款方完成贷款时置为1 |

### 2.8 FileInfo

记录用户上传的文件信息

| field      | type         | 允许空 | 缺省值 |          description |
| ---------- | ------------ | ------ | ------ | -------------------: |
| fileID     | INT          | 否     | 自增   |                 主键 |
| userID     | INT          | 否     | 无     |     上传该文件的用户 |
| fileName   | varchar(255) | 否     | 无     |               文件名 |
| filePath   | varchar(255) | 否     | 无     | 服务器存储文件的路径 |
| uploadTime | varchar(255) | 否     | 无     |             上传时间 |

## 3. 附录

### 3.1 数据库建表sql文件

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

