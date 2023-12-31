# Spring
- DAO : 接口（Object）
- DAOImpl ： 实现接口，定义一些function， 使用jdbc连接数据库中的表， 并且使用jdbcTemplate管理，function中封装SQL操作使用jt.update()进行实现

- Service : 接口（operation）
- ServiceImpl ： 使用Resource注入DAO的entity，再对Object进行操作
## IOC:

Inverse of control. 通常我们需要一个对象的时候我们直接 new 一个。在 Spring 中我们使用 XML 文件，在文件中定义 bean。

```JavaScript
<bean name = "p" class = "com.qfedu.sprong.pojo.Person"></bean>
```

需要对象时，通过读取 XML 文件，通过 getBean("p")创建。

> 为什么可以解耦合？
>
> - 因为原生 java 中，我们只通过 new 创建对象，使得在层与层之间，对象的关系很复杂，依赖性很高。
> - 使用 Spring Bean 来管理对象的创建，我们需要对象时，只需要让 bean 创建一个就好，也可以简化代码。

## AOP

### AOP 的开发中的相关术语

- Joinpoint（连接点）：所谓连接点是指那些被拦截到的点。在 spring 中，这些点指的是方法,因为 spring 只支持方法类型的连接点（可以被切入的点）
- Pointcut（切入点）：所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义（已经被切入的点）
- Advice（通知/增强）：所谓同时是指拦截到 Joinpoint 之后所要做的事情就是通知，通知分为前置通知，后置通知，异常通知，最终通知环绕通知（切面要完成的功能）
- Introduction（引介）：引介是一种特殊的通知在不修改类代码的前提下，Introduction 可以在运行期为类动态地添加一些方法或 fields
- Aspect（切面）：是切入点和通知（引介）的结合
- Target（目标对象）：代理的目标对象
- Proxy（代理）：一个类被 AOP 织入增强后，就产生一个结果代理类
- Weaving（织入）：是指把增强应用到目标对象来创建新的代理对象的过程。spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装载期织入

### AOP 开发

详情见 AOPTest README.md

### AOP 的注解开发方式

详情见 AOPTest Annotation_development.md

## Bean

1. 在 IOC 中,我们用了 bean 的一个例子，bean 的属性我们使用了 name，也可以用 id，区别在于：

   > - name ： 可以使用特殊字符，可以重复
   > - id : 不可以使用特殊字符，不可以重复

2. 构造方法

```JavaScript
<bean name = "p1" id="p2" class = "com.qfedu.sprong.pojo.Person"></bean>
```

```java
ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
Person p1 = (Person)context.getBean("p1");
Person p2 = (Person)context.getBean("p2");
```

这里构造方法只被调用一次，即使不创建 p1,p2,构造方法也会被调用

3. 工厂的类型

   > - ClassPathXmlApplicationContext(): 从类路径获取文件
   > - FileSystemXmlApplicationContext() ： 后面接文件在系统中的绝对位置

4. 单例和多例
   默认情况是单例， scope="singleton"

```JavaScript
<bean name = "p1" id="p2" class = "com.qfedu.sprong.pojo.Person" scope="singleton"></bean>
```

```java
Person p1 = (Person)context.getBean("p1");
Person p2 = (Person)context.getBean("p1");
System.out.print(p1 == p2); // return ture，构造方法被调用一次
// bean被创建就被构造
```

可以修改为多例， scope="prototype"

```JavaScript
<bean name = "p1" id="p2" class = "com.qfedu.sprong.pojo.Person" scope="prototype"></bean>
```

```java
Person p1 = (Person)context.getBean("p1");
Person p2 = (Person)context.getBean("p1");
System.out.print(p1 == p2); // false，构造方法被调用两次
```

5. 什么时候创建？

   > - scope="singleton" 或者默认，在容器启动时就创建，并且只能创建一次
   > - scope="prototype", 容器启动时不创建，每次获取对象时才创建，可以创建多次

6. singleton 是否可以延迟创建

容器启动时不创建，每次获取对象时才创建

```javaScript
<bean lazy-init="true"></bean>
```

## 对象创建的方式

### 无参构造函数

Bean 这一节中使用的都是无参构造

### 有参构造函数

详情见后面的依赖注入

### 静态工厂方法

```java
public static Person createPerson1() {
    return new Person();
}
```

```javaScript
<bean name="person1" class="com.qfedu.spring.factory.PersonFactory" factory-method="createPerson1"></bean>
```

### 实例工厂方法

```java
public Person createPerson2() {
    return new Person();
}
```

```javaScript
<bean name="PersonFactory" class="com.qfedu.spring.factory.PersonFactory"></bean>
<bean name = "person2" factory-bean="PersonFactory" factory-method="createPerson2"></bean>
```

## 依赖注入

### set 方法注入

> Create pojo

```java
public class Person {
    private String name;
    private Integer age;
    private Car car;
}
```

```java
public class Car {
    private String name;
    private String color;
}
```

```JavaScript
<bean name="car" class="com.qfedu.spring.pojo.Car">
    <property name="name" value="BMW"></property>
    <property name="color" value="red"></property>
</bean>

<bean name="person1" class="com.qfedu.spring.pojo.Person">
    <property name="name" value="helen"></property>
    <property name="age" value="18"></property>
    <property name="Car" ref="car"></property>
</bean>

```

### 构造方法注入

1. 在 Person 类中创建含参构造方法（constructor）

```java
public Person(String name, Car car) {
    super();
    this.name = name;
    this.car = car;
}
```

```javaScript
<bean name="car" class="com.qfedu.spring.pojo.Car">
    <property name="name" value="BMW"></property>
    <property name="color" value="red"></property>
</bean>

<bean name="person2" class="com.qfedu.spring.pojo.Person">
    <constructor-arg name="name" value="helen"></pconstructor-arg>
    <constructor-arg name="Car" ref="car"></constructor-arg>
</bean>
```

2. 使用 index 表明参数的位置
   index="0"
3. 使用 type 表明参数的类型
   type="java.lang.Intrger"

### p 名称空间注入

### spel 注入

## maven
> maven 功能：
> - 项目构建
> - 依赖管理 dependencies
> - 信息管理

## Spring TransactionManager(事务管理)
### DataSource TransactionManager - DataSource : DataSource
### Hibernate TransactionManager - DataSource : SessionFactory
### Jpc TransactionManager - DataSource : EntityManager