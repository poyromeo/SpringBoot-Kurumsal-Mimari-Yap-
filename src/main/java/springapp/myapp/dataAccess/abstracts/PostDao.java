package springapp.myapp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springapp.myapp.entities.concretes.Post;

public interface PostDao extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long long1);
	Post save(long postId);
	

}
