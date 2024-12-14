package com.bhawnagunwani.SpringBootDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhawnagunwani.SpringBootDemo.entity.User;
import com.bhawnagunwani.SpringBootDemo.exceptions.GenericException;
import com.bhawnagunwani.SpringBootDemo.exceptions.UserNotFoundException;
import com.bhawnagunwani.SpringBootDemo.repository.UserRepository;

@Service
public class UserService {

	public List<User> getAllUsers() {
		if(UserRepository.users.isEmpty())
			throw new GenericException("No Users Found.");
		return UserRepository.users;
	}
	
	public User addUser(User user) {
		UserRepository.users.add(user);
		return user;
	}
	
	public Optional<User> getUserById(Long id) {
		return UserRepository.users.stream()
				.filter(user -> user.getId().equals(id)).findFirst();
	}
	
	public User updateUser(Long id, User updatedUser) {
		return getUserById(id).map(user -> {
			user.setName(updatedUser.getName());
			user.setAge(updatedUser.getAge());
			return user;
		}).orElseThrow(() -> new UserNotFoundException("User not found with Id: " + id));
	}
	
	public void deleteUser(Long id) {
		UserRepository.users.removeIf(user -> user.getId().equals(id));
	}
	
	
	
}
