package ch04_objScan;

import org.springframework.stereotype.Component;

import ch04_obj.AlarmDevice;





@Component
public class SnsAlarmDevice implements AlarmDevice {
	
	
	public void alarm(String name) { //인터페이스에서 선언된 메서드를 상세하게 구현
		System.out.println(name + "에서 침입탐지됨 . 신고요망");
	}
	

}
