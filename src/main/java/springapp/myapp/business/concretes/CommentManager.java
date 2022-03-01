package springapp.myapp.business.concretes;

import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapp.myapp.business.abstracts.CommentService;
import springapp.myapp.dataAccess.abstracts.CommentDao;

@Service
public class CommentManager implements CommentService{
	
	
	private CommentDao commentDao;
	@Autowired
	public CommentManager(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	
	@Override
	public List<Comment> getAllComment(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentDao.findByUserIdAndPostId(userId.get(), postId.get());
			
		}else if (userId.isPresent()) {
			return commentDao.findByUserId(userId.get());
		
		}else if (postId.isPresent()) {
			return commentDao.findByPostId(postId.get());
		
		}else
			return null;
		
	}


	@Override
	public Comment getOneComment(long commentId) {
		return (Comment) commentDao.findById(commentId).orElse(null);
	}



}
