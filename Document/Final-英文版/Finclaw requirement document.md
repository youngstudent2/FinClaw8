# Finclaw Requirement Document

## 1. Introduction

### 1.1 Objective

​	This document describes the functional and non functional requirements of Finclaw platform system. Finclaw platform is a credit risk management system for small and micro enterprises based on federal learning. Its core goal is to provide decentralized federal learning data encryption sharing framework, efficient and advanced credit rating algorithm prediction and optimization of credit strategy for small and micro enterprises, and to provide integrated credit rating services and loan services based on Citi API for small and micro enterprises.

​	This document will be used as the basis for the subsequent development and verification work of the development team.

### 1.2 Range

​		本文档描述了Finclaw平台系统的需求说明，涉及的功能包括用户的登录注册，认证资料上传，账户管理；银行工作人员的项目管理，信用评级策略管理，浏览贷款申请，发放贷款；数据提供方的服务器信息管理，项目管理；小微企业的申请借款，借贷情况查看，接受贷款；以及平台工作人员的资料认证和使用监控。

### 1.3 Reference

1. ErYuDing, QinLiu.  *Computing and Software Engineering (Volume 2)*
2. BinLuo.  *Modeling and Analysis of Requirements Engineering Software*
3. IEEE Standard

### 1.4 Document Organization

​	This document is organized according to the user category, and lists the user requirements, use case descriptions and front-end and back-end interaction interfaces involved in each module of four types of users (bank staff, data providers, small and micro enterprises, platform staff), and specifies the external interface, performance requirements, constraints, quality attributes and so on in the development.

## 2. General Description

### 2.1 Business Requirements

BR1：Combined with the latest federal learning algorithm, the whole process of encrypting and sharing data training model of multiple financial institutions and data institutions and the whole process of credit rating of small and micro enterprises are realized.

BR2：Under the same amount of money, banks can make loan risk rating + income rating for small and micro enterprises in different investment ways, so as to provide choices for banks.

BR3：Study the way COVID-19 small and micro businesses make loans through Citigroup API.

BR4：This paper studies the methods to reduce the financing cost dilemma of small and micro enterprises and improve their own credit rating.

BR5：System design optimization in the case of big data.

### 2.2 Project Function

The main functions of the Finclaw platform are as follows：

FE1：Users with different roles can register on the platform and be authenticated by the platform administrator.

FE2：Bank staff can create, modify and manage federal learning projects on the platform.

FE3：Data providers are free to join different federal learning programs to provide data for training programs.

FE4：小微企业主可以在平台上进行贷款申请，平台将贷款申请转发至。

FE5：Platform staff can view the usage of each user on the platform and block the accounts of users with suspicious behaviors.

### 2.3 User Characteristics

|     User     | Characteristics |
| :----------: | --------------- |
|     银行     |                 |
|  数据提供方  |                 |
|   小微企业   |                 |
| 平台工作人员 |                 |

### 2.4 Constraint

CON1：The system needs a web interface.

CON2：In the development, the developer should submit the use case document, software requirement specification document, software architecture description document, software detailed design description document and test report of hotel reservation system.

CON3：The project is developed in a way of continuous integration.

CON4：The project will use Spring Boot and MyBatis as the back-end framework and Vue as the front-end development.

### 2.5 Hypothesis and Dependence

AE1：The exception beyond the scope of the system will be handled by manual intervention.

AE2：Our server can handle all the requests of potential users and store all the data of buried points.

AE3：The network is smooth, when the client communicates with the server, there will be no network abnormalities such as disconnection.

## 3. 详细需求描述

### 3.1 对外接口

#### 3.1.1 用户界面 ==TODO：放截图==



### 3.2 用例描述

#### 3.2.1 用例图

![](..\pic\用例\Finclaw用例图.png)

#### 3.2.2 用例列表

##### 3.2.2.1 银行

1. 项目管理
2. 信用评级策略管理
3. 浏览贷款申请
4. 发放贷款

