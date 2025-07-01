package com.example.coffeeCircleWeb.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeCircleWeb.model.Choices;
import com.example.coffeeCircleWeb.model.CollectAnswers;
import com.example.coffeeCircleWeb.model.Questions;
import com.example.coffeeCircleWeb.model.QuizDTO;
import com.example.coffeeCircleWeb.model.QuizRequest;
import com.example.coffeeCircleWeb.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:3000")//ReactのURL
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	// 1. 全ての質問を取得
	@GetMapping
	public List<Questions> getAllQuestions() {
		return quizService.getAllQuestions();
	}
	
    // 2. 特定の質問を取得
    @GetMapping("/{id}")
    public Optional<Questions> getQuestionById(@PathVariable Integer id) {
        return quizService.getQuestionById(id);
    }
    
    // 3. 質問を新規作成
    @PostMapping
    public Questions createQuestion(@RequestBody QuizRequest quizRequest) {
    	// QuizRequestからQuestionsエンティティを生成
    	Questions question = new Questions();
    	question.setQuestionText(quizRequest.getQuestion());
    	question.setExplanation(quizRequest.getExplanation());
    	
    	// Choicesを設定
    	List<Choices> choicesList = quizRequest.getChoices().stream()
    			.map(dto -> {
    				Choices choice = new Choices();
    				choice.setChoiceNum(dto.getChoiceNum());
    				choice.setChoiceText(dto.getChoiceText());
    				choice.setQuestion(question);
    				return choice;
    				}) // ← コンストラクタでquestionも設定
    			.collect(Collectors.toList());
    	for (Choices c : choicesList) {
    		c.setQuestion(question);
    	}
    	question.setChoices(choicesList);
    	
    	// 正解を設定
    	CollectAnswers correctAnswer = new CollectAnswers();
    	correctAnswer.setCorrectChoiceId(quizRequest.getCorrectChoice());
    	correctAnswer.setQuestion(question); // ← 一対一関連付けも必要
    	
    	// 正解のChoicesオブジェクトを取得してセット
    	Choices correctChoice = choicesList.stream()
    	    .filter(c -> c.getChoiceNum() == quizRequest.getCorrectChoice())
    	    .findFirst()
    	    .orElseThrow(() -> new IllegalArgumentException("正解の選択肢が見つかりません"));
    	
    	correctAnswer.setCollectChoice(correctChoice);
    	question.setCollectAnswer(correctAnswer);
    	
        return quizService.createQuestion(question);
    }
    
    // 4. 質問を更新
    @PutMapping("/{id}")
    public Questions updateQuestion(@PathVariable Integer id, @RequestBody Questions updatedQuestion) {
        return quizService.updateQuestion(id, updatedQuestion);
    }
    
    // 5. 質問を削除
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        quizService.deleteQuestion(id);
    }
    
    // 6. ランダムに問題を取得
    @GetMapping("/random")
    public List<QuizDTO> getRandomQuestions(@RequestParam(defaultValue = "3") int count) {
    	return quizService.getRandomQuestions(count);
    }
	
}
