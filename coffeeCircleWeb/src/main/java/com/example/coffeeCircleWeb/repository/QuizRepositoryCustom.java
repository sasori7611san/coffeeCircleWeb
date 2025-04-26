package com.example.coffeeCircleWeb.repository;

import java.util.List;

import com.example.coffeeCircleWeb.model.QuizDTO;

public interface QuizRepositoryCustom {
	List<QuizDTO> findRandomQuestions(int count);
}
