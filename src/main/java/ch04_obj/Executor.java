package ch04_obj;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Executor  {
	
	Worker worker;
	//ApplicationContext ctx;

	public void setWorker(Worker worker) {
		this.worker = worker;	
	}
	
	
	public void addUnit(WorkUnit workUnit) {
		
		worker.work(workUnit);
	}


	
} // end class
