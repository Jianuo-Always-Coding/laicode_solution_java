## Steps

1. 创建 Spring Web 项目
2. 引入 jar 包
3. 引入日志文件 log4j.properties
4. 创建实体类 Person， Car
5. 创建 ApplicationContext.xml

```javaScript
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:context="http://www.springframework.org/schema/context"
     xsi:schemaLocation="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
         http://www.springframework.org/schema/context/spring-context.xsd">

    // 注解扫描加在这里
    <context:component-scan base-package="com.qfedu.spring.pojo"></context:component-scan>

</beans>
```

6. 加入注解扫描
   <context:component-scan base-package="com.qfedu.spring.pojo"></context:component-scan>
7. 在类中加入注解扫描

```java
@ Component("person")
```

等于这个配置

```java
<bean name = "person" class = "com.qfedu.sprong.pojo.Person"></bean>
```

## 使用注解

### 类中使用注释

```java
@ Component("person") //相当于bean配置，适用于所有组件
public class Person{
    ...
}
```

### 其他类级别的注释

```java
@ Scope(scopeName="singleton")
@ Scope(scopeName="prototype")

@ Service("person")
@ Controller("person")
@ Repository("person") // 适用于持久层
```

### set 方式注入 value

1. 在私有的成员变量中注入

```java
    @Value("halen")
    // 等于@Value(value="halen")
    private String name;

    @Value("18")
    private Integer age;

    @Autowired // 将Car类型的实例自动注入进来
    private Car car;

```

2. 在 set 方法中注入

```java
    @Value("tom")
    public void setName(String name) {
        this.name = name;
    }
```

## Test 文件

> 1. 使用 spring 自带的 test 框架
>
> - @RunWith(SpringJunit4ClassRunner.class)
> - @ContextConfiguration("classpath:applicationContext.xml")
>
> 2. 通过名称查找对象，进行测试

```java
@RunWith(SpringJunit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RunWithTest {

    @ Resource(name="person")
    private Person p1;

    @ Resource(name="person")
    private Person p2;

    @ Test
    public void test() {
        System.out.println(p1 == p2);
    }

}
```

## 如何使用 autowired,自动装配出现的问题

1. 如果一个类型有多个对象，可以采用以下方式
- 使用qualifier来指定具体对象
```java
    @Autowired // 将Car类型的实例自动注入进来
    @Qualifier("car2")
    private Car car;
```
- 使用@Resource("car2")
```java
    @Resource("car2")
    private Car car;
```

## 初始化和销毁对象
```java
    @PostConstruct
    public void init() {
        System.out.println("Person 被初始化");
    }

    @PreDestory
    public void destroy() {
        System.out.println("Person 被销毁");
    }

```