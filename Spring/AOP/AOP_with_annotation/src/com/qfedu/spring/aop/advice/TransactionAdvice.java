package src.com.qfedu.spring.aop.advice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionAdvice {
    // 前置通知 ： 在目标方法之前调用
    // 后置通知 ：（如果出现异常就不调用）在目标方法之后调用
    // 后置通知 ：（无论是否出现异常都会调用）在目标方法之后调用
    // 异常通知 ： 出现异常时调用，不出现异常不调用
    // 环绕通知 ： 在目标方法之前后调用
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

    @After("TransactionAdvice.pointcut()")
    public void after() {
        System.out.println("后置通知被执行（无论是否出现异常都被调用）");
    }

    @AfterThrowing("TransactionAdvice.pointcut()")
    public void afterException() {
        System.out.println("异常通知被执行");
    }

    @Around("TransactionAdvice.pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("...");
        Object proceed = point.proceed(); // 调用目标方法
        System.out.println("...");
        return proceed;
    }
}
