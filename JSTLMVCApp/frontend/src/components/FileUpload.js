import React, { useState } from 'react';
import axios from 'axios';

const FileUpload = ({ userId }) => {
    const [file, setFile] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData();
        formData.append('file', file);
        formData.append('userId', userId);

        try {
            await axios.post('http://localhost:8080/api/files/upload', formData);
            alert('File uploaded successfully');
        } catch (error) {
            alert('File upload failed');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="file" onChange={(e) => setFile(e.target.files[0])} required />
            <button type="submit">Upload</button>
        </form>
    );
};

export default FileUpload;
