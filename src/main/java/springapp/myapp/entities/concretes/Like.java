package springapp.myapp.entities.concretes;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
@Table(name="likes")
public class Like {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	//İlişkiselUserTablo...
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="_post_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Post post;
		
	//İlişkiselUserTablo...
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="_user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	
	
	
}
