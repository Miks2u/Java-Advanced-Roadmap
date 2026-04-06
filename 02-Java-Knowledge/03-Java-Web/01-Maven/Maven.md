## Maven

- Maven是管理(依赖)和构建Java项目的工具

  - **依赖管理**：自动下载、管理项目需要的jar包

  - **项目构建**：实现编译、测试、打包、安装、部署的一键化操作，标准的、自动化的项目构建方式

  - **统一项目管理**：

    ```
    my-maven
    ├── src (存放源代码)
    │   └── main    (程序主入口代码)
    │  		 └── java 		
    │  		 └── resources 	(资源文件)
    │   └── test 	(测试相关代码)
    │  		 └── java 
    │  		 └── resources 	(资源文件)
    ├── pom.xml 	(Maven配置文件)
    ```

- pom.xml中是Maven配置文件，可导入依赖

- **坐标**：Maven中唯一标识一个项目或依赖

  - `groupId`：组织/公司名（如 `com.itheima`）
  - `artifactId`：项目/模块名
  - `version`：版本号（`SNAPSHOT`快照版 / `RELEASE`发布版）

- Maven具有**依赖传递**特性:maven有依赖传递的特性,在jar包中传递了我们不需要的或者和其他jar包版本冲突依赖的时候,可以在dependencies标签中添加`<exclusions>`标签进行排除

- 生命周期：一组定义好的构建步骤 

  - **clean**：清理编译缓存

  - **compile**：编译项目源码

  - **test**：运行测试代码

  - **package**：打包（生成jar/war文件）

  - **install**：将项目打包后安装到**本地仓库**，供其他项目使

     *(在同一套生命周期中，当运行后面的阶段时，前面的阶段都会运行)*