package ch03_obj;

public class ConnPool3 {
	
	//어노테이션 없이 xml에 init-method, destroy-method 명시해준 상황

	public void init() {
		System.out.println("ConnPool3.init()");
	}
	
	public void destroy() {
		System.out.println("ConnPool3.destroy()");
	}
	
}
