package com.spring.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // return files in (src/main/resources/static)
public class TempControllerTest {

	// http://localhost:8083/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		return "/home.html";
	}
	
	// http://localhost:8083/blog/temp/jsp
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		System.out.println("tempJsp()");
		return "test";
	}
}
