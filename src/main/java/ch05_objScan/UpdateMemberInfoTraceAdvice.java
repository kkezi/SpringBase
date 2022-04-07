package ch05_objScan;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ch05_obj.UpdateInfo;

@Component
@Aspect
@Order(1)
public class UpdateMemberInfoTraceAdvice {
	final String method = "args(id,info)";
	
	
	@AfterReturning(pointcut = method, returning = "ret", argNames = "ret,id,info" )
	public void traceReturn(boolean result, String memberId, UpdateInfo info) {
		System.out.println("[TA] 정보 수정 : 결과 = " + result + ", 대상회원 = " 
	+  memberId + ", 수정정보 = " +  info);
	}
}
