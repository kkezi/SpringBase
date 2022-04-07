package ch01_sample;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloAppDI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext factory  //classpath:는 src밑이라는 의미
		= new GenericXmlApplicationContext("classpath:ch01_sample/bean.xml");
		//bean.xml의 "bean id"의 class를 실행해라 but 조건은 bean.xml에 연결된 class가 interface를 상속받은 관계여야함 
		//class를 injection할거야 그 클래스들을 한번에 할 인터페이스가 있으면 좋겠어 --> 인터페이스 생성 --> 그걸 getBean("",여기에 넣어줌 = 이 타입으로 가져올거야)
		//.getBean("bean의 id명", bean의 타입)
		Message ms = factory.getBean("messageBean",Message.class);
		ms.sayHello("java");
		
		

	}

}
