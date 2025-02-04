import './App.css';
import React,{useEffect, useState} from 'react';

const App: React.FC = () => {
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
    </div>
  );
}

export default App;
