import React from 'react';
import Login from './components/Login';
import FileUpload from './components/FileUpload';
import FileList from './components/FileList';
import TestConnection from './components/TestConnection';

const App = () => {
    return (
        <div>
			<TestConnection />
            <Login />
            <FileUpload />
            <FileList />
        </div>
    );
};

export default App;
