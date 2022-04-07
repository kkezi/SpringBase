package ch04_objScan;

import org.springframework.stereotype.Component;

import ch04_obj.WorkUnit;



@Component
public class Worker {

	
	public void work(WorkUnit workUnit) {
		System.out.println(this + " :work: " + workUnit);
	}
}
