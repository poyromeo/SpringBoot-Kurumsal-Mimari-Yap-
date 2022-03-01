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

import springapp.myapp.business.abstracts.LikeService;
import springapp.myapp.entities.concretes.Like;

@RestController
@RequestMapping("likes")
public class LikeControllers {
	
	private LikeService likeService;
	@Autowired
	public LikeControllers(LikeService likeService) {
		super();
		this.likeService = likeService;
	}
	
	@GetMapping
	public List<Like> getAllLike(@RequestParam Optional<Long> userId, @RequestParam  Optional<Long> postId){
		return this.likeService.getAllLike(userId, postId);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable long likeId) {
		return this.likeService.getOneLike(likeId);
	}
	
	@PostMapping("/{likeId}")
	public Like createOneLike(@RequestBody Like newLike) {
		return this.likeService.createOneLike(newLike);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOnePost(long postId) {
		this.likeService.deleteOneLike(postId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