##### 3.2.2.2 数据提供方

1. 服务器信息管理
2. 项目管理

##### 3.2.2.3 借款小微企业

1. 申请借款
2. 借贷情况查看
3. 接受贷款

##### 3.2.2.4 平台工作人员

1. 资料认证
2. 使用监控

##### 3.2.2.5 公共部分

1. 登录注册
2. 认证资料上传
3. 账户管理

#### 3.2.3 详细用例描述

##### 3.2.3.1 银行

###### 3.2.3.1.1 项目管理

- ID：AUR1

- 名称：项目管理

- 优先级：高

- 参与者：银行工作人员

- 触发条件：银行工作人员选择进行项目管理

- 前置条件：银行工作人员已经登录并被授权

- 后置条件：系统记录项目更新后的情况，并在平台上进行更新

- 正常流程：

  1. 银行工作人员选择进行项目管理
  2. 系统展示所有已有的项目
  3. 银行工作人员选择创建新的项目
  4. 系统跳转至创建项目页面
  5. 银行工作人员填写项目基本信息，并提交
  6. 系统审核信息完整性，存储并在平台发布创建的项目

- 扩展流程：

  1a. 银行工作人员选择进行项目信息修改
  	1. 系统展示选择修改的项目的原有信息
  	2. 银行工作人员修改项目信息并提交
  	3. 跳转至正常流程6

  1b. 银行工作人员选择删除某个项目

  1. 系统将项目从平台中删除，并通知所有已经参与该项目的合作方

  6a. 工作人员填写的信息不完整

  1. 系统提示信息缺失，并要求用户继续填写，跳转至正常流程5

- 业务规则：

  BR1：创建项目需要填写的基本信息包含项目名称、项目描述、报名截止时间

- 特殊需求：无

###### 3.2.3.1.2 信用评级策略管理

- ID：AUR2

- 名称：信用评级策略管理

- 优先级：高

- 参与者：银行工作人员

- 触发条件：银行工作人员选择进行信用评级策略管理

- 前置条件：银行工作人员已经登录并被授权

- 后置条件：系统保存更新后的信用评级策略

- 正常流程：

  1. 银行工作人员选择进行信用评级策略管理
  2. 系统展示已有的信用评级策略
  3. 银行工作人员修改信用评级策略具体信息并提交
  4. 系统保存修改后的信用评级策略

- 扩展流程：

  1a. 银行工作人员选择的是创建新的信用评级策略

  1. 系统展示一个新的信用评级策略表单，回到正常流程3

  4a. 银行工作人员填写的信息不完整

  1. 系统提示信息不完整并要求银行工作人员重新填写，回到正常流程3

- 业务规则：无

- 特殊需求：无

###### 3.2.3.1.3 浏览贷款申请

- ID：AUR3

- 名称：浏览贷款申请

- 优先级：高

- 参与者：银行工作人员

- 触发条件：银行工作人员选择浏览所有贷款申请

- 前置条件：银行工作人员已经登录并被授权

- 后置条件：无

- 正常流程：

  1. 银行工作人员选择进行贷款申请
  2. 系统展示平台上的所有贷款申请以及申请贷款的小微企业的信用评分
  3. 银行工作人员选择查看某个贷款申请的小微企业的情况
  4. 系统展示该小微企业的具体情况

- 扩展流程：

  1a. 银行工作人员选择按照申请贷款的小微企业的信用评分的高低进行排序

  1. 系统将申请按照小微企业的信用评分排序进行展示

  1b. 银行工作人员选择按照申请贷款的金额数目进行排序

  1. 系统将申请按照贷款额度进行排序后展示

- 业务规则：无

- 特殊需求：无

###### 3.2.3.1.4 发布贷款

- ID：AUR4

- 名称：发布贷款

- 优先级：高

- 参与者：银行工作人员

- 触发条件：银行工作人员选择进行贷款发布

