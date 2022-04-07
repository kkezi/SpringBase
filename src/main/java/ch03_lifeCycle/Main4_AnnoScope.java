package ch03_lifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch03_obj.WorkScheduler;

public class Main4_AnnoScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext factory 
		= new AnnotationConfigApplicationContext(Container4_AnnoScope.class);
		
		WorkScheduler scheduler = factory.getBean("workScheduler",WorkScheduler.class);
		scheduler.makeAndRunWork();
		factory.close();
		System.out.println("ok");
	}

} //end class
