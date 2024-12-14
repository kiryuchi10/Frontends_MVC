import React, { useEffect, useState } from "react";
import axios from "axios";

const TestConnection = () => {
    const [message, setMessage] = useState("");

    useEffect(() => {
        // Test the connection to the backend
        axios.get("/api/test")
            .then((response) => {
                setMessage(response.data);
            })
            .catch((error) => {
                setMessage("Failed to connect to the backend.");
                console.error("Error:", error);
            });
    }, []);

    return (
        <div>
            <h1>Backend Connection Test</h1>
            <p>{message}</p>
        </div>
    );
};

export default TestConnection;
