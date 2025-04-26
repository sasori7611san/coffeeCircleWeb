import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Create: React.FC = () => {
  const navigate = useNavigate();

  const [question, setQuestion] = useState("");
  const [choices, setChoices] = useState(["", "", "", ""]);
  const [correctChoice, setCorrectChoice] = useState(0);
  const [explanation, setExplanation] = useState("");

  const handleChoiceChange = (index: number, value: string) => {
    const newChoices = [...choices];
    newChoices[index] = value;
    setChoices(newChoices);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    const quizData = {
      question,
	  choices,
      correctChoice,
      explanation,
    };

    try {
      const response = await fetch("http://localhost:8080/api/quiz", { //Controllerのエンドポイント(@RequestMappingの括弧記載)niに合わせる
        method: "POST",
        headers: {
			 "Content-Type": "application/json" ,
			 "Accept": "application/json"
		 },
        body: JSON.stringify(quizData),
      });

      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }

      alert("クイズが登録されました！");
      setQuestion("");
      setChoices(["", "", "", ""]);
      setCorrectChoice(0);
      setExplanation("");

      navigate("/"); // Home画面に戻る
    } catch (error) {
      console.error("Error submitting quiz:", error);
      alert("エラーが発生しました。");
    }
  };

  return (
    <div>
      <h2>クイズ作成</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>問題文：</label>
          <textarea value={question} onChange={(e) => setQuestion(e.target.value)} required />
        </div>

        <div>
          <label>選択肢：</label>
          {choices.map((choice, index) => (
            <div key={index}>
              <input
                type="text"
                value={choice}
                onChange={(e) => handleChoiceChange(index, e.target.value)}
                required
              />
              <input
                type="radio"
                name="correctChoice"
                checked={correctChoice === index}
                onChange={() => setCorrectChoice(index)}
              />
              正解
            </div>
          ))}
        </div>

        <div>
          <label>解説：</label>
          <textarea value={explanation} onChange={(e) => setExplanation(e.target.value)} required />
        </div>

        <button type="submit">登録</button>
      </form>
    </div>
  );
};

export default Create;
