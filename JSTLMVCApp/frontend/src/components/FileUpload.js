import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const FileUpload = () => {
    const [file, setFile] = useState(null);
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleUpload = async (e) => {
        e.preventDefault();
        if (!file) {
            setMessage("Please select a file to upload.");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);

        try {
            const response = await axios.post("/files/upload", formData, {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            });
            setMessage(response.data.message || "File uploaded successfully!");
            // Redirect to the file list page
            navigate("/files");
        } catch (error) {
            setMessage("File upload failed: " + (error.response?.data?.message || "Server error"));
        }
    };

    return (
        <div>
            <h1>Upload File</h1>
            <form onSubmit={handleUpload}>
                <input type="file" onChange={handleFileChange} />
                <button type="submit">Upload</button>
            </form>
            <p>{message}</p>
        </div>
    );
};

export default FileUpload;
