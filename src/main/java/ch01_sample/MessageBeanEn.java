package ch01_sample;

public class MessageBeanEn implements Message{//인터페이스 상속받을거야
	
	public void sayHello(String name) {
		System.out.println("hello" + name + "!");
	}

}
