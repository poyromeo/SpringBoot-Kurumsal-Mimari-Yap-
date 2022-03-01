package springapp.myapp.apiControllers;

import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springapp.myapp.business.abstracts.CommentService;

@RestController
@RequestMapping("comments")
public class CommentControllers {
	
	private CommentService commentService;
	@Autowired
	public CommentControllers(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComment(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
		return this.commentService.getAllComment(userId, postId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable long commentId) {
		return this.commentService.getOneComment(commentId);
	}
	

}
