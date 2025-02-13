package com.example.coffeeCircleWeb.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
	
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番できる 
	private Integer questionId;
	private String questionText;
	private String explanation;
	private Boolean deletedFlag;
	
	//問題と一対多で選択肢が関連する
	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Choices> choices;
	
	//問題と一対一で正解が関連する
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private CollectAnswers collectAnswer;
	
	//問題と一対一で履歴が関連する
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionHistory history;
}
