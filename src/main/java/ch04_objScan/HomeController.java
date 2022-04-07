package ch04_objScan;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ch04_obj.AlarmDevice;
import ch04_obj.Camera;
import ch04_obj.RaySensor;
import ch04_obj.Viewer;
/*
 * 1. 객체 추가 : context-... Scan에 의해서 : @Component
 * 2. injection : wired 
 * 	@Autowired : 같은 type을 연결한다 (같은 타입이어도 참조형 변수 이름으로 구분한다)
 *  @Resource(name="") : 같은 type에서 이름 name을 직접 명시해서 연결한다
 *  @Autowired(required=false) : 컨테이너 안에 object가 있으면 injection 하고 없으면 에러 없이 무시해라
 * 
 * 3.기타
 *  @Qualifier :  분류해서 injection 
 *  @Scope("prototype")
 *  @Postconstructor : init-method 대신 사용 
 *  
 */



@Component
public class HomeController {
	//@Autowired prepare에서 달아서 중복되니까 --prepare에서 안하면 여기서 둘다 wired해주기
	private AlarmDevice alarmDevice;
	//@Autowired
	private Viewer viewer;
	
	
	//@Autowired에서 기본값이 required = true인데 생략한다 
	//-- 그리고 Recorder class에 @Component로 빈을 등록하지 않으면 에러가 난다 
	//--이걸 false라고 두면 에러가 안 난다. 빈에 없는 객체를 주입시켰지만 에러가 나지 않는다 
	@Autowired(required = false)
	private Recorder recorder;
	
	
	@Autowired
	@Qualifier("selectDetection") // 같은타입의 객체들 중에 선택된 친구들만 가져오겠다 // 안 붙었을때는 다 가져온다
	private List<RaySensor> sensors;
	
	
	@Resource(name="camera1") //autowired의 이전버전 
	private Camera camera1;
	@Autowired
	private Camera camera2;
	@Autowired
	private Camera camera3;
	@Autowired
	private Camera camera4;
	
	@PostConstruct // 바로 실행되는 
	public void init() {
		System.out.println("init()은 객체연결하자마자 실행합니다");
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		
		
	}
	
	/*
	public void setSensors(List<RaySensor> sensors ) {
		this.sensors = sensors;
	}
	*/
	
	
	//이거는 어노테이션 방식일 때 사용
	@Autowired
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		  this.alarmDevice = alarmDevice;
		  this.viewer = viewer;
	}
	
	
	/*
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
	
	*/
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
