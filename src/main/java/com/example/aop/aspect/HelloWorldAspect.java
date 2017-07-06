package com.example.aop.aspect;

import com.example.annotations.Monitor;
import com.example.aop.service.HelloService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Created by guozhenbin on 2017/5/27.
 */

@Aspect
@Service
public class HelloWorldAspect {

    /*@Before(value = "execution(* com.sean.aop.HelloWorld.sayHello(String))")
    public void beforeSayHello(JoinPoint joinPoint){
        System.out.println("before say:"+joinPoint.getArgs()[0]);
//        System.out.println(name);
    }*/

    @Around("execution (* com.example.aop.service.HelloService.getHelloMsg(String))")
    public Object aroundSayHello(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] objects = joinPoint.getArgs();
//        Monitor monitor = AnnotationUtils.findAnnotation(HelloService.class, Monitor.class);
//        System.out.println(String.format("monitor value:%s",monitor.value()));
        Object target = joinPoint.getTarget();
        System.out.println(target);
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
        System.out.println(target.getClass());
        Method method = ReflectionUtils.findMethod(target.getClass(),methodName,String.class);

        Monitor monitor = AnnotationUtils.findAnnotation(method,Monitor.class);
        System.out.println("monitor:"+monitor.value());
        return joinPoint.proceed();
    }

    /*@AfterReturning(
            pointcut = "com.sean.aop.SystemArchitecture.sayHelloWithName()",
            returning = "hellosean"
    )
    public void afterSayHello(JoinPoint joinPoint){
        System.out.println("after sayhello");
    }*/
}