- 前置条件：银行工作人员已经登录并被授权

- 后置条件：系统将银行发放贷款的信息发送给申请贷款的小微企业

- 正常流程：

  1. 银行工作人员选择为某个贷款申请发放贷款
  2. 系统提示银行工作人员输入密码进行身份验证
  3. 银行工作人员输入密码
  4. 系统验证成功后，将发放贷款的信息发送给申请贷款的小微企业

- 扩展流程：

  4a. 若银行工作人员输入的密码错误

  1. 系统提示密码错误，并要求银行工作人员重新输入，若错误超过5次，则冻结账号

- 业务规则：无

- 特殊需求：无

##### 3.2.3.2 数据提供方

###### 3.2.3.2.1 服务器信息管理

- ID：BUR1

- 名称：服务器信息管理

- 优先级：高

- 参与者：各个数据提供方

- 触发条件：数据提供方进入服务器信息管理界面

- 前置条件：该数据提供方已经通过了资料认证

- 后置条件：更新该数据提供方的服务器信息

- 正常流程：

  1. 数据提供方进入服务器信息管理界面
  2. 系统显示该数据提供方填写的服务器资料 
  3. 数据提供方重新编辑自己的服务器信息，并点击确认
  4. 保存并更新该数据提供方的服务器信息

- 扩展流程：

  3a. 填写的服务器信息不符合数据规范
	4. 系统提示修改失败，要求重新规范填写
3b. 服务器信息必填项未填写
	4. 系统提示修改失败，提示填写必要的服务器信息

- 业务规则：无
- 特殊需求：无

###### 3.2.3.2.2 项目管理

- ID：BUR2

- 名称：项目管理

- 优先级：高

- 参与者：数据提供方

- 触发条件：数据提供方进入项目管理界面

- 前置条件：该数据提供方已经通过了资料认证

- 后置条件：系统更新该数据提供方参与项目的情况

- 正常流程：

  1. 数据提供方进入项目管理界面
  2. 系统显示平台上银行发起的各个训练项目的信息
  3. 数据提供方选择自己要参与的项目并确认参加
  4. 系统检查该数据提供方的资质和权限，将其纳入项目参与者，自动进入服务器信息管理

- 扩展流程：

  3a. 数据提供方选择退出自己参与的某个项目

    4. 系统将其从项目参与者中排除

  4a. 该数据提供方资质和权限不符合项目要求

  ​	5. 系统提示数据提供方不符合相关资质，项目参与失败


##### 3.2.3.3 借款小微企业

###### 3.2.3.3.1 申请借款

- ID：CUR1

- 名称：申请借款

- 优先级：高

- 参与者：借款小微企业、银行

- 触发条件：小微企业用户申请借款

- 前置条件：小微企业用户已经注册并登陆，且身份认证通过了平台审核

- 后置条件：系统保存企业的申请记录

- 正常流程：

  1. 小微企业用户在[主页]点击[借款]
  2. 系统进入可借款银行页面
  3. 小微企业用户选择要借款的银行
  4. 系统进入银行的借贷详情页面
  5. 小微企业查看详情后，选择借款额度
  6. 系统提交借款申请给目标银行

- 扩展流程：

  ​		5a.小微企业用户了解详情后放弃在此银行借贷

  ​			1.系统返回可借款银行页面

- 业务规则：

  BR1：如果小微企业的信用评分低于银行要求，则不能向该银行发起借款申请。

  BR2：小微企业的借款申请需要在15日内处理，逾期未处理的视为过期申请，状态变为无效。

- 特殊需求：无

###### 3.2.3.3.2 借贷情况查看

- ID：CUR2

- 名称：借贷情况查看

- 优先级：高

- 参与者：借款小微企业

- 触发条件：小微企业用户查看自身贷款情况

- 前置条件：小微企业用户已经登陆

- 后置条件：无

