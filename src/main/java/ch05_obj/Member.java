package ch05_obj;

public class Member {
	String memberId;
	String name;
	int age;
	
	
	@Override
	public String toString() {
		return "{\"memberId\":\"" + memberId + "\", \"name\":\"" + name + "\", \"age\":\"" + age + "\"}";
	}
	
	
	
} // end class
