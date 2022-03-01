package springapp.myapp.business.abstracts;

import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.Comment;

public interface CommentService {
	
	List<Comment> getAllComment(Optional<Long> userId, Optional<Long> postId);
	Comment getOneComment(long commentId);
	
	
}
