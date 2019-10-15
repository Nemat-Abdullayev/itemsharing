package az.itemsharing.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import az.itemsharing.userservice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
