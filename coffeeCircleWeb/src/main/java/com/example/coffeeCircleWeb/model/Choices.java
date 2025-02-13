package com.example.coffeeCircleWeb.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	
	//選択肢と多対一で問題と関連
	@ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;
}
