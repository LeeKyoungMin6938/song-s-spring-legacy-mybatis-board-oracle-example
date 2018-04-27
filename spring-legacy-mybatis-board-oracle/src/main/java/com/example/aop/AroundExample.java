package com.example.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ModelAttribute;

@EnableAspectJAutoProxy
@Aspect
@Component
public class AroundExample {
	@Autowired
	private AOPMapper aopMapper;
	
	@ModelAttribute("active")
	public String active() {
		return "AOPModel";
	}
	
	protected Log log = LogFactory.getLog(AroundExample.class);
	public AroundExample() {
		System.out.println("================================Aspect===================================");
	}
	
	@Around("execution(* com.example.web.controller.BoardController.postInsert(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp)throws Throwable{
		StopWatch watch = new StopWatch();
		watch.start();
		Object obj=pjp.proceed();
		watch.stop();
		
		Double elapsedTimeBySecond = watch.getTotalTimeSeconds();
		System.out.println("-----------------------insertBoard Method �ҿ�ð� = "+elapsedTimeBySecond+"��---------------------------------");
		AOPModel aop = new AOPModel();
		//db�� ������ �κ�
		aop.setStdname("�̰��");
		aop.setPointcut("postInsert()");
		aop.setElapsedtime(elapsedTimeBySecond+"��");
		aopMapper.insert(aop);
		return obj;
	}
}
