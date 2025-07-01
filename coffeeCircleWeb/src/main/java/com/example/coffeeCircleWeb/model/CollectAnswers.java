package com.example.coffeeCircleWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collect_answers")
public class CollectAnswers {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	@Column(name = "answer_id")
	private Integer answerId;
	
	@Column(name = "correct_choice_id", nullable = false)
	private Integer correctChoiceId;
	
	//正解と一対一で問題と関連
    @OneToOne
    @JoinColumn(name = "question_id", nullable = false)
     private Questions question;
	
	@OneToOne
	@JoinColumn(name = "collect_choice_id", nullable = false)
	private Choices collectChoice;
}
