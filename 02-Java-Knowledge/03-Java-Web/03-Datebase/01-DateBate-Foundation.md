*学习目标：理解关系型数据库概念，掌握 DDL（定义表结构）、DML（增删改数据）和 DQL（核心查询逻辑），为后续的 Java 后端数据访问（Dao层）打下坚实基础。*



## 1. 数据库与 MySQL 概述

### 1.1 核心概念

- **数据库 (DB, DataBase)**：存储和管理数据的仓库。
- **数据库管理系统 (DBMS)**：操纵和管理数据库的大型软件（如 MySQL、Oracle、SQL Server 等）。
- **SQL (Structured Query Language)**：操作关系型数据库的编程语言，定义了一套统一标准。

### 1.2 关系型数据库 (RDBMS)

- **定义**：建立在关系模型基础上，由多张相互连接的二维表组成的数据库。
- **特点**：格式统一，便于维护；使用 SQL 语言操作，支持复杂查询。
- **数据模型**：数据库 -> 表 -> 数据（记录）。

------



## 2. SQL 语言分类概览

SQL 主要分为以下四类：

| **分类** | **全称**                   | **说明**                                               |
| -------- | -------------------------- | ------------------------------------------------------ |
| **DDL**  | Data Definition Language   | **数据定义语言**，用于定义数据库、表、字段。           |
| **DML**  | Data Manipulation Language | **数据操作语言**，用于对表中的数据进行**增、删、改**。 |
| **DQL**  | Data Query Language        | **数据查询语言**，用于**查询**表中的记录。             |
| **DCL**  | Data Control Language      | **数据控制语言**，用于创建用户、控制访问权限。         |

------



## 3. DDL - 数据定义语言 (建库建表)

### 3.1 数据库操作

- **查询**：`show databases;` / `select database();`
- **创建**：`create database [if not exists] db_name [default charset utf8mb4];` （MySQL 8 默认字符集为 `utf8mb4`）
- **使用**：`use db_name;`
- **删除**：`drop database [if exists] db_name;`

### 3.2 表结构操作

- **查询**：`show tables;` (查所有表) / `desc table_name;` (查表结构)

- **创建语法**：

  SQL

  ```
  create table table_name(
      字段1 字段类型 [约束] [comment 字段1注释],
      字段2 字段类型 [约束] [comment 字段2注释]
  ) [comment 表注释];
  ```

- **修改/删除**：支持 `alter table` (add/modify/change/drop/rename) 和 `drop table`。

### 3.3 数据类型与约束

- **数据类型**：主要分为数值类型（加 `unsigned` 表示无符号）、字符串类型（`char` 定长，`varchar` 变长）和日期时间类型。
- **五大约束** (保证数据的正确性、有效性和完整性)：
  1. **`primary key` (主键)**：唯一标识，非空且唯一（通常配合 `auto_increment` 自增）。
  2. **`not null` (非空)**：限制字段不能为 null。
  3. **`unique` (唯一)**：保证数据不重复。
  4. **`default` (默认)**：未指定值时采用默认值。
  5. **`foreign key` (外键)**：建立两表连接，保证数据一致性。

------



## 4. DML - 数据操作语言 (增删改)

### 4.1 插入数据 (Insert)

- **指定字段**：`insert into 表名(字段1, 字段2) values (值1, 值2);`
- **全部字段批量**：`insert into 表名 values (值1, 值2...), (值1, 值2...);`

> **注意**：字符串和日期需加引号；字段与值的顺序必须一一对应。

### 4.2 修改数据 (Update)

- **语法**：`update 表名 set 字段1=值1, 字段2=值2 [where 条件];`

> **注意**：如果不加 `where` 条件，将会修改整张表的所有数据！

### 4.3 删除数据 (Delete)

- **语法**：`delete from 表名 [where 条件];`

> **注意**：不能用 delete 删除单个字段的值（应使用 update 置为 null）；不加条件会清空表。

------



## 5. DQL - 数据查询语言 (核心逻辑)

DQL 是数据库操作的重中之重，核心关键字是 `SELECT`。

### 5.1 完整语法结构及执行顺序

SQL

```
select 字段列表
from 表名
where 条件列表
group by 分组字段
having 分组后条件
order by 排序字段 [asc|desc]
limit 起始索引, 记录数;
```

*(执行顺序通常为：`where` > 聚合函数 > `having`)*

### 5.2 核心查询分类

1. **基础查询**：`select distinct 字段 [as] 别名 from 表;` (`distinct` 用于去重)。
2. **条件查询 (Where)**：
   - 支持比较运算符：`>`, `<`, `=`, `<>`/`!=`, `between...and`, `in(...)`。
   - 模糊匹配：`like` (`%` 匹配任意字符，`_` 匹配单个字符)。
   - null 值判断：`is null` / `is not null`。
   - 逻辑运算符：`and`, `or`, `not`。
3. **分组查询 (Group By)**：
   - 依赖**聚合函数**进行纵向计算：`count()`, `max()`, `min()`, `avg()`, `sum()` (null 值不参与运算)。
   - **面试高频：`where` vs `having`**
     - `where` 在分组**前**过滤，不能使用聚合函数。
     - `having` 在分组**后**对结果过滤，可以使用聚合函数。
4. **排序查询 (Order By)**：`asc` (升序，默认)，`desc` (降序)。多字段排序时，只有前一个字段相同时才会比较后一个字段。
5. **分页查询 (Limit)**：
   - `limit 起始索引, 查询记录数;`
   - **实战公式**：`起始索引 = (页码 - 1) * 每页展示记录数`。