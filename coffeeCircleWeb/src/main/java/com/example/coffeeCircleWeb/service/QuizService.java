package com.example.coffeeCircleWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeCircleWeb.model.Questions;
import com.example.coffeeCircleWeb.model.Quiz;
import com.example.coffeeCircleWeb.repository.QuestionsRepository;
import com.example.coffeeCircleWeb.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuestionsRepository questionRepository;
	@Autowired
	private QuizRepository quizRepository;
	
	
	// 1. 全ての質問を取得
    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    // 2. 特定の質問を取得
    public Optional<Questions> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    // 3. 質問を新規作成
    public Questions createQuestion(Questions question) {
        return questionRepository.save(question);
    }
    
    // 4. 質問を更新
    public Questions updateQuestion(Integer id, Questions updatedQuestion) {
        Optional<Questions> existingQuestion = questionRepository.findById(id);
        if (existingQuestion.isPresent()) {
            updatedQuestion.setQuestionId(id);
            return questionRepository.save(updatedQuestion);
        } else {
            throw new RuntimeException("Question not found with ID: " + id);
        }
    }

    // 5. 質問を削除
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
    // 6. ランダムに指定した問題数取得
    public List<Quiz> getRandomQuestions(Integer count) {
    	return quizRepository.findRandomQuizzes(count);
    }
	/*
	private List<Question> questions = new ArrayList<>();
	
	@PostConstruct
	public void loadQuestions() {
		try(BufferedReader br =
			new BufferedReader(
				new InputStreamReader(new FileInputStream("quiz_table.csv"), "Shift-JIS")
			)
		){
			String line;
			int k = 0;
			while((line = br.readLine()) != null) {
				if(k++ == 0) continue;
				String[] data = line.split(",");
				questions.add(new Question(
					Integer.parseInt(data[0]),
					data[1],
					data[2],
					data[3],
					data[4],
					data[5],
					Integer.parseInt(data[6])
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Question> getRandomQuestions(int count){
		Collections.shuffle(questions);
		return questions.subList(0, count);
	}
	
	public boolean checkAnswer(int questionNumber, int userAnswer) {
		return questions.stream()
				.filter(q -> q.getNumber() == questionNumber)
				.findFirst()
				.map(q -> q.getAnswer() == userAnswer)
				.orElse(false);
	}
	*/
}
