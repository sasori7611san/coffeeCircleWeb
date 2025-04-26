package com.example.coffeeCircleWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "choices")
public class Choice {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Integer	choiceId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    //private Integer questionId;
    private Questions question;

    @Column(name = "choice_text")
    private String choiceText;

    // コンストラクタ
    public Choice() {}

//    public Choice(Integer questionId, String choiceText) {
//        this.questionId = questionId;
//        this.choiceText = choiceText;
//    }
    public Choice(Questions question, String choiceText) {
        this.question = question;
        this.choiceText = choiceText;
    }

    // ゲッター・セッター
    public Integer getId() { return choiceId; }
    //public Integer getQuestionId() { return questionId; }
    public Questions getQuestion() { return question; }
    public String getChoiceText() { return choiceText; }
}
