package springapp.myapp.business.abstracts;

import java.util.List;
import java.util.Optional;

import springapp.myapp.entities.concretes.Post;

public interface PostService {
	List<Post> getAllPosts(Optional<Long> userId);
	Post getOnePost(long postId);
	Post createOnePost(Post newPost);
	void deleteOnePost(long postId);
	
}
