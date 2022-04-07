package ch02_objScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch02_obj.AuthFailLogger;
import ch02_obj.User;
import ch02_obj.UserNotFoundException;

/*
1) container : <context:component-scan base-package="ch02_objScan"/>
	----bean으로 가져오는 대신에 @Component 어노테이션으로 패키지에 있는 클래스를 가져옵니다
	
2) wired :
	
	<bean id = "authenticationService" class ="ch02_obj.AuthenticationService">
		<property name = "userRepository" ref = "userRepository" />
		<property name = "authFailLogger" ref = "authFailLogger"/>
	</bean>
	
	----set으로 프로퍼티 설정하는 대신에 프로퍼티는 @Autowired로 연결합니다
	autowired는 class type이 1개만 있어야한다
*/


@Component //ch02_objScan에 있는 객체를 component-scan으로 자동으로 가져옵니다
public class AuthenticationService {
	
	@Autowired //프로퍼티를 자동으로 연결해줍니다
	UserRepository userRepository;
	
	@Autowired
	AuthFailLogger authFailLogger;
	
	/*
	자동으로 연결해주니까 이 과정이 필요없습니다
	//setter injection 방식
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//setter injection 방식
	public void setAuthFailLogger(AuthFailLogger authFailLogger) {
		this.authFailLogger = authFailLogger;
	}
	*/
	public void authenticate(String userId, String password) {
		User user = userRepository.findUserById(userId); //아이디 확인
		
		if(user == null) {
			throw new UserNotFoundException();			
		}
		if(!user.getPassword().equals(password)) {
			System.out.println("login 불가합니다");
			
			authFailLogger.insertBadPw(userId, password);
								
		} else {
			System.out.println("login이 되었습니다");
		}
		
		
		System.out.println(userId + " : " + password);
	}
	
	
}
