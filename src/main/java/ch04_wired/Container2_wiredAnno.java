package ch04_wired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import ch04_obj.AlarmDevice;
import ch04_obj.Camera;
import ch04_obj.DisplayMode;
import ch04_obj.Executor;
import ch04_obj.HomeController;
import ch04_obj.MonitorViewer;
import ch04_obj.RaySensor;
import ch04_obj.SnsAlarmDevice;
import ch04_obj.Viewer;
import ch04_obj.Worker;

@Configuration
public class Container2_wiredAnno {

	
	
	@Bean
	public Executor executor() {
		Executor exec = new Executor();
		exec.setWorker(worker());
		return exec;
	}
	
	
	@Bean
	@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
//	@Scope("prototype")
	public Worker worker() {
	
		return new Worker();
	}
	
	
	
	@Bean
	public Camera camera1() {
		Camera camera = new Camera();
		camera.setNumber(1);
		return camera;
	}
	
	@Bean
	public Camera camera2() {
		Camera camera = new Camera();
		camera.setNumber(2);
		return camera;
	}
	
	@Bean
	public Camera camera3() {
		Camera camera = new Camera();
		camera.setNumber(3);
		return camera;
	}
	
	@Bean
	public Camera camera4() {
		Camera camera = new Camera();
		camera.setNumber(4);
		return camera;
	}
	
	
	@Bean //센서의 종류를 3개 할거에요
	public RaySensor windowSensor() {
		return new RaySensor("창 센서");
	}
	
	@Bean
	public RaySensor doorSensor() {
		return new RaySensor("현관 센서");
	}
	
	@Bean
	public RaySensor lampSensor() {
		return new RaySensor("전동 센서");
	}
	
	
	
	
	
	
	@Bean
	public DisplayMode displayMode() {
		 DisplayMode mode = new DisplayMode();
		 mode.setType("GRID");
		 return mode;
	}
	
	
	
	
	@Bean
	// SnsAlarmDevice가 AlarmDevice(인터페이스)를 상속받았음 
	public AlarmDevice alarmDevice() {
		return new SnsAlarmDevice();
	}
	
	@Bean
	//MonitorViewer가 Viewer(인터페이스)를 상속받음 
	//public MonitorViewer로 안 만들고 인터페이스로 하냐면 ? 모니터뷰어가 될수도 있고 램프 뷰어가 있을수도 있고 
	//영어 한국어 주입시키는거처럼 객체를 편하게 주입시키려고
	public Viewer viewer() {
		//리턴은 뷰어인데 주소에 모니터 뷰어가 들어간거에요 
		MonitorViewer viewer = new MonitorViewer();
		viewer.setDisplayMode(displayMode());
		return viewer;
		
	}
	
	
	
	@Bean(initMethod = "init")
	public HomeController homeController() {
		HomeController homeController = new HomeController();
		List<RaySensor> sensors = new ArrayList<RaySensor>();
		sensors.add(windowSensor());
		sensors.add(doorSensor());
		sensors.add(lampSensor());
		
		homeController.setSensors(sensors);
		homeController.prepare(alarmDevice(),viewer()); //Container2_wiredAnno로 할 때 
		
		homeController.setAlarmDevice(alarmDevice()); //Container1_wiredXml에서 setter인젝션은 파라미터를 하나밖에 가질수 없어서 
		homeController.setViewer(viewer()); // 위의 prepare메서드를 나눠서 setter로 한 것 
		
		homeController.setCamera1(camera1());
		homeController.setCamera2(camera2());
		homeController.setCamera3(camera3());
		homeController.setCamera4(camera4());
		return homeController;
		
	}
	
} //end class
