package ch04_obj;

public class MonitorViewer implements Viewer {

	private DisplayMode displayMode;
	
	public void setDisplayMode(DisplayMode displayMode) {
	 this.displayMode = displayMode;
	}

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
