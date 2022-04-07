package ch04_obj;

public class RaySensor {
	
	private String name;
	private boolean objectFounded;//default false;
	
	//센서의 종류를 이름으로 여러개 받을거에요 
	public RaySensor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isObjectFounded() {
		return objectFounded;
	}
	
	public void foundObject() {
		this.objectFounded = true;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"objectFounded\":\"" + objectFounded + "\"}";
	}
	

	
	
	
}
