package ch05_AOP;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch01_sample.Message;
import ch05_obj.WriteImpl;

public class Main1_xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ch05_AOP/Container1.xml");
		
		WriteImpl bean = ctx.getBean("write",WriteImpl.class);
		bean.write();
		
		//다른 메서드에도 aop 걸어보기
		Message m = ctx.getBean("hello", Message.class); // aop걸린 메서드 실행하려면 객체 있어야 하니까 가져오기 
		m.sayHello("자바");
		
		System.out.println("ok");	
					
		ctx.close();
		
	} //end main

} //end class
