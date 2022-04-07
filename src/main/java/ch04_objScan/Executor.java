package ch04_objScan;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch04_obj.WorkUnit;




@Component
public class Executor  {
	
	
	@Autowired
	Worker worker;
	//ApplicationContext ctx;
	

	/*
	 * autowired로 객체를 집어넣었으니까 이 메서드는 필요없음
	public void setWorker(Worker worker) {
		this.worker = worker;	
	}
	*/
	
	public void addUnit(WorkUnit workUnit) {
		
		worker.work(workUnit);
	}


	
} // end class
