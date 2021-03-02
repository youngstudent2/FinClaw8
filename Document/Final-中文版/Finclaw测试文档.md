# Finclaw测试文档

### 1.简介

#### 1.1目的

本文档有助于实现以下目标：
确定现有项目的信息和应测试的软件构件，列出推荐的测试需求（高级需求），推荐可采用的测试策略，并对这些策略加以说明，确定所需的资源，并对测试的工作量进行估计，列出测试项目的可交付元素。

#### 1.2背景


#### 1.3 范围

本文档覆盖FinClaw系统所有模块，包括Account包，Attendance包，Kubefate包，Lending包，Loan包，Project，File包的测试。

#### 参考资料

《Software Testing》：Ron Patton著，2005.08.05，Sams Publishing出版社。

### 2.测试

#### 2.1 Account

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "3">用户注册</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 邮箱已注册</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 注册信息为空</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">用户登录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 用户名或密码错误</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看个人信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">修改密码</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 原密码错误</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">修改个人信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看所有用户信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看所有未认证的用户信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">删除用户</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 用户不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">身份审核</td>
        <td> 同意</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 拒绝</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.2 Attendance

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">加入项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">退出项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">上传服务器信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">设置准备状态</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">设置选中状态</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看参与的所有项目信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看服务信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看指定项目的所有数据提供方</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看指定的参与信息</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.3 Kubefate

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">开始训练</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">预测信用评级</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>

#### 2.4 Lending

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">银行可以浏览到在平台上借款的小微企业的借款列表，然后为某个借款请求提交贷款意愿</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看某银行在平台的所有贷款记录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">查看某条贷款记录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 记录不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">根据所给的借贷申请编号（loanApplicationID）返回对应的银行借贷意愿表</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 申请不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">银行发布的贷款意愿被用户采纳</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
#### 2.5 Loan

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">提交贷款申请</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">取消贷款申请</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 申请不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看所有贷款申请记录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">获取所有的借贷申请</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">查看某条贷款申请记录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 申请不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">查看某小微企业获得的所有贷款记录</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 企业不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    </tr>
    <tr>
        <td rowspan = "2">设置某贷款申请为已处理</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
	</tr>	
    <tr>
        <td> 申请不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.6 Project

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">添加项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">删除项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 项目不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "2">编辑项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td> 项目不存在</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看所有项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看指定项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">查看指定银行参与的所有项目</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>
#### 2.7 File

<table>
    <tr>
        <th>测试方法</th>
        <th>测试情景</th>
        <th>测试结果</th>
        <th>测试失败原因</th>
    </tr>
    <tr>
        <td rowspan = "1">上传文件</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
        <td rowspan = "1">浏览已上传文件列表</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
    <tr>
    	<td rowspan="1">下载文件</td>
        <td> 成功</td>
        <td> pass</td>
        <td> </td>
    </tr>
</table>


### 3.总结

Finclaw业务层和数据层测试用例共计60个，Failure共计1个，Errors共计2个，Skipped共计0个。通过jacoco自动化测试覆盖率统计，我们获得了如下测试数据。

同时，我们支持自动化获得测试报告，具体方法为：通过maven运行install，在target/site/jacoco目录下得到index.html（即为finclaw的测试覆盖率报告）。

| Element    | Instructions Coverage | Branches Coverage | Method Coverage | Classes Coverage |
| ---------- | --------------------- | ----------------- | --------------- | ---------------- |
| account    | 75%                   | 63%               | 100%            | 100%             |
| loan       | 82%                   | 83%               | 91.67%          | 100%             |
| attendance | 78%                   | 100%              | 100%            | 100%             |
| project    | 83%                   | 71%               | 100%            | 100%             |
| lending    | 91%                   | 100%              | 100%            | 100%             |
| monitor    | 100%                  | 100%              | 100%            | 100%             |
| Total      | 83%(1032 of 1237)     | 75%               | 98.28%          | 100%             |

