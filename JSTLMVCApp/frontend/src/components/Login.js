import React, { useState } from "react";
import axios from "axios";

const Login = () => {
    const [isSignUp, setIsSignUp] = useState(false);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if (isSignUp) {
                // Sign-Up Request
                const response = await axios.post("/users/register", {
                    username,
                    password,
                });
                setMessage(response.data);
                setIsSignUp(false); // Switch to login after successful registration
            } else {
                // Login Request
                const response = await axios.post("/users/login", {
                    username,
                    password,
                });
                setMessage(`Welcome, ${response.data.username}!`);
                if (response.status === 200) {
                    window.location.href = "/upload"; // Redirect to File Upload page
                }
            }
        } catch (error) {
            setMessage("Error: " + (error.response?.data || "Server error"));
        }
    };

    return (
        <div>
            <h1>{isSignUp ? "Sign Up" : "Login"}</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <button type="submit">{isSignUp ? "Sign Up" : "Login"}</button>
            </form>
            <p>{message}</p>
            <button onClick={() => setIsSignUp(!isSignUp)}>
                {isSignUp ? "Already have an account? Login" : "Don't have an account? Sign Up"}
            </button>
        </div>
    );
};

export default Login;
