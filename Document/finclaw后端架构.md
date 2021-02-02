# finclaw后端架构

## 1. VO&PO包

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
	private Integer userID;//因为现在默认一个银行/数据提供方只有一个账号，就直接用userID来标识一个数据提供方了
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
	private String modelVerion;//和mid一起标识当前版本模型
	private String modelName;//在load_bind时需要指明，predict时是使用mname来进行标识
}
```

#### 1.1.3 浏览贷款申请相关

见1.3.1

#### 1.1.4 放贷相关

##### 1.1.4.1 LendingForm

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

##### 1.1.4.2 LendingHistoryVO

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

##### 1.1.4.3 LendingHistory

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

#### 1.3.2 放贷情况查看相关

与1.1.4相同

#### 1.3.3 接受贷款

与1.1.4相同



### 1.4 平台工作人员用例

#### 1.4.1 资料认证相关

参考文件处理和登录功能

#### 1.4.2 使用监控

暂时没写

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

#### 1.5.2 认证资料上传相关

感觉应该没有记录文件信息的必要了？只要写文件上传就行？

#### 1.5.3 账户管理相关

##### 1.5.3.1 UserForm

```
public class UserForm {
    private String email;
    private String username;
    private String phoneNumber;
}
```

##  2. 数据库设计

### 2.1 user表

| field       | type         | description                   |
| ----------- | ------------ | ----------------------------- |
| userID      | INT          | 用户的ID号（唯一）            |
| email       | varchar(255) | 用户邮箱                      |
| password    | varchar(255) | 用户密码                      |
| username    | varchar(255) | 用户名称                      |
| phoneNumber | varchar(255) | 用户手机号                    |
| role        | varchar(255) | 用户角色(4+1，还有未认证用户) |

### 2.2 project表

| field       | type         | description                            |
| ----------- | ------------ | -------------------------------------- |
| projectID   | INT          | 项目编号                               |
| userID      | INT          | 创建项目的用户                         |
| projectName | varchar(255) | 项目名称                               |
| description | varchar(255) | 项目描述                               |
| startTime   | timestamp    | 项目的开始时间                         |
| endTime     | timestamp    | 项目的结束时间                         |
| status      | varchar(255) | 项目的状态，尚未开始or正在运行or已结束 |
| modelID     | INT          | 一个项目对应一个model                  |

### 2.3 attendance表

记录合作企业参加了哪些项目

| field     | type | description                          |
| --------- | ---- | ------------------------------------ |
| userID    | INT  | 数据提供方的账号ID                   |
| projectID | INT  | 项目代号                             |
| isChosen  | INT  | 银行是否选择这个数据提供方的数据训练 |
| isReady   | INT  | 数据提供方是否准备好数据             |

### 2.4 model表

记录项目对应的模型的信息，主要记录的是submit后返回的model_id,model_version,job_id等信息，用于后续load_bind和predict操作

| field        | type         | description                    |
| ------------ | ------------ | ------------------------------ |
| modelID      | INT          | 主键                           |
| mid          | varchar(255) | 和modelVersion一起标识模型版本 |
| modelVersion | varchar(255) | 和mid一起标识模型版本          |
| modelName    | varchar(255) | 模型名称，predict时要用        |

### 2.5 lendingHistory表

| field            | type         | description              |
| ---------------- | ------------ | ------------------------ |
| lendingHistoryID | INT          | 借款记录的标识           |
| bankID           | INT          | 借款银行的userID         |
| lenderID         | INT          | 借款方的userID           |
| bankName         | varchar(255) | 借款银行的名称           |
| amount           | DECIMAL      | 意愿借款数额             |
| interestRate     | DECIMAL      | 年利率                   |
| phoneNumber      | varchar(255) | 银行联系电话             |
| hasDealt         | INT          | 借款方完成贷款时置为true |

### 2.6 serverInfo表

| field          | type         | description                                                  |
| -------------- | ------------ | ------------------------------------------------------------ |
| userID         | INT          | 一个用户可能用不同的服务器参见不同项目，userID和projectID共同构成主键 |
| projectID      | INT          |                                                              |
| ipAddress      | varchar(255) |                                                              |
| serverName     | varchar(255) |                                                              |
| serverPassword | varchar(255) |                                                              |
| filePath       | varchar(255) | 数据文件路径                                                 |

### 2.7 loanApplication

| field             | type         | description              |
| ----------------- | ------------ | ------------------------ |
| loanApplicationID | INT          | 主键                     |
| userID            | INT          |                          |
| amount            | DECIMAL      | 意愿借款数额             |
| certificationCode | varchar(255) | 社会统一认证代码         |
| registrationCode  | varchar(255) | 注册码                   |
| companyName       | varchar(255) | 公司名称                 |
| phoneNumber       | varchar(255) | 贷款人联系电话           |
| hasDealt          | INT          | 借款方完成贷款时置为true |

## 3. Controller包设计

### 统一说明

- 建议键值放在路径中传参，且放在路径最后；
  - 示例：**url:** /api/account/getUserInfo/{userID}
- 其余信息通过RequestParam和RequestBody等传递

### 3.1 AccountController

#### 3.1.1 登陆(改动)

**url:** /api/account/login

**将原来的参数UserForm改为UserLoginForm**

```
public ResponseVO login(@RequestBody UserLoginForm userLoginForm);
```

#### 3.1.2 注册(新增？)

**url:** /api/account/register

```
public ResponseVO login(@RequestBody UserRegisterForm userRegisterForm);
```

#### 3.1.3 获取个人信息

**url:** /api/account/getUserInfo/{userID}

```
public ResponseVO getUserInfo(@PathVariable int userID);
```

#### 3.1.4 修改个人信息(不变)

**url:** /api/account/updateUserInfo/{usreID}

```
public ResponseVO updateUserInfo(@PathVariable int userID,@RequestBody UserForm userForm);
```

#### 3.1.5 修改个人密码(不变)

**url:** /api/account/udpatePassword/{userID}

```
public ResponseVO updatePassword(@PathVariable int userID, @RequestParam String oldPassword, @RequestParam String newPassword);
```

#### 3.1.6 认证身份(新增)

用户注册后是非认证状态，只能使用最基本功能，上传资料管理员认证通过后授予身份认证

**url:** /api/account/registerIdentity/{userID}

```
public ResponseVO registerIdentity(@PathVariable int userID,@RequestParam int role);
```

#### 删除

- 注册数据管理员
  - **url:** /api/account/registerDataManager
- 注册合作企业账号
  - **url:** /api/account/registerCooperation
- 删除数据管理员
  - **url:** /api/account/deleteUser
- 获取所有数据管理员
  - **url:** /api/account/getAllDataManagers



### 3.2 ProjectController

#### 3.2.1 添加项目(不变)

**url:** /api/project/addProject

```java
public ResponseVO addProject(@RequestBody ProjectForm projectForm);
```

#### 3.2.2 删除项目(不变)

**url:** /api/project/deleteProject

```java
public ResponseVO deleteProject(@RequestParam Integer projectID);
```

根据项目的ID来删除某一个项目

#### 3.2.3 修改项目信息(改动)

将参数ProjectVO改为ProjectForm

**url:** /api/project/modifyProject/{projectID}

```java
public ResponseVO modifyProject(@PathVariable int projectID, @RequestBody ProjectForm projectForm);
```

#### 3.2.4 查看所有项目 (不变)

**url:** /api/project/getAllProjectInfo

```java
public ResponseVO getAllProject();
```

#### 3.2.5 查看某个项目的信息 (不变)

**url:** /api/project/getProjectInfo/{projectID}

```java
public ResponseVO getProjectInfo(@PathVariable Integer projectID);
```

### 3.3 CooperationController 

大部分是在处理attendance的数据，感觉改成叫AttendanceController更好，但是之前已经写好了，接着

之前是合作方的功能，现在数据提供方沿用

#### 3.3.1 加入项目 

**url:** /api/cooperation/attendProject/{projectID}/{cooperationID}

```java
public ResponseVO attendProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) 
```

#### 3.3.2 退出项目 

**url:** /api/cooperation/quitProject/{projectID}/{cooperationID}

```java
public ResponseVO quitProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID)
```

#### 3.3.3 更改服务器信息 (改动)

url改动，参数改动

**url:** /api/cooperation/updateServerInfo

```java
public ResponseVO updateServerInfo(@RequestBody ServerInfoForm serverInfoForm )
```

数据提供方填好表单后上传服务器的相关信息，包括ip地址，root账户名，密码，文件存储地址

#### 3.3.4 数据提供方设置自己信息准备状态

**url:** /api/cooperation/setReadyStatus/{projectID}/{cooperationID}

```java
public ResponseVO setReadyStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID，@RequestParam boolean isReady )
```

数据提供方确认自己的数据已经准备好后就设置attendance中相关记录isReady为true

#### 3.3.5 查看某个数据提供方参加的所有项目 (不变)

**url:** /api/cooperation/getAllAttendedProjects/{cooperationID}

```java
public ResponseVO getAllAttendedProjects(@PathVariable Integer cooperaitonID);
```

#### 3.3.6 查看某个数据提供方参与某项目的服务器信息(新增)

**url:** /api/cooperation/getServerInfo/{projectID}/{cooperationID}

```
public ResponseVO getServerInfo(@PathVariable Integer projectID, @PathVariable Integer cooperationID);
```

返回值包裹的是ServerInfoVo

#### 3.3.7 查看某个项目的所有数据提供方(移动)

这个api之前在ProjectController那里实现，感觉应该移过来

**url:** /api/cooperation/getProjectCooperation/{projectID}

```java
public ResponseVO getProjectCooperation(@PathVariable Integer projectID);
```

#### 3.3.8 设置是否采用某数据提供方的数据(新增)

现在的处理方式是数据提供方申请加入项目时直接同意，然后用attendance表中的isChosen来标识项目是否采纳该数据提供方数据

**url:** /api/cooperation/setChosenStatus/{projectID}/{cooperationID}

```
public ResponseVO setChosenStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID，@RequestParam boolean isChosen )
```



### 3.4 LendingController(新增)

#### 3.4.1 提交贷款意愿

银行可以浏览到在平台上借款的小微企业的借款列表，然后可以为某个借款请求提交贷款意愿，需要填写的信息见LendingForm

**url:** /api/lending/addLendingForm

```
public ResponseVO addLendingForm(@RequestBody LendingForm lendingForm);
```

#### 3.4.2 查看某银行在平台的所有贷款记录

**url:** /api/lending/getBankLendingHistory/{bankID}

```
public ResponseVO getBankLendingHistory(@PathVariable Integer bankID);
//bankID就是银行的userID
```

#### 3.4.3 查看某条贷款记录

**url:** /api/lending/getLendingHistory/{lendingHistoryID}

```
public ResponseVO getLendingHistory(@PathVariable Integer lendingHistoryID);
```

#### 3.4.4 设置某贷款记录的处理情况为已处理

银行发布的贷款意愿被用户采纳后置为将hasDealt置为true

**url:** /api/lending/setDealt/{lendingHistoryID}

```
public ResponseVO setDealt(@PathVariable Integer lendingHistoryID);
```

### 3.5 LoanController(新增)

#### 3.5.1 提交贷款申请

**url:** /api/loan/addLoanApplication

```
public ResponseVO addLoanApplication(@RequestBody LoanApplicationForm loanApplicationForm);
```

#### 3.5.2 取消贷款申请

**url:** /api/loan/deleteLoanApplication/{loanApplicationID}

```
public ResponseVO deleteLoanApplication(@PathVariable Integer loanApplicationID);
```

#### 3.5.3 查看所有贷款申请记录

**url:** /api/loan/getAllLoanApplication/{userID}

```
public ResponseVO getAllLoanApplication(@PathVariable Integer userID);
```

#### 3.5.4 查看某条贷款申请记录

**url:** /api/loan/getLoanApplication/{loanApplicationID}

```
public ResponseVO getLoanApplication(@PathVariable Integer loanApplicationID);
```

#### 3.5.5 设置某贷款申请为已处理

**url:** /api/loan/setDealt/{loanApplicationID}

```
public ResponseVO setDealt(@PathVariable Integer loanApplicationID);
```

#### 3.5.6 查看某小微企业获得的所有贷款记录

只有hasDealt为true才是完成贷款的记录

**url:** /api/loan/getUserLoanHistory/{userID}

```
public ResponseVO getUserLoanHistory(@PathVariable Integer userID);
```

### 3.6 FileController

### 3.7 ModelController