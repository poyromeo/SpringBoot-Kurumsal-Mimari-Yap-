package springapp.myapp.business.abstracts;

import java.util.List;

import springapp.myapp.core.entities.User;


public interface UserService {
	List <User> getAllUsers();
	User createUser(User newUser);
	User getOneUser(long userId);
	void deleteOneUser(long userId);
	
	
}	
