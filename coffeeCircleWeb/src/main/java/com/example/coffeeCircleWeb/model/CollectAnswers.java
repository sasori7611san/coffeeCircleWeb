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
	
	
	//private Integer questioId;
	
	@Column(name = "correct_choice_id", nullable = false)
	private Integer collectChoiceId;
	
	//正解と一対一で問題と関連
    @OneToOne
    @JoinColumn(name = "question_id", nullable = false)
     private Questions question;

//    //正解と一対一で選択肢と関連
//    @OneToOne
//    @JoinColumn(name = "correct_choice_id", nullable = false)
//    private Choices correctChoice;
}
