package com.example.coffeeCircleWeb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Question {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Quiz {
	    private int number;
	    private String question;
	    private String choice1;
	    private String choice2;
	    private String choice3;
	    private String choice4;
	    private int answer;
	}
}
