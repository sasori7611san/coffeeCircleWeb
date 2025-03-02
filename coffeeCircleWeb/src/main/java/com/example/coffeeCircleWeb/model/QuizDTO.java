package com.example.coffeeCircleWeb.model;

import java.util.List;

public class QuizDTO {

	private Integer questionId;
	private String questionText;//問題文
	private List<String> choices;//選択肢
	private String explanation;//解説文
	private String correctAnswer;//正解の選択肢
	
	//データ転送用コンストラクタ
    public QuizDTO(Integer questionId, String questionText, String explanation, List<String> choices, String correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.explanation = explanation;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }
    
	public Integer getQuestionId() {
		return questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public List<String> getChoices() {
		return choices;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
