package com.example.coffeeCircleWeb.repository;

import java.util.List;

import com.example.coffeeCircleWeb.model.QuizDTO;

public interface QuestionsRepositoryCustom {
	List<QuizDTO> findRandomQuestions(int count);
}
