package com.example.coffeeCircleWeb.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.coffeeCircleWeb.model.Questions;

public interface QuizRepository extends JpaRepository<Questions, Integer>{

	//ランダムに問題を取得するクエリ
	//@Query(value = "SELECT * FROM questions q LEFT JOIN choices c ON c.question_id=q.question_id LEFT JOIN collect_answers a ON a.question_id=q.question_id ORDER BY RAND() LIMIT :count", nativeQuery = true)
//	List<Quiz> findRandomQuizzes(@Param("count") int count);
//	@Query(value = "SELECT * FROM questions ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
	//List<Questions> findRandomQuestions(@Param("count") int count);
}
