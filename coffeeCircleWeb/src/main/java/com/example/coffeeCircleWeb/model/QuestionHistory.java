package com.example.coffeeCircleWeb.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHistory {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	private Integer id;
	private Integer questionId;
    @CreatedDate//作成日時を自動取得
    @Column(updatable = false)
	private LocalDateTime createDate;
	private String createUser;
	@LastModifiedDate//更新日時を自動取得
	private LocalDateTime updateDate;
	private String updateUser;
	
	//履歴と一対一で問題と関連
    @OneToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;
}
