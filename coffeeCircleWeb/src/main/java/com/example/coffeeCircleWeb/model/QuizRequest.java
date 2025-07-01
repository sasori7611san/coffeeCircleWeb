package com.example.coffeeCircleWeb.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizRequest {
	private String question;
	private List<ChoiceDTO> choices;
	private Integer correctChoice;
	private String explanation;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<ChoiceDTO> getChoices() {
		return choices;
	}
	public void setChoices(List<ChoiceDTO> choices) {
		this.choices = choices;
	}
	public Integer getCorrectChoice() {
		return correctChoice;
	}
	public void setCorrectChoice(Integer correctAnswer) {
		this.correctChoice = correctAnswer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