- 正常流程：

  1. 小微企业用户在[我的]页面点击[借贷情况]
  2. 系统进入借贷情况页面
  3. 小微企业用户查看某次借贷详细情况
  4. 系统返回借贷详情
  5. 小微企业用户选择[返回]或关闭窗口
  6. 系统返回上一级页面或退出

- 扩展流程：

  ​		无

- 业务规则：

  BR1：借贷记录中应保持业务所需要的所有字段信息

- 特殊需求：

  SR1：小微企业用户需要看到记录中借贷、还款的状态

###### 3.2.3.3.3 接受贷款

- ID：CUR3

- 名称：接受贷款

- 优先级：高

- 参与者：借款小微企业、银行

- 触发条件：银行同意小微企业的贷款申请

- 前置条件：小微企业用户已经登陆

- 后置条件：系统记录此次贷款操作

- 正常流程：

  1. 小微企业用户查看贷款申请
  2. 系统进入贷款申请详情页
  3. 小微企业用户确认接受贷款
  4. 系统弹出窗口进行二次确认
  5. 小微企业用户点击确认
  6. 系统执行贷款操作，并向小微企业用户和银行发送贷款成功提醒，系统记录此次贷款

- 扩展流程：

  ​		3a.小微企业用户拒绝接受贷款

  ​			1.系统弹出窗口进行二次确认

  ​			2.小微企业用户点击[确定]

  ​			3.系统执行取消贷款操作，并向小微企业用户和银行发送				取消贷款提醒

  ​		5a.小微企业用户点击取消

  ​			1.系统回到贷款申请详情页

- 业务规则：

  BR1：接受贷款后，银行需要在3个工作日内将资金打到用户的账号中

  BR2：用户需在规定日期前归还贷款，否则每日需要加收贷款总额1%的超期罚款

- 特殊需求：

  SR1：系统自动计算当前借贷项中需要还款的金额

##### 3.2.3.4 平台工作人员

###### 3.2.3.4.1 资料认证

- ID：DUR1

- 名称：资料认证

- 优先级：高

- 参与者：平台工作人员

- 触发条件：平台工作人员进入资料认证界面

- 前置条件：银行资料已提交

- 后置条件：更新银行账号的认证状态

- 正常流程：

  1. 平台工作人员进入资料认证界面
  2. 系统显示待认证的银行信息列表
  3. 平台工作人员核实认证信息
  4. 平台工作人员更改银行的认证状态为“已认证”
  5. 系统保存修改并更新显示待认证的银行信息列表

- 扩展流程：

  3a. 银行提供的认证信息不符合要求

  4. 平台工作人员更改银行的认证状态为“认证失败”

- 业务规则：无

- 特殊需求：无

###### 3.2.3.4.2 使用监控

- ID：DUR2

- 名称：使用监控

- 参与者：平台工作人员

- 触发条件：平台工作人员进入使用监控界面

- 前置条件：无

- 后置条件：系统显示用户操作记录

- 正常流程：

  1. 平台工作人员进入使用监控界面
  2. 系统显示操作记录列表

- 扩展流程：

  3a. 平台工作人员筛选操作类型

  4. 系统显示属于对应类型的操作记录

  3b. 平台工作人员筛选操作日期

  4. 系统显示在所选时间范围内的操作记录


##### 3.2.3.5 Common part

###### 3.2.3.5.1 Sign In/Up

- ID: 1

- Name: Sign In/Up

- Priority: High

- Participant: Bank、Data Provider、Small and micro enterprises

- Triggering Conditions: User chooses to sign in or sign up

- Preconditions: none

- Postconditions: The system records the user's information

- Normal Process：

  1. User chooses to sign in or sign up
  2. User chooses to sign up and choose one type of account.
  3. User enters registration information
  4. User uploads some files for authentication
  5. Signing up will be completed when the user passes the authentication
  6. User choose to sign in
  7. User will see the main page when signs in successfully 

