package springapp.myapp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springapp.myapp.entities.concretes.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

	List<javax.xml.stream.events.Comment> findByUserIdAndPostId(Long long1, Long long2);

	List<javax.xml.stream.events.Comment> findByUserId(Long long1);

	List<javax.xml.stream.events.Comment> findByPostId(Long long1);



}
