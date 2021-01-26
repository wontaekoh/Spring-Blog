package com.spring.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// User requests -> server responses data
@RestController // returns String
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest ";
	
	// http://localhost:8083/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("Bob").password("bob123").email("bob@email.com").build();
		System.out.println(TAG + "getter: " + m.getPassword());
		m.setPassword("passwd");
		System.out.println(TAG + "setter: " + m.getPassword());
		
		return "lombok test completed";
	}
	
	// only get request is allowed in browser
	// http://localhost:8083/blog/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { // MessageConverter
		return "Request GET: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8083/blog/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { // MessageConverter
		return "Request POST: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8083/blog/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) { // MessageConverter
		return "Request PUT: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8083/blog/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "Request DELETE";
	}
}
