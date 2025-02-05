import './App.css';
import React,{useEffect, useState} from 'react';
import { BrowserRouter, Link, Routes, Route } from "react-router-dom";

import Top from "./components/pages/Top";

const Home: React.FC = () => {
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
				setData(data);//取得したデータを更新
				console.log(data);//取得したデータをコンソールに表示
			})
			.catch(error => {
				console.error(`API call failed:`, error);//エラーハンドリング
			});
	},[]);//空の依存配列を指定することで、コンポーネントの初回レンダリング時に実行

  return (
	<div>
		<h1>APIからデータ</h1>
		{data ? (
			<pre>{JSON.stringify(data,null,2)}</pre>//データを画面に表示
		) : (
			<p>Loading...</p>
		)}
	
		<Link to="/top">Topへ</Link>	
	</div>
  );};

const App: React.FC = () => {
	return(
		<BrowserRouter>
			<Routes>
				{/*Homeを"/"にマッピング */}
				<Route path="/" element={<Home />} />
				{/*Top.tsxのページ */}
				<Route path="/top" element={<Top />} />
			</Routes>
		</BrowserRouter>
	)
}

export default App;
