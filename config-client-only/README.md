# eureka-client-provider

使用 华为云 `config server 高可用集群 `, 示例 client ps: 该实例直接从 config server 读取配置, 不经过eureka 做服务发现

### 配置 

依赖 `pom.xml`
```xml
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <java.version>1.8</java.version>
    <spring-cloud.version>Finchley.SR1</spring-cloud.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
```
* 配置 `bootstrap.yaml `

```yaml
server:
  port: 8991
spring:
  application:
    name: config-client-only
  cloud:
    config:
      label: master
      profile: dev
      uri: http://114.116.7.100:8888/ #改成自己不是的config server 实际公网访问地址和端口
```


* 添加示例 controller , `ConfigClientController.java`

```java

@RefreshScope
@RestController
@Configuration
public class ConfigClientController {

  @Value("${hello.huawei:error}")
  private String name;

  @RequestMapping("/hello")
  public String version() {
    return this.name;
  }

}

```

* 启动该项目,可以直接访问 http://localhost:8991/hello 验证.

![client](../docs/yun_config_only.png)
