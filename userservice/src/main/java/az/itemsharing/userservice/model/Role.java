package az.itemsharing.userservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Role {
	@Id
	private long roleId;
	private String name;
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<UserRole> userRole=new HashSet<>();
	public Role() {}
}
