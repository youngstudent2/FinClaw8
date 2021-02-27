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

FE4：Small and micro business owners can apply for loans on the platform, and banks can see the loans of various small and micro businesses through the platform.

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

## 3. Detailed Requirement Description

### 3.1 External Interface

#### 3.1.1 User Interface ==TODO：放截图==



### 3.2 Use Case Description

#### 3.2.1 Use Case Diagram

![](..\pic\用例\用例图-E.png)

#### 3.2.2 Use Case List

##### 3.2.2.1 Bank

1. Project Management
2. Credit Rating Strategy Management
3. Browse Loan Applications
4. Loan Issuance

##### 3.2.2.2 Data Provider

1. Server Information Management
2. Project Management

##### 3.2.2.3 Small and Micro Enterprises Borrowing

1. Apply for a Loan
2. Check Loan Status
3. Accept the Loan

##### 3.2.2.4 Platform Staff

1. Data Authentication
2. Use Monitoring

##### 3.2.2.5 Common Part

1. Sign In/Up
2. Upload Files for Authentication
3. Account Management

#### 3.2.3 Detailed Use Case Description

##### 3.2.3.1 Bank

###### 3.2.3.1.1 Project Management

- ID：AUR1

- Name: Project Management

- Priority: High

- Participants: Bank staff

- Trigger Condition: bank staff choose to conduct project management

- Precondition: Bank staff has logged in and been authorized

- Post-condition: The system records the situation after the project is updated and updates it on the platform

- Normal Process:

  1. Bank staff choose project management
  2. The system displays all existing projects
  3. The bank staff chooses to create a new project
  4. The system jumps to the create project page
  5. The bank staff fills in the basic information of the project and submits it
  6. The system audits the integrity of the information, stores and publishes the created project on the platform

- Extra Process:

  1a. Bank staff choose to modify project information
    1. The system displays the original information of the selected item
    2. Bank staff modify the project information and submit it
    3. Jump to normal process 6

  1b. The bank staff chooses to delete an item

    1. The system deletes the project from the platform and informs all partners that have participated in the project

  6a. The information filled in by the staff is incomplete

    1. The system prompts that the information is missing and asks the user to continue to fill in, skip to the normal process 5

- Business Rules:

  BR1: The basic information that needs to be filled in to create a project includes the project name, project description, and deadline for registration

- Special Requirements: none

###### 3.2.3.1.2 Credit Rating Strategy Management

- ID：AUR2

- Name: Credit Rating Strategy Management

- Priority: High

- Participants: Bank staff

- Trigger Condition: Bank staff choose to manage credit rating strategy

- Precondition: Bank staff has logged in and been authorized

- Post-condition: The system saves the updated credit rating strategy

- Normal Process:

  1. Bank staff choose to manage credit rating strategies
  2. The system displays existing credit rating strategies
  3. Bank staff revise and submit specific information on credit rating strategy
  4. The system saves the revised credit rating strategy

- Extra Process:

  1a. The bank staff chose to create a new credit rating strategy

    1. The system displays a new credit rating strategy form and returns to the normal process 3

  4a. The information filled in by the bank staff is incomplete

    1. The system prompts that the information is incomplete and requires the bank staff to fill in again and return to the normal process 3

- Business Rules: none

- Special Requirements: none

###### 3.2.3.1.3 Browse Loan Applications

- ID: AUR3

- Name: Browse Loan Application

- Priority: High

- Participants: Bank staff

- Trigger Condition: Bank staff choose to browse all loan applications

- Precondition: Bank staff has logged in and been authorized

- Post-condition: None

- Normal Process:

  1. Bank staff choose to apply for loan
  2. The system displays all loan applications on the platform and the credit scores of small and micro enterprises applying for loans
  3. The bank staff chooses to view the status of a small and micro enterprise that has applied for a loan
  4. The system displays the specific situation of the small and micro enterprise

- Extra Process:

  1a. Bank staff choose to sort according to the credit scores of small and micro enterprises applying for loans

    1. The system will display the applications according to the credit scores of small and micro enterprises

  1b. Bank staff choose to sort according to the amount of loan application

    1. The system sorts the applications according to the loan amount and displays them

- Business Rules: none

- Special Requirements: none

