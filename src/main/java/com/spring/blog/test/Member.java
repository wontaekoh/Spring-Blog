package com.spring.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// Create getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

	private int id;
	private String username;
	private String password;
	private String email;
}
