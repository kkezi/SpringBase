package ch03_obj;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/*
 * BeanPostProcessor : 컨테이너에 객체가 만들어지면 전후에 method를 실행한다
 * 
 * 컨테이너 안에 beanPostProcessor를 상속받은 객체가 bean으로 같이 있으면 
 * 컨테이너 안에 다른 모든 객체가 객체화가 되기 전후에(객체를 만들기 전후에) 어떠한 method를 실행해준다
 * 
 */




public class MyExtension implements BeanPostProcessor {
	
	
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"=====>BeanPostProcessor.postProcessBeforeInitialization()");
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"=====>BeanPostProcessor.postProcessAfterInitialization()");
		return bean;
	}
	

} //end class
