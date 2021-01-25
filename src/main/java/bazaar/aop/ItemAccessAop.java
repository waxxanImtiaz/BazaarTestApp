package bazaar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ItemAccessAop {

        @Before("execution(* bazaar.controllers.ItemController*.*(..))")
        public void before(JoinPoint joinPoint){
            System.out.println("ItemAccessAop before aop is executed");
        }
}
