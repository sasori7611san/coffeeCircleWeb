package com.example.coffeeCircleWeb.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHistory {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	private Integer id;
	private Integer questionId;
	private LocalDateTime createDate;
	private String createUser;
	private LocalDateTime updateDate;
	private String updateUser;
}
