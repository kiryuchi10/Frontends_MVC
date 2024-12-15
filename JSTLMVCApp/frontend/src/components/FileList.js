import React, { useEffect, useState } from "react";
import axios from "axios";

const FileList = () => {
    const [files, setFiles] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchFiles = async () => {
            try {
                const response = await axios.get("/files/user/1"); // Replace with dynamic user ID
                setFiles(response.data);
            } catch (error) {
                console.error("Error fetching files:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchFiles();
    }, []);

    if (loading) {
        return <p>Loading files...</p>;
    }

    if (files.length === 0) {
        return <p>No files uploaded yet.</p>;
    }

    return (
        <div>
            <h1>Your Files</h1>
            <ul>
                {files.map((file) => (
                    <li key={file.id}>
                        {file.fileName} - {file.filePath}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FileList;
