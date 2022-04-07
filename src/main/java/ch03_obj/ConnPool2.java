package ch03_obj;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool2 {

	
	//Container1에서 <context:annotation-config /> 의해 자바어노테이션 실행
	@PostConstruct
	public void initPool() {
		System.out.println("@PostConstruct  =====>ConnPool.initPool()");
	}
	
	@PreDestroy
	public void destroyPool() {
		System.out.println("@PreDestroy  =====>ConnPool.destroyPool()");
	}
	
}
