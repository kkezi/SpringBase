package ch02_obj;

public class PasswordChangeService {
	
	UserRepository userRepository;
	
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
