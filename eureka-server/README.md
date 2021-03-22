# springcloud
搭建一个Eureka注册中心，将Eureka作为一个项目启动，启动后将其作为一个Eureka的注册中心.具体步骤如下：
（1）pom导入spring-cloud-starter-netflix-eureka-server依赖
（2）编写application.properties配置文件
（3）在启动类上加上@EnableEurekaServer注解
对于该组件来说，有两个身份：
    一是服务器
    二是注册中心