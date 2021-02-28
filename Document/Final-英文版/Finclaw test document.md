# Finclaw Test Document

[TOC]

### 1. Introduction

#### 1.1 Target

This document helps to achieve the following goals:
Determine the information of the existing project and the software components to be tested, list the recommended test requirements, recommend the test strategies, and explain these strategies, determine the required resources, estimate the workload of the test, and list the deliverable elements of the test project.

#### 1.2 Background

#### 1.3 Range

This document contains the tests of all the modules of FinClaw System, including Account package, Attendance package, Kubefate package, Lending package, Loan package, Project package and File package.

#### 1.4 References

《Software Testing》：Ron Patton，2005.08.05，Sams Publishing.

### 2. Test

#### 2.1 Account

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "3">user register</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> email has been used</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> empty register information</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">user login</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> username or password wrong</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view personal information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">modify password</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> original password wrong</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">modify personal information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the users' information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the Unauthorized users</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">delete user</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> user not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">user identity verification</td>
        <td> accept</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> reject</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>

#### 2.2 Attendance

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">attend project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">quit project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">upload server information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">set ready state</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">set selected state</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the attended projects</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view server information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the data providers of the selected project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view the </td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.3 Kubefate

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">start training</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">predict credit</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>

#### 2.4 Lending

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">bank manager can view the loan applications on the FinClaw platform and give willingness to them</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the lending history of a bank</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">view a specific lend application</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> record not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">get all the lending willigness of a loan application</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> loan application not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">user accepts the lending willigness of a bank</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>


#### 2.5 Loan

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">submit loan application</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">cancel loan application</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> loan application not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the loan applications</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">get all the loan applications</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">view a specific loan application</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> loan application not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">view all the lendings that a company gets</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> company not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    </tr>
    <tr>
        <td rowspan = "2">set a loan application be ready</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
	</tr>	
    <tr>
        <td> loan application not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>

#### 2.6 Project

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">add project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">delete project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> project not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">edit project's information</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> project not exist</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the projects</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view a specific project</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">view all the projects that a bank attends</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.7 File

<table>
    <tr>
        <th>Test Method</th>
        <th>Test Scene</th>
        <th>Test Result</th>
        <th>Reason for Test Fail</th>
    </tr>
    <tr>
        <td rowspan = "1">upload file</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
      <tr>
        <td rowspan = "1">view file list uploaded by user</td></td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
    	<td rowspan="1">download file</td>
        <td> success</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>


### 3. Summary


​                                                                                 

