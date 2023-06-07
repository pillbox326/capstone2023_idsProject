/*
// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
   const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div>
            백엔드에서 가져온 데이터입니다 : {hello}
        </div>
    );
}

export default App;*/

import { useState } from "react";
//import reactLogo from "./assets/react.svg";
//import viteLogo from "public/vite.svg";
import "./App.css";
import Dashboard from "./components/dashboard/Dashboard";
//import { RouterProvider, createBrowserRouter } from "react-router-dom";
import SignInSide from "./components/Login/SignInSide";
//
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (


    <Router>
      <Routes>
        <Route
          path="/"
          element={isAuthenticated ? <Dashboard setIsAuthenticated={setIsAuthenticated}/> : <Navigate to="/login" />}
        />
        <Route
          path="/old"
          element={
            <>
              {/* <TopLogo />
              <NavBar />
              <EmbedKibana /> */}
            </>
          }
        />
        <Route
          path="/login"
          element={
            isAuthenticated ? (
              <Navigate to="/" replace={true} /> // 이미 로그인된 상태라면 대시보드 페이지로 이동합니다.
            ) : (
              <SignInSide setIsAuthenticated={setIsAuthenticated} />
            )
          }        />
      </Routes>
    </Router>
  );
}

export default App;
