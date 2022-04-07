package ch02_obj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

	//<property name = "users"> : setter injection
	
	private Map<String, User> map = new HashMap<>();
	
	public void setUsers(List<User> li) {
		for(User u : li) {
			map.put(u.getId(), u);
			System.out.println(u);
		}
		
	}
	
	
	public User findUserById(String id) {
		
		return map.get(id);
		
		
	}
	
	
}
