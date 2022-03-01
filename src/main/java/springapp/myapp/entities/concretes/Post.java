package springapp.myapp.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springapp.myapp.core.entities.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	//İlişkiselUserTablo...
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="_user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@NotBlank
	@NotNull
	@Column(name="_title")
	private String title;
	
	@Lob
	@NotBlank
	@NotNull
	@Column(name="_text", columnDefinition="text")
	private String text;
	
	@OneToMany(mappedBy = "post")
	private List<Like> likes;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	
	
	
	
	
}
