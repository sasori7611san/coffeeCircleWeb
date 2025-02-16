package com.example.coffeeCircleWeb.model;

import java.util.List;

public class QuizRequest {
	private String question;
	private List<String> choices;
	private Integer collectAnswer;
	private String explanation;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getChoices() {
		return choices;
	}
	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	public Integer getcollectAnswer() {
		return collectAnswer;
	}
	public void setcollectAnswer(String collectAnswer) {
		this.collectAnswer = Integer.parseInt(collectAnswer);
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
