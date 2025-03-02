import React,{useEffect, useState} from 'react';
import {Link} from 'react-router-dom';

interface Choice {
	choiceText: string;
}

interface Question {
	questionId: number;
	questionText: string;
	explanation: string;
	choices: Choice[];
}

const Top: React.FC = () => {

	const [questions, setQuestions] = useState<Question[]>([]);
	
	useEffect(() => {
		fetch('/api/quiz/random?count=3')
		.then(response => response.json())
		.then(data => setQuestions(data as Question[]))
		.catch(error => console.error('Error fetching questions:', error));
	},[]);
 	return (
		<div>
			<h2>Challenge</h2>
			{questions.length > 0 ? (
				questions.map((quiz, index) => (
					<div key={index}>
						<h2>{quiz.questionText}</h2>
						<ul>
							{quiz.choices.map((choice, i) => (
								<li key={i}>{choice.choiceText}</li>
							))}
						</ul>
					</div>
				))
			) : (
				<p>Loading...</p>
			)}
			<Link to="">戻る</Link>
		</div>
	);
};
export default Top;
