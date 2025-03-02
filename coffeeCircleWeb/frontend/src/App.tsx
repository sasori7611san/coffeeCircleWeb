import './App.css';
import React,{useEffect, useState} from 'react';
import { BrowserRouter, Link, Routes, Route, useNavigate } from "react-router-dom";

import Top from "./components/pages/Top";
import Create from "./components/pages/Create"

const Home: React.FC = () => {
	//API空のデータ表示を画面に追加
	const [data, setData] = useState(null);//データ状態を管理
	const navigate = useNavigate();
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
				setData(data);//取得したデータを更新
				console.log(data);//取得したデータをコンソールに表示
			})
			.catch(error => {
				console.error(`API call failed:`, error);//エラーハンドリング
			});
	},[]);//空の依存配列を指定することで、コンポーネントの初回レンダリング時に実行
	// Let's Challerngeをクリックしたときの処理
	const handleChallengeClick = async () => {
		try{
			const response = await fetch("/api/quiz/random?count=3");// ランダムに3問取得するAPI
			if (!response.ok) {
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			const quizData = await response.json();
			navigate("/top", { state: {questions: quizData}});
		} catch(error) {
			console.error("Failed to fetch questions:",error);
		}
	};

  return (
	<div>
		<button onClick={handleChallengeClick}>Let's Challenge</button>
		<Link to="/create">クイズ作成へ</Link>
	</div>

  );};

const App: React.FC = () => {
	return(
		<BrowserRouter>
			<div>
				<h1>Coffee Quiz App</h1>
				{/*画面遷移先の指定*/}
				<Routes>
					{/*Homeを"/"にマッピング */}
					<Route path="/" element={<Home />} />
					{/*Top.tsxのページ */}
					<Route path="/top" element={<Top />} />
					{/*Create.tsxのページ */}
					<Route path="/create" element={<Create />} />
				</Routes>
			</div>
		</BrowserRouter>
	)
}

export default App;
