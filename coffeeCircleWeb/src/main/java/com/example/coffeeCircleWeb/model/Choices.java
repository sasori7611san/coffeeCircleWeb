package com.example.coffeeCircleWeb.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choices {

	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	private Integer choiceId;
	private Integer questionId;
	private Byte choiceNum;
	private String choiceText;
}
