package com.example.coffeeCircleWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeCircleWeb.model.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

}