###### 3.2.3.1.4 Loan Issuance

- ID: AUR4

- Name: Loan Issuance

- Priority: High

- Participants: Bank staff

- Trigger Condition: bank staff choose to issue loan

- Precondition: Bank staff has logged in and been authorized

- Post-condition: The system sends the information about the bank loan to the small and micro enterprises applying for the loan

- Normal Process:

   1. The bank staff chooses to grant a loan for a certain loan application
   2. The system prompts the bank staff to enter a password for identity verification
   3. The bank staff enters the password
   4. After the system is successfully verified, the loan issuance information will be sent to the small and micro enterprises applying for the loan

- Extra Process:

  4a. If the password entered by the bank staff is wrong

    1. The system prompts that the password is incorrect and asks the bank staff to re-enter it. If the error exceeds 5 times, the account will be frozen

- Business Rules: none

- Special Requirements: none

##### 3.2.3.2 Data Provider

###### 3.2.3.2.1 Server Information Management

- ID: BUR1

- Name: Server Information Management

- Priority: High

- Participants: Various data providers

- Trigger Condition: The data provider enters the server information management interface

- Precondition: The data provider has passed the data certification

- Post-condition: update the server information of the data provider

- Normal Process:

  1. The data provider enters the server information management interface
  2. The system displays the server information filled in by the data provider
  3. The data provider edits its own server information again and clicks OK
  4. Save and update the server information of the data provider

- Extra Process:

  3a. The entered server information does not meet the data specification
    4. The system prompts that the modification has failed, and it is required to re-standardize the filling
  3b. The required server information is not filled in
    4. The system prompts that the modification failed, and prompts to fill in the necessary server information

- Business Rules: none
- Special Requirements: none

###### 3.2.3.2.2 Project Management

- ID: BUR2

- Name: Project Management

- Priority: High

- Participant: Data Provider

- Trigger Condition: The data provider enters the project management interface

- Precondition: The data provider has passed the data certification

- Post-condition: the system updates the data provider’s participation in the project

- Normal Process:

  1. The data provider enters the project management interface
  2. The system displays the information of each training project initiated by the bank on the platform
  3. The data provider chooses the project he wants to participate in and confirms to participate
  4. The system checks the qualification and authority of the data provider, includes it as a project participant, and automatically enters the server information management

- Extra Process:

  3a. The data provider opts out of a project in which it participates

    4. The system excludes them from project participants

  4a. The qualifications and permissions of the data provider do not meet the project requirements

    5. The system prompts that the data provider does not meet the relevant qualifications, and the project has failed to participate

- Business Rules: none
- Special Requirements: none

##### 3.2.3.3 Small and Micro Enterprises Borrowing

###### 3.2.3.3.1 Apply for a Loan

- ID: CUR1

- Name: Apply for a Loan

- Priority: High

- Participants: Borrowing small and micro enterprises, banks

- Trigger Condition: small and micro enterprise users apply for loans

- Precondition: Small and micro enterprise users have registered and logged in, and their identity authentication has passed the platform audit

- Post-condition: The system saves the application records of the enterprise

- Normal Process:

  1. Small and micro enterprise users click [Borrow] on [Homepage]
  2. The system enters the loan bank page
  3. Small and micro enterprise users choose the bank to borrow
  4. The system enters the bank's loan details page
  5. After checking the details, small and micro enterprises select the loan amount
  6. The system submits the loan application to the target bank

- Extra Process:

  5a. Small and micro enterprise users give up borrowing from this bank after understanding the details

    1. The system returns to the borrowable bank page

- Business Rules:

  BR1: If the credit score of a small and micro enterprise is lower than the bank's requirement, it cannot initiate a loan application to the bank.

  BR2: The loan application of small and micro enterprises needs to be processed within 15 days, and the application that is not processed overdue is regarded as an expired application, and the status becomes invalid.

- Special Requirements: none

###### 3.2.3.3.2 Check Loan Status

- ID: CUR2

- Name: Check Loan Status

- Priority: High

- Participants: Borrowing small and micro enterprises

- Trigger Condition: Small and micro enterprise users check their loan status

- Precondition: Small and micro enterprise users have logged in

- Post-condition: None

