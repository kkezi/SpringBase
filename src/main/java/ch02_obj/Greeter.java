package ch02_obj;

public class Greeter {
	
	String msg; 
	public void setFormat(String msg) {
		this.msg = msg; //Container1의 value값이 여기 msg로 들어와서 위의 msg로 갑니다
		
	}

	
	public String greet(String guest) {
		
		return guest + " " + msg ;
	}
}
