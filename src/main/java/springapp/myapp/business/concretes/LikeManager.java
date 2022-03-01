package springapp.myapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapp.myapp.business.abstracts.LikeService;
import springapp.myapp.dataAccess.abstracts.LikeDao;
import springapp.myapp.entities.concretes.Like;

@Service
public class LikeManager implements LikeService{
	
	private LikeDao likeDao;
	@Autowired
	public LikeManager(LikeDao likeDao) {
		super();
		this.likeDao = likeDao;
	}
	@Override
	public List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return likeDao.findByUserIdAndPostId(userId.get(), postId.get());
			
		}else if (userId.isPresent()) {
			return likeDao.findByUserId(userId.get());
		
		}else if (postId.isPresent()) {
			return likeDao.findByPostId(postId.get());
		
		}else
			return null;
	}
	@Override
	public Like getOneLike(long likeId) {
		return likeDao.findById(likeId).orElse(null);
	}
	
	@Override
	public Like createOneLike(Like newLike) {
		return likeDao.save(newLike);
	}
	
	@Override
	public void deleteOneLike(long likeId) {
		likeDao.deleteById(likeId);
		
	}
	

}