- Normal Process:

   1. Small and micro enterprise users click on [Loan Status] on the [My] page
   2. The system enters the loan status page
   3. Small and micro enterprise users view the details of a certain loan
   4. The system returns loan details
   5. Small and micro enterprise users select [Return] or close the window
   6. The system returns to the previous page or exits

- Extra Process: None

- Business Rules:

   BR1: All the field information required by the business should be kept in the loan record

- Special Requirements:

   SR1: Small and micro enterprise users need to see the status of loans and repayments in the records

###### 3.2.3.3.3 Accept ths Loan

- ID: CUR3

- Name: Accept the Loan

- Priority: High

- Participants: Borrowing small and micro enterprises, banks

- Trigger Condition: the bank agrees to the loan application of small and micro enterprises

- Precondition: Small and micro enterprise users have logged in

- Post-condition: The system records this loan operation

- Normal Process:

  1. Small and micro enterprise users view loan applications
  2. The system enters the loan application details page
  3. Small and micro enterprise users confirm acceptance of loans
  4. The system pops up a window for secondary confirmation
  5. Small and micro enterprise users click to confirm
  6. The system executes the loan operation, and sends reminders of loan success to small and micro enterprise users and banks, and the system records the loan

- Extra Process:

  3a. Small and micro enterprise users refuse to accept loans

    1. The system pops up a window for secondary confirmation

  2. Small and micro enterprise users click [OK]

    3. The system executes the loan cancellation operation and sends a loan cancellation reminder to small and micro enterprise users and banks

  5a. Small and micro enterprise users click to cancel

    1. The system returns to the loan application details page

- Business Rules:

  BR1: After accepting the loan, the bank needs to transfer the funds to the user's account within 3 working days

  BR2: The user needs to repay the loan before the specified date, otherwise an overdue fine of 1% of the total loan amount will be charged daily

- Special Requirements:

  SR1: The system automatically calculates the amount that needs to be repaid in the current loan

##### 3.2.3.4 Platform Staff

###### 3.2.3.4.1 Data Authentication

- ID: DUR1

- Name: Data Certification

- Priority: High

- Participants: platform staff

- Trigger Condition: platform staff enter the data authentication interface

- Precondition: Bank information has been submitted

- Post-condition: update the verification status of the bank account

- Normal Process:

   1. Platform staff enter the data authentication interface
   2. The system displays a list of bank information to be verified
   3. Platform staff verify certification information
   4. The platform staff changes the bank's certification status to "certified"
   5. The system saves the changes and updates the list of bank information to be verified

- Extra Process:

  3a. The authentication information provided by the bank does not meet the requirements

    4. The platform staff changes the bank's certification status to "authentication failed"

- Business Rules: none

- Special Requirements: none

###### 3.2.3.4.2 Usage Monitoring

- ID: DUR2

- Name: Usage Monitoring

- Participants: platform staff

- Trigger Condition: platform staff enter the use monitoring interface

- Precondition: None

- Post-condition: the system displays user operation records

- Normal Process:

   1. Platform staff enter the use monitoring interface
   2. The system displays a list of operation records

- Extra Process:

  3a. Platform staff screening operation types

    4. The system displays the operation records belonging to the corresponding type

  3b. Platform staff screened the date of operation

    4. The system displays the operation records in the selected time range

- Business Rules: none

- Special Requirements: none

##### 3.2.3.5 Common part

###### 3.2.3.5.1 Sign In/Up

- ID: 1

- Name: Sign In/Up

- Priority: High

- Participant: Bank、Data Provider、Small and micro enterprises

- Triggering Conditions: User chooses to sign in or sign up

- Preconditions: none

- Post-conditions: The system records the user's information

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

- Post-conditions: The system saves the files

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

- Post-conditions: The system saves the new information

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

#### 3.2.4 System Sequence Diagram 

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

![](..\pic\用例\资料认证-E.png)

###### 3.2.4.4.2 Usage monitoring

![](..\pic\用例\使用监控-E.png)

##### 3.2.4.5 Common part

###### 3.2.4.5.1 Sign in/up

 ![](..\pic\用例\登录注册-E.png)





###### 3.2.4.5.2 Upload files for authentication

###### ![](..\pic\用例\认证资料上传-E.png)


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

