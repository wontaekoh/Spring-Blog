package com.spring.blog.test;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.model.RoleType;
import com.spring.blog.model.User;
import com.spring.blog.repository.UserRepository;

@RestController // 
public class CRUDControllerTest {

	@Autowired // DI (Dependency Injection)
	private UserRepository userRepo;
	
	@DeleteMapping("/test/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "Failed to delete. ID " + id + " is not exist in the database.";
		} 
		
		return "User [ID: " + id + "] is deleted.";
	}
	
	// localhost:8083/blog/test/user/{}
	@Transactional	// Auto-commit when method terminates. -> update changes
	@PutMapping("/test/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id: " + id);
		System.out.println("password: " + requestUser.getPassword());
		System.out.println("email: " + requestUser.getEmail());
		
		User user = userRepo.findById(id).orElseThrow( () -> {
			return new IllegalArgumentException("Failed to Update the user [ID: " + id + "]");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
//		userRepo.save(user);
		return user;
	}
	
	// localhost:8083/blog/test/list
	@GetMapping("/test/list")
	public List<User> list() {
		return userRepo.findAll();
	}
	
	// http://localhost:8083/blog/test/user?page=0
	@GetMapping("/test/user")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagedUser = userRepo.findAll(pageable);
		
		List<User> users = pagedUser.getContent();
		return users;
	}
	
	// localhost:8083/blog/test/user/{}
	@GetMapping("/test/user/{id}")
	public User userDetail(@PathVariable int id) {
		User user = userRepo.findById(id).orElseThrow( () -> {
			return new IllegalArgumentException("No user is found with [ID: " + id + "]");
		});
		
//		User user = userRepo.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				return new IllegalArgumentException("No user is found with [ID: " + id + "]");
//			}
//		});
		return user;
	}
	
	// localhost:8083/blog/test/signup
	@PostMapping("/test/signup")
	public String signUp(User user) {
		System.out.println("id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("CreatedDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepo.save(user);
		return "Registration complated";
	}
}
