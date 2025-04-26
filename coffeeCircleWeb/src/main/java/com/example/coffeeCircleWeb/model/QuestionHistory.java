package com.example.coffeeCircleWeb.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question_history")
public class QuestionHistory {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	@Column(name = "id")
	private Integer id;
	//private Integer questionId;
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
