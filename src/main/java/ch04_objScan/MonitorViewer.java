package ch04_objScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch04_obj.Camera;
import ch04_obj.DisplayMode;
import ch04_obj.Viewer;




@Component
public class MonitorViewer implements Viewer {

	@Autowired
	private DisplayMode displayMode;
	
	/* 
	 * 여기에 autowired걸어도 된다 그렇다고 위에 객체는 지울수는 없다 
	public void setDisplayMode(DisplayMode displayMode) {
	 this.displayMode = displayMode;
	}
	*/
	
	@Override
	public void draw() {
		System.out.println(displayMode.getType() + " 모드로 카메라 이미지 출력됨");
		
		
	}

	@Override
	public void add(Camera camera) {
		// TODO Auto-generated method stub
		System.out.println("모니터에 " + camera + " 영상 추가");
		
	}
}
