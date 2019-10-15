package az.itemsharing.userservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;
	public UserRole() {}
	public UserRole(User user,Role role) {
		this.user=user;
		this.role=role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
}
