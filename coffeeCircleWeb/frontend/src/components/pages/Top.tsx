import React,{useEffect, useState} from 'react';

//ラジオボタンの設定
interface Radio {
	label: string
	value: string
}

const Top: React.FC = () => {
	//選択中のラジオボタン値
	const [selected,setSelected] = useState("one");
	//ラジオボタン切り替え
	const changeValue = (event: React.ChangeEvent<HTMLInputElement>) => setSelected(event.target.value);
	//ラジオボタンの各値
	const radioButtons: Radio[] = [
		{
			label: "1.",
			value: "one"
		},
		{
			label: "2.",
			value: "two"
		},
		{
			label: "3.",
			value: "three"
		},
		{
			label: "4.",
			value: "four"
		}
	]
  return (
    <div className="App">
		<h2>問題</h2>
		<p>○○××etc...</p>
		<div className="Answer">
		{radioButtons.map(radio => {
			return(
				<div className="AnswerChoice">
					<input className="AnswerInput" type="radio" name="choice"
						value={radio.value} checked={radio.value === selected} onChange={changeValue}/>
					<label className="Choices">
						<span className="labels">{radio.label}</span>
					</label>
				</div>
			)
		})}			
		</div>
		<div>{selected}を選択</div>
    </div>
  );
};
export default Top;
