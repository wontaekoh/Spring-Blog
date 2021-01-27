package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.model.User;

// DAO
public interface UserRepository extends JpaRepository<User, Integer>{

}