- Extra Process：

  2a. The user has signed up

  1. Jump to Normal Process 6

  5a. The user failed to pass the authentication

  1. Jump to Normal Process 4

  7a. The user failed to sign in

  1. Jump to Normal Process 6

- Business Rules：

  BR1: Both signing in and signing up require verification code

  BR2: The types of accounts include banks, data providers, and small and micro borrowing companies

- Special Requirements: none

###### 3.2.3.5.2 Upload files for authentication

- ID: 2

- Name: Upload files for authentication

- Priority: High

- Participant: Bank、Data Provider、Small and micro enterprises、platform staff

- Triggering Conditions: User chooses to upload files for authentication

- Preconditions: none

- Postconditions: The system saves the files

- Normal Process：

  1. User chooses to upload files for authentication
  2. User uploads files
  3. Platform staff review the files uploaded by the user
  4. The user passes the authentication

- Extra Process：

  4a. The user failed to pass the authentication

  1. Jump to Normal Process 2, the user needs to upload proper files

- Business Rules: none

- Special Requirements: none

###### 3.2.3.5.3 Account Management

- ID: 3

- Name: Account Management

- Priority: High

- Participant: Bank、Data Provider、Small and micro enterprises

- Triggering Conditions: User chooses to modify account information

- Preconditions: none

- Postconditions: The system saves the new information

- Normal Process：

  1. User chooses to modify account information
  2. User modifies account information
  3. The system saves the new information

- Extra Process：

  2a. User chooses to change password

  1. User enters the old password

  2. If the old password is correct, the user needs to enter new password and confirm it

     2i. The old password is not correct

     1. Jump to Extra Process 2a

  2b. User choose to modify contact information

  1. User enters new contact information and confirm it

- Business Rules: none

- Special Requirements: none

#### 3.2.4 System sequence diagram 

##### 3.2.4.1 Bank

###### 3.2.4.1.1 Project management

![系统顺序图-项目管理](..\pic\用例\系统顺序图-项目管理.png)

###### 3.2.4.1.2 Credit rating strategy management

![系统顺序图](..\pic\用例\系统顺序图-信用评级策略管理.png)

###### 3.2.4.1.3 Browse loan applications

![系统顺序图-浏览贷款申请](..\pic\用例\系统顺序图-浏览贷款申请.png)

###### 3.2.4.1.4 Release loan![系统顺序图-发放贷款](..\pic\用例\系统顺序图-发放贷款.png)

##### 3.2.4.2 Data provider

###### 3.2.4.2.1 Server information management

![服务器信息管理](..\pic\用例\服务器信息管理.png)

###### 3.2.4.2.2 Project management

![数据提供方项目管理](.\pic\用例\数据提供方项目管理.png)

##### 3.2.4.3 Small and micro enterprises

###### 3.2.4.3.1 Apply for a loan

![小微企业1](E:\Competition\花旗杯\finclaw\Document\pic\用例\小微企业1.png)

![小微企业11](..\pic\用例\小微企业11.png)

###### 3.2.4.3.2 Checking the status of the loan application

![小微企业2](..\pic\用例\小微企业2.png)

![小微企业22](..\pic\用例\小微企业22.png)

###### 3.2.4.3.3 Accept the loan

![小微企业3](..\pic\用例\小微企业3.png)

![小微企业33](..\pic\用例\小微企业33.png)

##### 3.2.4.4 Platform staff

###### 3.2.4.4.1 Authentication

![](..\pic\用例\资料认证.png)

###### 3.2.4.4.2 Usage monitoring

![](..\pic\用例\使用监控.png)

##### 3.2.4.5 Common part

###### 3.2.4.5.1 Sign in/up

 ![](..\pic\用例\登录注册-E.png)





###### 3.2.4.5.2 Upload files for authentication![](..\pic\用例\认证资料上传.png)


###### 3.2.4.5.3 Account management 

![](..\pic\用例\账户管理-E.png)

### 3.3 Interfaces between front end and back end

#### 3.3.1 VO&PO

**Note：**

