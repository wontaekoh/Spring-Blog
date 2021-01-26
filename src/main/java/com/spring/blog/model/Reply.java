package com.spring.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)	// One (board) to Many (replies)
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne(fetch = FetchType.EAGER)	// One (user) to Many (replies)
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
