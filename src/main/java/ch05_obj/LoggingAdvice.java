package ch05_obj;

public class LoggingAdvice {

	public void before() {
		System.out.println("[LA]메서드 실행 전 (before) 전처리 수행함.");
	}
	
	public void afterReturning(Object ret) {
		System.out.println("[LA]메서드 정상 처리(afterReturning) 후 수행할 리턴값 : "+ ret);
	}
	
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA]메서드 예외발생 후 (afterThrowing) 수행함 예외: " + ex.getMessage());
	}
	
	public void afterFinally() {
		System.out.println("[LA]메서드 실행 후 (afterFinally) 후처리 실행함");
	}
} //end class
