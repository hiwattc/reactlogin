npx create-react-app news-app
cd news-app
npm install axios

import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [news, setNews] = useState([]);

  useEffect(() => {
    const fetchNews = async () => {
      try {
        const response = await axios.get(
          'https://newsapi.org/v2/top-headlines?country=us&apiKey=YOUR_API_KEY'
          // YOUR_API_KEY를 실제로 발급받은 API 키로 대체하세요.
        );
        setNews(response.data.articles);
      } catch (error) {
        console.error('Error fetching news:', error);
      }
    };

    fetchNews();
  }, []);

  return (
    <div className="App">
      <h1>뉴스 목록</h1>
      <ul>
        {news.map((article, index) => (
          <li key={index}>
            <h2>{article.title}</h2>
            <p>{article.description}</p>
            <a href={article.url} target="_blank" rel="noopener noreferrer">
              뉴스 보러 가기
            </a>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

# reactlogin
