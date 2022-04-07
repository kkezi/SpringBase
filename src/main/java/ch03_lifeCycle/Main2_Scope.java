package ch03_lifeCycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch03_obj.WorkScheduler;

public class Main2_Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericXmlApplicationContext factory 
		= new GenericXmlApplicationContext("classpath:ch03_lifeCycle/Container2_Scope.xml");
		
		WorkScheduler scheduler = factory.getBean("workScheduler",WorkScheduler.class);
		scheduler.makeAndRunWork();
		
		
		
		factory.close();
		System.out.println("ok");
		
		
	}

}
