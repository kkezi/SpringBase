package ch03_obj;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WorkScheduler implements ApplicationContextAware{

	private WorkRunner workRunner;
	private ApplicationContext ctx;
	
	public void setWorkRunner(WorkRunner workRunner) {
		this.workRunner = workRunner;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	
	public void makeAndRunWork() {
		
		for(long order = 1; order <= 10; order++) {
			Work work = ctx.getBean("workProto",Work.class); //만들때마다 새로운 객체Bean을 만듬 
			System.out.println(work);
			work.setOrder(order);
			workRunner.execute(work);
		}
		
	}
	
	
	
	
} //end class
