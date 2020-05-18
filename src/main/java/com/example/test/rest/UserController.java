package com.example.test.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dao.UserRepository;
import com.example.test.entity.User;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	//Create a new user
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	//Read all users
	@GetMapping("/users")
	public @ResponseBody List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//Read an user according to the corresponding id
	@GetMapping("/users/{id}")
	public @ResponseBody User getUser(@PathVariable int id){
		
		Optional <User> result = userRepository.findById(id);
		User user = null;
		
		if(result.isPresent())
		{
			user = result.get();
		} else {
			throw new RuntimeException("Did not find user Id - " + id);
		}
		return user;
	}
	
	//Update an user according to the corresponding id
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user) {
		
		userRepository.save(user);
		return user;
	}
	
	//Delete an user according to the corresponding id
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
	
		Optional <User> result = userRepository.findById(id);
		User user = null;
		
		if(result.isPresent())
		{
			user = result.get();
			userRepository.delete(user);
		} else {
			throw new RuntimeException("Did not find user Id - " + id);
		}
		return "User n°" + id + " deleted";
	}
}
