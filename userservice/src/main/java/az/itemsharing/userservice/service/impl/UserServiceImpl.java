package az.itemsharing.userservice.service.impl;

import az.itemsharing.userservice.model.Role;
import az.itemsharing.userservice.model.UserRole;
import az.itemsharing.userservice.utility.SecurityUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.itemsharing.userservice.model.User;
import az.itemsharing.userservice.repository.UserRepository;
import az.itemsharing.userservice.service.UserService;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            LOG.info("User with username {} already exists.Nothing will be done. " + user.getUsername());
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            Role localRole = new Role();
            localRole.setRoleId(1);
            userRoles.add(new UserRole(user, localRole));
            user.getUserRoles().addAll(userRoles);

            Date today = new Date();
            user.setJoinDate(today);
            String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
            user.setPassword(encryptedPassword);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
