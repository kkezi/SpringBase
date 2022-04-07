package ch02_obj;

public class AuthenticationService {
	UserRepository userRepository;
	
	AuthFailLogger authFailLogger;
	
	//setter injection 방식
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//setter injection 방식
	public void setAuthFailLogger(AuthFailLogger authFailLogger) {
		this.authFailLogger = authFailLogger;
	}
	
	
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