- *Form Objects used to fill out forms, such as registration information
- *VO used to return information of an object
- *PO used to interact with the database

##### 3.3.1.1 Bank cases

###### 3.3.1.1.1 Project management related

**ProjectForm**

```java
public class ProjectForm{
	private Integer userID;//ID of the user 
    private String projectName;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

**ProjectVO**

```java
public class ProjectVO{
	private Integer projectID;
	private Integer userID;//ID of the user 
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

**Project**

```java
public class Project{
	private Integer projectID;
	private Integer userID;//ID of the user 
	private Integer modelID;//The model of the project
    private String projectName;
    private String description;
    private ProjectStatus status;
    private Timestamp startTime;
    private Timestamp endTime;
}
```

**AttendanceVO**

```java
public class AttendanceVO{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;//Whether the bank chooses this data provider's data for training
	private boolean isReady;//Whether the data provider has prepared the data
}
```

**Attendance**

```java
public class Attendance{
	private Integer userID;
	private Integer projectID;
	private boolean isChosen;
	private boolean isReady;
}
```

###### 3.3.1.1.2 Federal learning related

**Model**

```java
public class Model{
	private Integer modelID;
	private String mid;
	private String modelVerion;//Identify the current version of the model together with mid
	private String modelName;//Need to be indicated when load_bind
}
```

###### 3.3.1.1.3 Browse loan application related

See 3.3.1.3.1

###### 3.3.1.1.4  Lending related

**LendingForm**

```java
public class LendingForm{
	private Integer bankID;//The userID of the bank
	private Integer lenderID；//The userID of the lender
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;
	private String phoneNumber;//Bank manager contact information
	private String description;//Loan description
}
```

**LendingHistoryVO**

```java
public class LendingHistoryVO{
	private Integer lendingHistoryID;
	private Integer bankID;//The userID of the bank
	private Integer lenderID；//The userID of the lender
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;
	private String phoneNumber;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

**LendingHistory**

```java
public class LendingHistory{
	private Integer lendingHistoryID;
	private Integer bankID;//The userID of the bank
	private Integer lenderID；//The userID of the lender
	private String bankName;
	private double amount;//Willing loan amount
	private double interestRate;
	private String phoneNumber;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

##### 3.3.1.2 Data provider cases

###### 3.3.1.2.1 Server information related

**serverInfoForm**

```java
//Each time you participate in a project, you must fill in the server information, because a user may use different servers to participate in different projects
public class serverInfoForm{
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;//File path of the data
}
```

**serverInfoVO**

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

**serverInfo**

```java
public class serverInfo{
    //A server can only use one ID to participate in one project, so use serverInfoID to identify
    private Integer serverInfoID;
	private Integer userID;
	private Integer projectID;
	private String ipAddress;
    private String serverName;
    private String serverPassword;
    private String filePath;
}
```

##### 3.3.1.3 Small and micro business cases

###### 3.3.1.3.1 Loan related

**LoanApplicationForm**

```java
public class LoanApplicationForm{
	private Integer userID;
	private double amount;
	private String phoneNumber;//Phonenumber of the lender
	private String certificationCode;//Social unified certification code
	private String registrationCode;
	private String companyName;
}
```

**LoanApplicationVO**

```java
public class LoanApplicationVO{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;
	private String phoneNumber;//Phonenumber of the lender
	private String certificationCode;//Social unified certification code
	private String registrationCode;
	private String companyName;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

**LoanApplication**

```java
public class LoanApplication{
	private Integer loanApplicationID;
	private Integer userID;
	private double amount;
	private String phoneNumber;//Phonenumber of the lender
	private String certificationCode;//Social unified certification code
	private String registrationCode;
	private String companyName;
	private boolean hasDealt;//Set to true when the borrower completes the loan
}
```

###### 3.3.1.3.2 Checking lending process related

See 3.3.1.1.4

###### 3.3.1.3.3 Accept loan

See 3.3.1.1.4

##### 3.3.1.4 Platform staff cases

###### 3.3.1.4.1 Data certification related

Reference file processing and login function

##### 3.3.1.5 Common part cases

###### 3.3.1.5.1 Sign in/up realted

**UserLoginForm**

```java
public class UserLoginForm {
    private String email;
    private String password;
}
```

**UserRegisterForm**

```java
public class UserRegisterForm {
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
    private UserType role;//account type
}
```

**UserVO**

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

**User**

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

###### 3.3.1.5.2 Account management related

**UserForm**

```java
public class UserForm {
    private String email;
    private String username;
    private String phoneNumber;
}
```

#### 3.3.2 Design of controller package 

**Notes**

- It is recommended that the key value be placed in the path to pass parameters, and placed at the end of the path;
  - eg：**url:** /api/account/getUserInfo/{userID}
- The rest of the information is passed through RequestParam and RequestBody, etc.

##### 3.3.2.1 AccountController

###### 3.3.2.1.1 login

**url:** /api/account/login

```java
public ResponseVO login(@RequestBody UserLoginForm userLoginForm);
```

###### 3.3.2.1.2 Register

**url:** /api/account/register

```java
public ResponseVO register(@RequestBody UserRegisterForm userRegisterForm);
```

###### 3.3.2.1.3 Get personal information

**url:** /api/account/getUserInfo/{userID}

```java
public ResponseVO getUserInfo(@PathVariable int userID);
```

###### 3.3.2.1.4 Modify Personal Information

**url:** /api/account/updateUserInfo/{usreID}

```java
public ResponseVO updateUserInfo(@PathVariable int userID,@RequestBody UserForm userForm);
```

###### 3.3.2.1.5 Change password

**url:** /api/account/udpatePassword/{userID}

```java
public ResponseVO updatePassword(@PathVariable int userID, @RequestParam String oldPassword, @RequestParam String newPassword);
```

###### 3.3.2.1.6 Authentication

**url:** /api/account/registerIdentity/{userID}

```java
public ResponseVO registerIdentity(@PathVariable int userID,@RequestParam int role);
```

###### 3.3.2.1.7 Get all users

**url:** /api/account/getAllUsers

```java
public ResponseVO getAllUsers();
```

###### 3.3.2.1.8 Get all unregistered users

**url:** /api/account/getUnauthorizedUsers

```java
public ResponseVO getUnauthorizedUsers();
```

##### 3.3.2.2 ProjectController

###### 3.3.2.2.1 Add a new project

**url:** /api/project/addProject

```java
public ResponseVO addProject(@RequestBody ProjectForm projectForm);
```

###### 3.3.2.2.2 Delete a project

**url:** /api/project/deleteProject

```java
public ResponseVO deleteProject(@RequestParam Integer projectID);
```

Delete a project based on the project ID.

###### 3.3.2.2.3 

**url:** /api/project/modifyProject/{projectID}

```java
public ResponseVO modifyProject(@PathVariable int projectID, @RequestBody ProjectForm projectForm);
```

###### 3.3.2.2.4 Modify project information

**url:** /api/project/getAllProjectInfo

```java
public ResponseVO getAllProject();
```

###### 3.3.2.2.5 View information about a project

**url:** /api/project/getProjectInfo/{projectID}

```java
public ResponseVO getProjectInfo(@PathVariable Integer projectID);
```

##### 3.3.2.3 AttendanceController

###### 3.3.2.3.1 Attend a project

**url:** /api/cooperation/attendProject/{projectID}/{cooperationID}

```java
public ResponseVO attendProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) 
```

###### 3.3.2.3.2 Exit a project

**url:** /api/cooperation/quitProject/{projectID}/{cooperationID}

```java
public ResponseVO quitProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID)
```

###### 3.3.2.3.3 Change server information

**url:** /api/cooperation/updateServerInfo

```java
public ResponseVO updateServerInfo(@RequestBody ServerInfoForm serverInfoForm )
```

The data provider uploads the relevant information of the server after filling out the form, including ip address, root account name, password and file path.

###### 3.3.2.3.4 The data provider sets its own information readiness status

**url:** /api/cooperation/setReadyStatus/{projectID}/{cooperationID}

```java
public ResponseVO setReadyStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID，@RequestParam boolean isReady )
```

After the data provider confirms that its data is ready, it sets the relevant record in the attendance isReady to true

###### 3.3.2.3.5 View all projects participated by a data provider

**url:** /api/cooperation/getAllAttendedProjects/{cooperationID}

```java
public ResponseVO getAllAttendedProjects(@PathVariable Integer cooperaitonID);
```

###### 3.3.2.3.6 View server information of a data provider participating in a project

**url:** /api/cooperation/getServerInfo/{projectID}/{cooperationID}

```java
public ResponseVO getServerInfo(@PathVariable Integer projectID, @PathVariable Integer cooperationID);
```

###### 3.3.2.3.7 View all data providers for a project

**url:** /api/cooperation/getProjectCooperation/{projectID}

```java
public ResponseVO getProjectCooperation(@PathVariable Integer projectID);
```

###### 3.3.2.3.8 Set whether to use data from a data provider

**url:** /api/cooperation/setChosenStatus/{projectID}/{cooperationID}

```java
public ResponseVO setChosenStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID，@RequestParam boolean isChosen )
```

##### 3.3.2.4 LendingController

###### 3.3.2.4.1 Submit loan intention

The bank can browse the list of small and micro enterprises's applications on the platform, and then submit the loan willingness for a loan request. The information to be filled in is shown in LendingForm

**url:** /api/lending/addLendingForm

```java
public ResponseVO addLendingForm(@RequestBody LendingForm lendingForm);
```

###### 3.3.2.4.2 View all lending records of a bank on the platform

**url:** /api/lending/getBankLendingHistory/{bankID}

```java
public ResponseVO getBankLendingHistory(@PathVariable Integer bankID);
```

###### 3.3.2.4.3 View a certain lending record

**url:** /api/lending/getLendingHistory/{lendingHistoryID}

```java
public ResponseVO getLendingHistory(@PathVariable Integer lendingHistoryID);
```

###### 3.3.2.4.4 Set the processing status of a lending record as processed

hasDealt is set to true after the user adopts the loan intention issued by the bank.

**url:** /api/lending/setDealt/{lendingHistoryID}

```java
public ResponseVO setDealt(@PathVariable Integer lendingHistoryID);
```

##### 3.3.2.5 LoanController

###### 3.3.2.5.1 Submit loan application

**url:** /api/loan/addLoanApplication

```java
public ResponseVO addLoanApplication(@RequestBody LoanApplicationForm loanApplicationForm);
```

###### 3.3.2.5.2 Cancel loan application

**url:** /api/loan/deleteLoanApplication/{loanApplicationID}

```java
public ResponseVO deleteLoanApplication(@PathVariable Integer loanApplicationID);
```

###### 3.3.2.5.3 View all loan application records

**url:** /api/loan/getAllLoanApplication/{userID}

```java
public ResponseVO getAllLoanApplication(@PathVariable Integer userID);
```

###### 3.3.2.5.4  View a record of a certain loan application

**url:** /api/loan/getLoanApplication/{loanApplicationID}

```java
public ResponseVO getLoanApplication(@PathVariable Integer loanApplicationID);
```

###### 3.3.2.5.5 Set a loan application as processed

**url:** /api/loan/setDealt/{loanApplicationID}

```java
public ResponseVO setDealt(@PathVariable Integer loanApplicationID);
```

###### 3.3.2.5.6 View all loan records obtained by a small and micro enterprise

**url:** /api/loan/getUserLoanHistory/{userID}

```java
public ResponseVO getUserLoanHistory(@PathVariable Integer userID);
```

