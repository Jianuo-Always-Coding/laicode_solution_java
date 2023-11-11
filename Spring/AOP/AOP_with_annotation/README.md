# Annotation development

所有步骤和 AOP 开发一样，区别在 xml 文件, 了解, XML 文件上配置更为普遍

1. 创建 Spring Web 项目
2. 引入 jar 包
3. 引入日志文件 log4j.properties
4. 准备目标对象
   先创建 service 的接口(UserService)，再创建实现类(UserServiceImpl)

5. 编写通知

6. 配置织入，将通知织入到目标对象
   在 xml 文件中加入 aop 的名称空间

```javascript
    <!--    目标对象-->
    <bean name="userService" class="src.com.qfedu.spring.aop.service.UserServiceImpl"></bean>>

    <!--    通知对象-->
    <bean name="transactionAdvice" class="src.com.qfedu.spring.aop.advice.TransactionAdvice"></bean>

    <!--    开启织入注解-->
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>

```

7. 在通知上添加注解
   > 可以使用 Annotation，在每个通知前加入切入点路径

```java
@Aspect
public class TransactionAdvice {

    @Before("execution(* src.com.qfedu.spring.aop.service..*ServiceImpl.*(..))")
    public void before() {
        System.out.println("前置通知被执行");
    }

    @AfterReturning("execution(* src.com.qfedu.spring.aop.service..*ServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("后置通知被执行（出现异常不调用）");
    }
}
```

> 也可以使用@pointcut，提前定义 pointcut

```java
@Aspect
public class TransactionAdvice {

    @Pointcut("execution(* src.com.qfedu.spring.aop.service..*ServiceImpl.*(..))")
    public void pointcut() {}

    @Before("TransactionAdvice.pointcut()")
    public void before() {
        System.out.println("前置通知被执行");
    }

    @AfterReturning("TransactionAdvice.pointcut()")
    public void afterReturning() {
        System.out.println("后置通知被执行（出现异常不调用）");
    }
}
```

7. 使用 test 测试

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Resource(name="userService")
    private UserService userService;

    @Test
    public void testUpdate() {
        userService.update();
    }
}
```
