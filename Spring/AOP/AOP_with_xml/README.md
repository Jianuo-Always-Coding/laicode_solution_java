# AOPTest

## Steps

1. 创建 Spring Web 项目
2. 引入 jar 包
3. 引入日志文件 log4j.properties
4. 准备目标对象
   先创建 service 的接口(UserService)，再创建实现类(UserServiceImpl)

```java
package src.com.qfedu.spring.aop.service;

public class UserServiceImpl implements UserService{
    @Override
    public void save() {
        System.out.println("保存用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void select() {
        System.out.println("查询用户");
    }
}


```

5. 编写通知

> - 前置通知 ： 在目标方法之前调用
> - 后置通知 ：（如果出现异常就不调用）在目标方法之后调用
> - 后置通知 ：（无论是否出现异常都会调用）在目标方法之后调用
> - 环绕通知 ： 在目标方法之前后调用
> - 异常通知 ： 出现异常时调用，不出现异常不调用

```java
package src.com.qfedu.spring.aop.advice;

public class TransactionAdvice {
    // 前置通知 ： 在目标方法之前调用
    // 后置通知 ：（如果出现异常就不调用）在目标方法之后调用
    // 后置通知 ：（无论是否出现异常都会调用）在目标方法之后调用
    // 异常通知 ： 出现异常时调用，不出现异常不调用
    // 环绕通知 ： 在目标方法之前后调用
    public void before() {
        System.out.println("前置通知被执行");
    }

    public void afterReturning() {
        System.out.println("后置通知被执行（出现异常不调用）");
    }

    public void after() {
        System.out.println("后置通知被执行（无论是否出现异常都被调用）");
    }

    public void afterException() {
        System.out.println("异常通知被执行");
    }

    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知前");
        Object proceed = point.proceed(); // 调用目标方法
        System.out.println("环绕通知后");
        return proceed;
    }
}

```

6. 配置织入，将通知织入到目标对象
   在 xml 文件中加入 aop 的名称空间,并且使用 bean 创建目标对象和通知对象，使用 aop 方法织入

```javascript
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
         http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/aop
         http://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--    目标对象-->
    <bean name="userService" class="src.com.qfedu.spring.aop.service.UserServiceImpl"></bean>>

    <!--    通知对象-->
    <bean name="transactionAdvice" class="src.com.qfedu.spring.aop.advice.TransactionAdvice"></bean>

    <!--    将通知对象织入目标对象-->
    <aop:config>
        <!--   选择切入点     -->
        <aop:pointcut id="pointcut" expression="execution(* src.com.qfedu.spring.aop.service..*ServiceImpl.*(..))"/>
        <!--    引入通知对象    -->
        <aop:aspect ref="transactionAdvice">
            <aop:before method="before" pointcut-ref="pointcut"/>
            <aop:after-returning method="afterReturning" pointcut-ref="pointcut"/>
            <aop:after method="after" pointcut-ref="pointcut"/>  <!--    无论是否出现异常都会被调用    -->
            <aop:around method="around" pointcut-ref="pointcut"/>
            <aop:after-throwing method="afterException" pointcut-ref="pointcut"/>
        </aop:aspect>
    </aop:config>
</beans>
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
