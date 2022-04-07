package ch04_obj;

import java.util.List;

public class HomeController {
	
	private AlarmDevice alarmDevice;
	private Viewer viewer;
	
	private List<RaySensor> sensors;
	
	private Camera camera1;
	private Camera camera2;
	private Camera camera3;
	private Camera camera4;
	
	public void init() {
		System.out.println("init()은 객체연결하자마자 실행합니다");
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		
		
	}
	
	public void setSensors(List<RaySensor> sensors ) {
		this.sensors = sensors;
	}

	
	
	//이거는 어노테이션 방식일 때 사용
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		  this.alarmDevice = alarmDevice;
		  this.viewer = viewer;
	}
	
	
	
	//이거는 ------------------xml방식일때 property에 ref를 두개 넣을 수 없어서 setter를 여러개로 나눠서 진행 
	public void setAlarmDevice(AlarmDevice alarmDevice) {
		this.alarmDevice = alarmDevice;
		
	}
	
	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}
	//------------------------------------------------------------------------
	
	
	
	public void setCamera1(Camera camera1) {
		this.camera1 = camera1;
	}
	
	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
	}
	
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
	}
	
	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
	}
	
	
	public void checkSensorAndAlarm() {
		
		System.out.println("checkSensorAndAlarm() : " + sensors);
		for (RaySensor s : sensors) {
			if(s.isObjectFounded()) {
			alarmDevice.alarm(s.getName()); //alarmDevice(인터페이스)에 alarm메서드가 있어야 하고  구현클래스인 Sns에도 alarm메서드에도 있어야한다 
			//여기서 alarmDevice(인터페이스)의 메서드를 안 쓰고 SnsAlarmDevice(구현클래스)의 메서드를 쓰면 안되나요?
			}
		}
	}
	
	public void showCameraImage() {
		viewer.draw();
		
	}
	
	
} //end class
