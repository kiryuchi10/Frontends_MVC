import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FileList = () => {
    const [files, setFiles] = useState([]);

    useEffect(() => {
        const fetchFiles = async () => {
            const response = await axios.get('/api/files');
            setFiles(response.data);
        };
        fetchFiles();
    }, []);

    return (
        <div>
            <h1>File List</h1>
            <ul>
                {files.map((file) => (
                    <li key={file.id}>{file.fileName} (Uploaded by: {file.uploadedBy})</li>
                ))}
            </ul>
        </div>
    );
};

export default FileList;
