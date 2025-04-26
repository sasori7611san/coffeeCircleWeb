package com.example.coffeeCircleWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeCircleWeb.model.Choice;

public interface ChoicesRepository extends JpaRepository<Choice, Integer> {

	List<Choice> findByQuestion_QuestionId(Integer questionId);
}
