package com.userapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.userapi.model.User;
import com.userapi.repository.UserRepository;
import com.userapi.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	    @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserService userService;

	    @Test
	    void shouldReturnAllUsers() {
	        List<User> users = List.of(new User());
	        when(userRepository.findAll()).thenReturn(users);

	        List<User> result = userService.getAllUsers();

	        assertEquals(1, result.size());
	        assertEquals("alice", result.get(0).getUsername());
	    }

	    @Test
	    void shouldCreateUser() {
	        User input = new User();
	        User saved = new User();
	        when(userRepository.save(input)).thenReturn(saved);

	        User result = userService.createUser(input);

	        assertEquals(1L, result.getId());
	    }
	}
