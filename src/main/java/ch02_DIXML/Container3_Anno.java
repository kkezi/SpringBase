package ch02_DIXML;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch02_obj.AuthFailLogger;
import ch02_obj.AuthenticationService;
import ch02_obj.PasswordChangeService;
import ch02_obj.User;
import ch02_obj.UserRepository;



/* Container3.xml을 java로 옮기는 작업
 * 
 * xml없이 컨테이너 만들기 위한 추가 설명 xml과 anno의 차이 
 * container resource를 만드는 방법 : 1) xml 2) java annotation
 * 1) xml은 메인에서 factory = new GenericXmlApplicationContext("classpath:ch02_DIXML/Container4_scan.xml"); 이렇게 만드는 것
 * 
 * 2) anno는 메인에서 factory = new AnnotationConfigApplicationContext(Container3_Anno.class); 이렇게 하고 
 * !!!!!!!자바 클래스를 리소스로 쓰려면 anno로 configuration을 써야한다!!!!!!! 
 * 
 * 
 * 
 * xml에서는 <beans ......> 사용해서 factory.getBean하지만  
 * anno에서의 bean은 @bean을 사용해서 생성
 */




@Configuration
public class Container3_Anno {
	
	
	@Bean
	//public xml에서의 class, id ()    
	public User user1() {
		return new User("kicuser","1111");
	}
	
	@Bean
	public User user2() {
		return new User("kicstu","1234");
	}
	
	
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService a = new AuthenticationService();
		a.setUserRepository(userRepository());
		a.setAuthFailLogger(authFailLogger());
		return a;
		
	}
	
	
	@Bean
	public UserRepository userRepository() {
		UserRepository u = new UserRepository();
		u.setUsers(Arrays.asList(user1(),user2()));
		return u;
	}
	

	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger auth = new AuthFailLogger();
		auth.setThreshold(2);
		return auth;
	}
	
	
	@Bean("pwChangeSvc")
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
	}
	
	
} //end class 
