package springapp.myapp.apiControllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springapp.myapp.business.abstracts.PostService;
import springapp.myapp.entities.concretes.Post;

@RestController
@RequestMapping("/posts")
public class PostControllers {

	private PostService postService;
	@Autowired
	public PostControllers(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return this.postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable long postId) {
		return this.postService.getOnePost(postId);
	}
	
	@PostMapping("/{postId}")
	public Post createOnePost(@RequestBody Post newPost) {
		return this.postService.createOnePost(newPost);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(long postId) {
		this.postService.deleteOnePost(postId);
	}
	
	
	
	
}
