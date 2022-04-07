package ch02_obj;

public class AuthFailLogger {
	//잘못된 비밀번호를 몇번 입력했는지 
	private int failCounts;
	
	//<property name = "threshold" value = "2" /> setter injection 
	private int threshold;
	
	
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	public void insertBadPw(String userId, String password) {
		System.out.println(userId+" : "+password);
		failCounts++;
		
		//threshold=0이 되버리면 한번의 로그인 시도에도 로그인 차단 
		if(threshold > 0 && failCounts > threshold) {
			System.out.println("너무 많은 로그인 시도 실패");
		}
	}

} // end class
