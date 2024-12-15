import React from "react";
import { BrowserRouter as Router, Routes, Route, useNavigate } from "react-router-dom";
import Login from "./components/Login";
import FileUpload from "./components/FileUpload";
import FileList from "./components/FileList";
import TestConnection from "./components/TestConnection";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login />} />
				<Route path="/api/test" element={<TestConnection />} />
                <Route path="/upload" element={<FileUpload />} />
                <Route path="/files" element={<FileList />} />
            </Routes>
        </Router>
    );
};

export default App;
