package ch01_sample;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message ms = new MessageBeanKr();
		ms.sayHello("자바");
		Message en = new MessageBeanEn();
		en.sayHello(" eunji");
	}

}
