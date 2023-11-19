package by.pvt.fitnessclub.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut(value = "execution(* by.pvt.fitnessclub.controller.ClientController.*(..))")
    public void logClient() {
    }

    @Before(value = "logClient()")
    public void beforeLogging() {
        log.info("Стартовал запрос из контроллера Client");
    }

    @Around(value = "logClient())")
    public Object loggingOrderController(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = null;
        try {
            log.info("Стартовал запрос из контроллера ClientController, Time: {}", LocalDateTime.now());
            object = joinPoint.proceed();
            log.info("Запрос из контроллера ClientController завершён, Time: {}", LocalDateTime.now());
        }
        catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return object;
    }

    @AfterThrowing(value = "logClient()", throwing = "ex")
    public void afterLogging(Throwable ex) {
        log.error(ex.getMessage(), ex);
    }
}
