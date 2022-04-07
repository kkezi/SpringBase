package ch04_wired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch04_objScan.Executor;
import ch04_objScan.HomeController;
import ch04_obj.RaySensor;
import ch04_obj.WorkUnit;

public class Main4_wiredAnnoScan {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext factory
	 			= new AnnotationConfigApplicationContext(Container4_wiredAnnoScan.class);
		
		System.out.println("======================"); //init메서드는 객체를 연결하자마자 바로 실행하는지 확인해봐 
		Executor exec = factory.getBean("executor", Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit()); //Worker Bean에 프로토타입을 설정하지 않으면 addUnit을 할 때마다 같은 주소에다가 생성자를 만드는것 
		// 결국 계속해서 새롭게 만드는게 아니라 제일 마지막에 만든거 하나만 그 주소에 들어가게 된다 
		// 근데 우리는 각기 다른 Worker에다가 작업을 하고 싶은거니까 @Scope(프로토타입)해줘야한다 
		
		
		HomeController home = factory.getBean("homeController",HomeController.class);
		home.checkSensorAndAlarm();
		home.showCameraImage();
		System.out.println("------- ");
		
		RaySensor windowSensor = factory.getBean("windowSensor",RaySensor.class);
		windowSensor.foundObject();
		
		//RaySensor doorSensor = factory.getBean("doorSensor", RaySensor.class);
		//doorSensor.foundObject();
		home.checkSensorAndAlarm(); //this.objectFounded = true;
		
		
		
		
		
		System.out.println("ok");
	
		
	
	
	} //end main

}
