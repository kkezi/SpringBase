package ch03_obj;

public class Work {

	
	public static enum WorkType { SINGLE }
	
	private long timeout;
	private WorkType type;
	private long order;
	
	
	//public long getTimeout() {
	//	return timeout;
	//}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	//public WorkType getType() {
	//	return type;
	//}
	public void setType(WorkType type) {
		this.type = type;
	}
	public long getOrder() {
		return order;
	}
	public void setOrder(long order) {
		this.order = order;
	}
	
	
	public void run() {
		System.out.printf("Work[timeout = %d, type = %s, order = %d] executed\n", timeout, type, order);
	}
	
	
	
} //end class 
