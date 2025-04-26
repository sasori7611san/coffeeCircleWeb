package com.example.coffeeCircleWeb.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.coffeeCircleWeb.model.QuizDTO;

@Repository
public class QuizRepositoryCustomImpl implements QuizRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<QuizDTO> findRandomQuestions(int count){
        String sql = "SELECT * FROM questions q "
                + "LEFT JOIN choices c ON c.question_id = q.question_id "
                + "LEFT JOIN collect_answers a ON a.question_id = q.question_id "
                + "ORDER BY RAND() LIMIT " + count; // 直接 count を埋め込む

     Query query = entityManager.createNativeQuery(sql, QuizDTO.class);
     return query.getResultList();
	}
}
