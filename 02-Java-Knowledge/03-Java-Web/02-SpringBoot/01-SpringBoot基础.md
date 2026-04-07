##### Web服务器与架构

- B/S：Browser/Server，浏览器/服务器架构模式
- C/S：Client/Server，客户端/服务器架构模式



## SpringBoot基础

*代码示例*

```

//@RestController           // 标识这是一个请求处理类
@RequestMapping("/hello") // 标识请求路径
public class HelloController {
    
    @GetMapping
    public String hello(@RequestParam String name) {
        return "Hello " + name + " ~";
    }
}《》
//Spring中内嵌Tomcat，一个main方法即可启动
```



## 三层架构

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│  Controller │ ──→ │   Service   │ ──→ │     DAO     │
│   (控制层)   │     │  (业务逻辑层) │     │ (数据访问层)  │
│  接收请求    │      │ 处理业务逻辑  │     │  操作数据库   │
│  响应数据    │      │            │      │             │
└─────────────┘     └─────────────┘     └─────────────┘
@RestController        @Service           @Repository
```

#### 设计原则：

- **单一职责原则**：每个类只负责一项职责
- **高内聚低耦合**：模块内部联系紧密，模块之间依赖松散



## 分层解耦(IOC + DI)

#### 为什么需要解耦？

- 传统代码中，层与层之间直接 `new` 对象，**耦合度高**
- 修改一个类可能牵连多个地方，**难以维护**

#### 概念：

- IOC：控制反转，对象的创建控制权由程序转移到外部（Spring 容器）
- DI：依赖注入，容器为程序提供运行时所需的对象
- Bean：Bean对象，IOC 容器中创建、管理的对象

#### 解耦思路

1. **IOC**：将项目中的类交给 IOC 容器管理
2. **DI**：应用程序运行时，从容器获取所需的对象



## IOC详解

#### 声明Bean的四大注解

- @Controller：声明控制器Bean(Web层)

- @Service：声明业务层Bean

- @Repository：声明数据访问层Bean

- @Component：声明通用组件Bean(不属于以上三层)

  **注意**：注解要加在**实现类**上，而不是接口上 

## DI详解

#### 依赖注入的三种方式

|      方式       |                        代码示例                        | 优点                 | 缺点                     |
| :-------------: | :----------------------------------------------------: | :------------------- | :----------------------- |
|  **字段注入**   |     `@Autowired private UserService userService;`      | 简洁方便             | 隐藏依赖关系，破坏封装性 |
| **构造器注入**  | `public UserController(UserService userService) {...}` | 依赖清晰，安全性高   | 参数多时代码臃肿         |
| **Setter 注入** |   `@Autowired public void setUserService(...) {...}`   | 保持封装性，依赖清晰 | 需额外编写 setter 方法   |

#### 多个同类型Bean的处理

| 方案           | 注解                                    |          说明          |
| :------------- | :-------------------------------------- | :--------------------: |
| **指定首选**   | `@Primary`                              | 在 Bean 类上标记为首选 |
| **指定名称**   | `@Autowired` + `@Qualifier("beanName")` | 明确指定要注入的 Bean  |
| **按名称注入** | `@Resource(name = "beanName")`          | JavaEE 规范，默认按名  |

​	*@Autowired是Spring框架提供的注解，而@Resource是JavaEE规范提供的*
​	*@Autowired默认是按照类型注入，而@Resource默认是按照名称注入*



## 总结

```
┌─────────────────────────────────────────────────────────┐
│                    SpringBoot 核心流程                    │
├─────────────────────────────────────────────────────────┤
│                                                         │
│  浏览器请求 → Controller → Service → DAO → 数据库          │
│                ↓           ↓         ↓                  │
│            @RestController @Service  @Repository        │
│                                                         │
│                    ↓ IOC 容器管理 ↓                       │
│                                                         │
│  每个对象都是 Bean，通过 @Autowired 自动注入                 │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

**`@SpringBootApplication` 启动应用，`@RestController` 接收请求，三层架构各司其职，IOC+DI 解耦管理 Bean。**