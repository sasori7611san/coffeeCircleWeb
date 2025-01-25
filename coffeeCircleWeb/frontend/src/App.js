import logo from './logo.svg';
import './App.css';
import React,{useEffect, useState} from 'react';

function App() {
	//API空のデータ表示を画面に追加
	const [data, setData] = useState(null);//データ状態を管理
	//基本動作
	useEffect(() => {
		fetch('/api/endpoint')//プロキシ設定を利用する為、フルURLは不要
			.then(response => {
				if(!response.ok) {
					throw new Error(`HTTP error! status: ${response.status}`);
				}
				return response.json();
			})
			.then(data => {
				console.log(data);//取得したデータをコンソールに表示
			})
			.catch(error => {
				console.error(`API call failed:`, error);//エラーハンドリング
			});
	},[]);//空の依存配列を指定することで、コンポーネントの初回レンダリング時に実行
  return (
    <div className="App">
		<h1>APIからのデータ</h1>
		{data ? (
			<pre>{JSON.stringify(data,null,2)}</pre>//データを画面に表示
		) : (
			<p>Loading...</p>
		)}
		<h2>Question</h2>
		<div>
			<input type="radio" id="one" name="answer" value="1" />
				<label for="one">1</label>
		</div>
		<div>
			<input type="radio" id="two" name="answer" value="2" />
				<label for="two">2</label>
		</div>
		<div>
			<input type="radio" id="three" name="answer" value="3" />
				<label for="three">3</label>
		</div>
		<div>
			<input type="radio" id="four" name="answer" value="4" />
				<label for="four">4</label>
		</div>
    </div>
  );
}

export default App;
