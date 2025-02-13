package com.example.coffeeCircleWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeCircleWeb.model.AnswerResult;
import com.example.coffeeCircleWeb.model.Question;
import com.example.coffeeCircleWeb.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:3000")//ReactのURL
public class QuizController {
	

	@Autowired
	private QuizService quizService;
	
	
	@GetMapping("/questions")
	public List<Question> getQuestions(@RequestParam(defaultValue="3") int count){
		return quizService.getRandomQuestions(count);
	}
	
	@PostMapping("/answer")
	public AnswerResult submitAnswer(@RequestParam int questionNumber, @RequestParam int userAnswer) {
		boolean isCorrect = quizService.checkAnswer(questionNumber, userAnswer);
		return new AnswerResult(isCorrect, isCorrect ? 10 : 0);
	}
}
