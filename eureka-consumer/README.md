# springcloud
eureka_producer
端口：8600


要想将一个微服务注册到Eureka Server（或其他服务发现组件，例如Zookeeper、Consul,nacos等,
Eureka 2.0闭源之后，Consul慢慢会成为主流。）
    1.添加Eureka Client（或其他服务发现组件的Client）和ribbon pom依赖
    2.写注解：在启动类上添加注解@EnableDiscoveryClient 或@EnableEurekaClient，注入ribbon的RestTemplate 作为http调用
    3.配置application.properties
    4.此模块时消费者所以要集成客户端的负载均衡 ribbon

