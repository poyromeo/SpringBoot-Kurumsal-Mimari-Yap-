package springapp.myapp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springapp.myapp.entities.concretes.Like;

public interface LikeDao extends JpaRepository<Like, Long>{

	List<Like> findByUserIdAndPostId(Long long1, Long long2);
	
	List<Like> findByUserId(Long long1);

	List<Like> findByPostId(Long long1);

	

	
}
