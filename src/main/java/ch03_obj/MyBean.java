package ch03_obj;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware, ApplicationContextAware,
		InitializingBean,DisposableBean {
	//container에서 init,destroy method(custom) 명시해주었고, annotation-config 태그 달아주었기 때문에 자바@ PostConstruct ...사용도 가능

	public void setProperty1(String property1) {
		System.out.println("MyBean.setProperty1() 실행");
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() 실행");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext() 실행");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() 실행");
	}
	
	public void customInit() {
		System.out.println("MyBean.customInit() 실행");
	}
	
	@PostConstruct
	public void PostConstruct() {
		System.out.println("@PostConstruct() 실행");
	}
	
	@PreDestroy
	public void PreDestroy() {
		System.out.println("@PreDestroy() 실행");
	}
	

	@Override
	public void destroy() throws Exception{
		System.out.println("DisposableBean.destroy() 실행");
	}
	
	public void customDestroy() {
		System.out.println("MyBean.customDestroy() 실행");
	}
	
	
	
	
} //end class
