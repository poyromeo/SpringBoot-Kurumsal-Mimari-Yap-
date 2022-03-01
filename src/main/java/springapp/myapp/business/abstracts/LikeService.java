package springapp.myapp.business.abstracts;

import java.util.List;
import java.util.Optional;

import springapp.myapp.entities.concretes.Like;

public interface LikeService {
	List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId);
	Like getOneLike(long likeId);
	Like createOneLike(Like newLike);
	void deleteOneLike(long likeId);

}
