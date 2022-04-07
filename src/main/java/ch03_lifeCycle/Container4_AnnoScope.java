package ch03_lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch03_obj.Work;
import ch03_obj.WorkRunner;
import ch03_obj.WorkScheduler;

@Configuration
public class Container4_AnnoScope {

	@Bean 
	@Scope("prototype") // 프로토타입은 @Scope 어노테이션을 붙인다 
	public Work workProto() {
		Work work = new Work();
		work.setTimeout(2000);
		work.setType(Work.WorkType.SINGLE);
		return work;
	}
	
	@Bean
	public WorkRunner workRunner() {
		return new WorkRunner(); 
	}
	
	@Bean 
	public WorkScheduler workScheduler() {
		
		WorkScheduler scheduler  = new WorkScheduler();
		scheduler.setWorkRunner(workRunner()); 
		return scheduler;
	}
	
	
} // end class
