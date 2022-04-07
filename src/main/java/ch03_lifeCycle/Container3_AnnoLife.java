package ch03_lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch03_obj.ConnPool1;
import ch03_obj.ConnPool2;
import ch03_obj.ConnPool3;
import ch03_obj.MyBean;
import ch03_obj.MyExtension;

//Container1_lifeCycle을 어노테이션으로 바꿔보기

@Configuration
public class Container3_AnnoLife {
	
	@Bean
	public MyExtension extention()  {
		//인스턴스를 리턴
		return new MyExtension();
	}

	@Bean
	public ConnPool1 connPool1()  {
		
		return new ConnPool1();
	}
	
	@Bean
	public ConnPool2 connPool2() {
	
		return new ConnPool2();
		
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ConnPool3 connPool3() {
		return new ConnPool3();
	}
	
	@Bean
	public MyBean myBean() {
		//세팅해야하니까 인스턴스 만들어서 세팅한 객체를 리턴
		MyBean myBean = new MyBean();
		myBean.setProperty1("값1");
		return myBean;
	}
}
