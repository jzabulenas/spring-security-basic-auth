import React, { useState } from "react";
import axios from "axios";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/login", {
        username,
        password,
      });

      // If login is successful, handle storing the token or session information
      // e.g., store token in localStorage
      localStorage.setItem("username", username);
      localStorage.setItem("password", password);
      console.log(localStorage.getItem("username"));
      console.log(localStorage.getItem("password"));

      // Redirect or update UI to indicate successful login
    } catch (error) {
      // Handle login errors (e.g., show error message)
      console.error("Login failed:", error);
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button type="submit">Login</button>
    </form>
  );
};

export default Login;
