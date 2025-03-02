package com.example.coffeeCircleWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "choices")
public class Choice {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer	id;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "choice_text")
    private String choiceText;

    // コンストラクタ
    public Choice() {}

    public Choice(Integer questionId, String choiceText) {
        this.questionId = questionId;
        this.choiceText = choiceText;
    }

    // ゲッター・セッター
    public Integer getId() { return id; }
    public Integer getQuestionId() { return questionId; }
    public String getChoiceText() { return choiceText; }
}
