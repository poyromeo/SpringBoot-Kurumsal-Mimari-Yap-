package springapp.myapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springapp.myapp.business.abstracts.PostService;
import springapp.myapp.dataAccess.abstracts.PostDao;
import springapp.myapp.entities.concretes.Post;

@Service
public class PostManager implements PostService{

	private PostDao postDao;
	@Autowired
	public PostManager(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent()) 
			return postDao.findByUserId(userId.get());
		return postDao.findAll();
	}
	
	@Override
	public Post getOnePost(long postId) {
		return postDao.findById(postId).orElse(null);
	}
	
	@Override
	public Post createOnePost(Post newPost) {
		return postDao.save(newPost);
	}
	
	
	@Override
	public void deleteOnePost(long postId) {
		postDao.deleteById(postId);
		
	}


	
}
