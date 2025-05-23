package com.example.coffeeCircleWeb.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.coffeeCircleWeb.model.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer>, QuestionsRepositoryCustom {

	//ランダムに問題を取得するクエリ
//	@Query(value = "SELECT * FROM questions q LEFT JOIN choices c ON c.question_id=q.question_id LEFT JOIN collect_answers a ON a.question_id=q.question_id ORDER BY RAND() LIMIT :count", nativeQuery = true)
//	List<Questions> findRandomQuestions(@Param("count") int count);
	//@Query(value = "SELECT * FROM questions q LEFT JOIN choices c ON c.question_id=q.question_id LEFT JOIN collect_answers a ON a.question_id=q.question_id ORDER BY RAND() LIMIT ?1", nativeQuery = true)
	//List<Questions> findRandomQuestions(int count);

}
