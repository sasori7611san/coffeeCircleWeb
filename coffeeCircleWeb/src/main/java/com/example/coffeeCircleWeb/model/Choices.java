package com.example.coffeeCircleWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "choices")
public class Choices {

	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	@Column(name = "choice_id")
	private Integer choiceId;
	
	@Column(name = "choice_num", nullable = false)
	private Integer choiceNum;
	
	@Column(name = "choice_text", nullable = false)
	private String choiceText;
	
	//選択肢と多対一で問題と関連
	@ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;
	
    // コンストラクタ
    public Choices(Questions question, Integer choiceNum, String choiceText) {
        this.question = question;
        this.choiceNum = choiceNum;
        this.choiceText = choiceText;
    }
    
}
