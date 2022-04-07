package ch05_obj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {

	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		//조인포인트: 호출되는 메서드의 실행순서 저장하는 객체
		System.out.println("[LA] 로그 시작");
		StopWatch sw = new StopWatch();
		sw.start(); //시작
		Object ret = joinPoint.proceed();
		//다음 메서드 호출, 여기서는 핵심알고리즘
		sw.stop();
		System.out.println("[LA]메서드 실행시간:" 
				+ sw.getTotalTimeMillis() + "밀리초");
		return ret;
	}
}
