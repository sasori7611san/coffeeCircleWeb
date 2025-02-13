package com.example.coffeeCircleWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeCircleWeb.model.QuestionHistory;

public interface QuestionHistoryRepository extends JpaRepository<QuestionHistory, Integer> {

}
