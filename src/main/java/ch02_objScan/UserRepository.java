package ch02_objScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch02_obj.User;

@Component
public class UserRepository {

	//<property name = "users"> : setter injection
	
	private Map<String, User> map = new HashMap<>();
	
	@Autowired
	public void setUsers(List<User> li) {
		for(User u : li) {
			map.put(u.getId(), u);
			System.out.println(u);
		}
		
	}
	
	
	public User findUserById(String id) {
		
		return map.get(id);
		
		
	}
	
	
} //end class
