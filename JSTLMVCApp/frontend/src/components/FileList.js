import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FileList = ({ userId }) => {
    const [files, setFiles] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchFiles = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/files/${userId}`);
                setFiles(response.data);
                setLoading(false);
            } catch (error) {
                console.error("Error fetching files:", error);
                setLoading(false);
            }
        };

        fetchFiles();
    }, [userId]);

    if (loading) {
        return <p>Loading files...</p>;
    }

    if (files.length === 0) {
        return <p>No files uploaded yet.</p>;
    }

    return (
        <div>
            <h2>Your Uploaded Files</h2>
            <ul>
                {files.map((file) => (
                    <li key={file.id}>
                        <strong>{file.fileName}</strong> (Uploaded at: {new Date(file.uploadedAt).toLocaleString()})
                        <p>Path: {file.filePath}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FileList;
