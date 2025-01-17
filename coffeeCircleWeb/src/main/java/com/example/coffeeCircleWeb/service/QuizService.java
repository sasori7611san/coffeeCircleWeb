package com.example.coffeeCircleWeb.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.coffeeCircleWeb.model.Question;

@Service
public class QuizService {
	private List<Question> questions = new ArrayList<>();
	
	@PostConstruct
	public void loadQuestions() {
		try(BufferedReader br =
			new BufferedReader(
				new InputStreamReader(new FileInputStream("quiz_table.csv"), "Shift-JIS")
			)
		){
			String line;
			int k = 0;
			while((line = br.readLine()) != null) {
				if(k++ == 0) continue;
				String[] data = line.split(",");
				questions.add(new Question(
					Integer.parseInt(data[0]),
					data[1],
					data[2],
					data[3],
					data[4],
					data[5],
					Integer.parseInt(data[6])
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Question> getRandomQuestions(int count){
		Collections.shuffle(questions);
		return questions.subList(0, count);
	}
	
	public boolean checkAnswer(int questionNumber, int userAnswer) {
		return questions.stream()
				.filter(q -> q.getNumber() == questionNumber)
				.findFirst()
				.map(q -> q.getAnswer() == userAnswer)
				.orElse(false);
	}
}
