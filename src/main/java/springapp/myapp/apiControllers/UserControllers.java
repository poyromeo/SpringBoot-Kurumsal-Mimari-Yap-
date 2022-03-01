package springapp.myapp.apiControllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapp.myapp.business.abstracts.UserService;
import springapp.myapp.core.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserControllers {
	
	private UserService userService;
	@Autowired
	public UserControllers(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User newUser) {
		return this.userService.createUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable long userId) {
		return this.userService.getOneUser(userId);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable  long userId) {
		this.userService.deleteOneUser(userId);
	}
	
	
	
	
	
	
}
