package ch03_lifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3_lifeCycle2Anno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext factory 
		= new AnnotationConfigApplicationContext(Container3_AnnoLife.class);
		
		factory.close();
		System.out.println("ok");
		
	}

} //end class
