package az.itemsharing.userservice.service;

import az.itemsharing.userservice.model.User;

public interface UserService {
	User createUser(User user);
	User getUserByUsername(String username);

}
