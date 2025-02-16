import React,{useEffect, useState} from 'react';

//ラジオボタンの設定
interface Radio {
	label: string
	value: string
}

const Top: React.FC = () => {
	//20250216 Chat-GPTと相談
	const location = useLocation();
	const quizzes = location.state?.quizzes || [];
//	//選択中のラジオボタン値
//	const [selected,setSelected] = useState("one");
//	//ラジオボタン切り替え
//	const changeValue = (event: React.ChangeEvent<HTMLInputElement>) => setSelected(event.target.value);
//	//ラジオボタンの各値
//	const radioButtons: Radio[] = [
//		{
//			label: "1.",
//			value: "one"
//		},
//		{
//			label: "2.",
//			value: "two"
//		},
//		{
//			label: "3.",
//			value: "three"
//		},
//		{
//			label: "4.",
//			value: "four"
//		}
//	]
  return (
	<div>
		<h2>Challenge</h2>
		{quizzes.length > 0 ? (
			quizzes.map((quiz, index) => (
				<div key={index}>
					<p>問題：{quiz.question}</p>
					<ul>
						<li>{quiz.choice1}</li>
						<li>{quiz.choice2}</li>
						<li>{quiz.choice3}</li>
						<li>{quiz.choice4}</li>
					</ul>
				</div>
			))
		) : (
			<p>クイズが見つかりませんでした。</p>
		)}
	</div>
	);
};
export default Top;
