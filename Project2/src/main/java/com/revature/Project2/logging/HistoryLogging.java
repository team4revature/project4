package com.revature.Project2.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryLogging {
	
	private Logger log = Logger.getLogger(getClass());

	private long before;
	private long after;
	
	@Before("execution(* com.revature.Project2.service.HistoryService.*(..))")
	public void logBoardServiceTimeBefore(JoinPoint pjp) throws Throwable{
		before = System.nanoTime();
		//pjp.proceed();
		
	}
	
	@After("execution(* com.revature.Project2.service.HistoryService.*(..))")
	public void logBoardServiceAfter(JoinPoint pjp) throws Throwable{
		after = System.nanoTime();
		
		log.info(pjp.getSignature().getName() + " executed in " + (after - before) + " nanoseconds.");
		
	}
}
