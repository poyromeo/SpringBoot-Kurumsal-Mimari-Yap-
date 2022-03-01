package springapp.myapp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapp.myapp.business.abstracts.UserService;
import springapp.myapp.core.dataAccess.UserDao;
import springapp.myapp.core.entities.User;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Override
	public User createUser(User newUser) {
		return userDao.save(newUser);
	}
	
	@Override
	public User getOneUser(long userId) {
		return userDao.findById(userId).orElse(null);
	}
	
	@Override
	public void deleteOneUser(long userId) {
		userDao.deleteById(userId);
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
