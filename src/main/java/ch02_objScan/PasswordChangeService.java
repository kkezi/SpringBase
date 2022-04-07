package ch02_objScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch02_obj.User;
import ch02_obj.UserNotFoundException;

/*
 * 생성자는 놔두고 autowired합니다
 * <bean id = "pwChangeSvc" class = "ch02_obj.PasswordChangeService">
		<!-- 생성자 ref 이렇게 따로 써도 됩니다 -->
		<constructor-arg>
			<ref bean = "userRepository"></ref>
		</constructor-arg>
	</bean>
	
 */

@Component("pwChangeSvc")
public class PasswordChangeService {
	
	UserRepository userRepository;
	
	@Autowired
	public PasswordChangeService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public void changePassword(String userId, String oldPw, String newPw) {
		User user = userRepository.findUserById(userId);
		System.out.println("old:" +user);
		if(user == null)
			throw new UserNotFoundException();
		if(user.getPassword().equals(oldPw))
		{	user.setPassword(newPw);
		System.out.println("new:" +user); }
		else
		{	throw new IllegalArgumentException("illegal password");}
		
		
		
	}
	
	

}
