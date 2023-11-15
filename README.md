# 中信银行软件研发中心小组作业

组内成员：
- 邢小林：Java服务端研发
- xxx

### 快速启动
克隆项目到本地

```shell
git clone https://github.com/xlxingRun/CITIC_homework.git
```

使用本地maven同步所依赖的包，确保没有报错。

默认连接的数据库是作者的TDSQL，可以直接使用。

使用IDEA运行项目，在浏览器中输入：

http://localhost:8080/swagger-ui/index.html

---

**使用自己的数据库：**

更新配置文件`application.yaml`

```yaml
spring:
  application:
    name: CITIC

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: mysql_username
    password: mysql_password
    url: your_mysql_url
```

须确保在数据库中创建数据库表`t_user`（存放在文件`resources/static/DDL.sql`）

```sql
create database citic;

use citic;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`                 BIGINT     NOT NULL COMMENT '主键',
    `username`           VARCHAR(255) COMMENT '用户名',
    `email`              VARCHAR(255) COMMENT '邮箱',
    `phone`              VARCHAR(255) COMMENT '手机号',
    `id_card`             VARCHAR(18) COMMENT '身份证号',
    `password`           VARCHAR(255) COMMENT '密码',
    `admission`          TINYINT(1)          DEFAULT true COMMENT '准入权限',
    `revision`           INT        NOT NULL DEFAULT 0 COMMENT '乐观锁',
    `deleted`            TINYINT(1) NOT NULL DEFAULT false COMMENT '逻辑删除',
    `create_time`        DATETIME   NOT NULL COMMENT '创建时间',
    `update_time`        DATETIME   NOT NULL COMMENT '更新时间',
    `created_by` VARCHAR(255)    NOT NULL COMMENT '创建人',
    `updated_by` VARCHAR(255)    NOT NULL COMMENT '更新人',
    PRIMARY KEY (id),
    UNIQUE INDEX `idx_username` (username),
    UNIQUE INDEX `idx_email` (email),
    UNIQUE INDEX `idx_phone` (phone)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '用户信息';
```

### 简单介绍

一个简单的用户信息维护SpringBoot后端项目
主要内容包括：
- TUserController：用户信息维护控制器，请求的入口
- TUserService：增删改查逻辑，操作数据库

其他功能组成：

- 参数校验Validation：邮箱、手机号、身份证号
- SwaggerUI：测试环境中的路径 /swagger-ui/index.html
- 全局异常处理：exception包中的ExceptionHandler，回复模版Result
- 字段自动填充：创建时间、更新时间、创建用户、更新用户
- MyBatisPlus插件：逻辑删除、乐观锁版本号
- Jackson序列化：Java中的Long在json中无法无损存储，转化为string
- 密码加密：BCryptPasswordEncoder实现类对明文密码加密后存储到数据库

## 功能补充

1. 创建数据库时增加一些默认用户，补充一些单元测试。
2. 抛异常时，精确返回异常的类型，如用
   - 用户错误：手机号格式不正确
   - 服务端错误：方法未实现
   - 未知错误：
