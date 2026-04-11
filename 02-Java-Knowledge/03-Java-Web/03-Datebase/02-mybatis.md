*学习目标：理解 Java 访问数据库的底层原理（JDBC），掌握持久层框架 MyBatis 的核心概念与入门配置，并熟悉 SpringBoot 的主流配置文件格式（YAML）。*



## 1. Java 操作数据库的演进

在 Java 后端架构中，负责与数据库交互的层级称为 **持久层（Dao 层 / Mapper 层）**。

### 1.1 JDBC (Java DataBase Connectivity)

- **概念**：使用 Java 语言操作关系型数据库的一套标准 API。
- **痛点**：代码极度繁琐，存在大量硬编码（数据库连接信息、SQL 语句等），手动封装结果集极其痛苦，开发效率低。

### 1.2 现代持久层框架

为了解决 JDBC 的痛点，业界演进出了多种框架：

- **MyBatis**：目前国内互联网大厂（包括去哪儿、字节等）的**绝对主流**。
- **MyBatisPlus**：在 MyBatis 基础上进一步增强，国内非常火。
- **SpringData JPA / Hibernate**：全自动 ORM 框架，国外用得多，国内相对较少。

------



## 2. MyBatis 核心概念与快速入门

### 2.1 什么是 MyBatis？

MyBatis 是一款优秀的**持久层框架**，它的核心作用就是**简化 JDBC 的开发**，将 SQL 语句与 Java 代码解耦，让开发者能专注于 SQL 本身。

### 2.2 核心配置文件配置

在 SpringBoot 项目中，我们需要告诉 SpringBoot MyBatis 的 XML 映射文件在哪里。

Properties

```
# 在 application.properties 中指定 XML 映射配置文件的位置
mybatis.mapper-locations=classpath:mapper/*.xml
```

------



## 3. SpringBoot 配置文件进阶 (Properties vs YAML)

SpringBoot 提供了多种属性配置方式，现在企业开发中**强烈推荐使用 YAML (yml) 格式**。

### 3.1 格式对比

- **`application.properties`**：层级结构不清晰，容易显得臃肿。
- **`application.yml` / `application.yaml`**：简洁、以数据为中心，层次分明。

### 3.2 YAML 核心语法规则（避雷指南）

1. **空格分隔**：冒号 `:` 后面的数值前**必须**有一个空格。
2. **缩进表示层级**：使用缩进表示层级关系。
3. **禁用 Tab**：缩进时**绝不允许**使用 Tab 键，只能用空格（IDEA 通常会自动将 Tab 转为空格）。

YAML

```
# 标准的 yml 配置示例
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/web01
    username: root
    password: 1234
```

------



## 4. 动态 SQL 基础标签

在实际业务中，查询条件往往是动态变化的（比如用户有时候填了姓名，有时候没填）。MyBatis 提供了强大的动态 SQL 标签来解决这个问题。

- **`<if>` 标签**：用于条件判断。只有当 `test` 属性中指定的条件成立时，才会拼接对应的 SQL 片段。
- **`<where>` 标签**：智能的 WHERE 关键字。它只会在内部有成立的 `<if>` 条件时，才自动插入 `WHERE` 子句；并且会**自动去除**拼接后 SQL 片段开头多余的 `AND` 或 `OR`。