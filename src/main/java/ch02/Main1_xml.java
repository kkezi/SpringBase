package ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02_obj.Greeter;

public class Main1_xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext factory  //classpath:는 src밑이라는 의미
		= new GenericXmlApplicationContext("classpath:ch02_DIXML/Container1.xml");
		System.out.println("ok"); //확인 먼저 하고
		
		Greeter g1 = factory.getBean("greeter", Greeter.class); //bean객체를 가져올거야
		Greeter g2 = factory.getBean("greeter", Greeter.class);
		
		System.out.println(g1.greet("자바"));
		
		System.out.println("g1==g2:"+(g1==g2)); // 같은 주소를 쓴다 getBean할 때 새로 만들어지는게 아니다 애초에 xml에서 id 하나당 객체주소가 만들어지고 그걸 계속 불러오는 것일뿐이다 == 싱글톤 
		
		
		

	}

}
