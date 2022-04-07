package ch05_obj;

public class DeleteMemberInfoTraceAdvice {

	public void traceReturn(boolean result, String memberId, String pass) {
		System.out.println("[DA] 정보 수정 : 결과 = " + result + ", 대상회원 = " 
				+  memberId + ", 수정정보 = " +  pass);
	}
	
}
