package com.example.coffeeCircleWeb.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectAnswers {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	private Integer answerId;
	private Integer questioId;
	private Integer collectChoiceId;
	
	//正解と一対一で問題と関連
    @OneToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    //正解と一対一で選択肢と関連
    @OneToOne
    @JoinColumn(name = "correct_choice_id", nullable = false)
    private Choices correctChoice;
}
