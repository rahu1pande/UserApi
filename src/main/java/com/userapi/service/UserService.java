
package com.userapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.userapi.model.User;
import com.userapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	    private final UserRepository userRepository;

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public Optional<User> getUserById(Long id) {
	        return userRepository.findById(id);
	    }
	    
	    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
