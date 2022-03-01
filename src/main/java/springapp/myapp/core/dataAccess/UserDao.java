package springapp.myapp.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import springapp.myapp.core.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
	
}
