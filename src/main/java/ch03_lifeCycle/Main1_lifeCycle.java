package ch03_lifeCycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1_lifeCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext factory 
		= new GenericXmlApplicationContext("classpath:ch03_lifeCycle/Container1_lifeCycle.xml");

		
		factory.close();
		System.out.println("ok");
	}

}
