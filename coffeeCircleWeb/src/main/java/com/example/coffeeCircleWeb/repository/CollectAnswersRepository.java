package com.example.coffeeCircleWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.coffeeCircleWeb.model.CollectAnswers;

public interface CollectAnswersRepository extends JpaRepository<CollectAnswers, Integer> {

    @Query("SELECT ca FROM CollectAnswers ca WHERE ca.question.questionId = :questionId")
    CollectAnswers findByQuestion_QuestionId(@Param("questionId") Integer questionId);

    @Query("SELECT ca.correctChoiceId FROM CollectAnswers ca WHERE ca.question.questionId = :questionId")
    Integer findCorrectChoiceIdByQuestionId(@Param("questionId") Integer questionId);
}
