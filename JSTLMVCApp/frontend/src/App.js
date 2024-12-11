import React, { useState } from 'react';
import Login from './components/Login';
import FileUpload from './components/FileUpload';
import FileList from './components/FileList';

const App = () => {
    const [user, setUser] = useState(null); // User state to track login status

    const handleLogin = (loggedInUser) => {
        setUser(loggedInUser); // Update the user state after login
    };

    return (
        <div>
            <h1>File Upload App</h1>
            {!user ? (
                // If no user is logged in, show the Login component
                <Login onLogin={handleLogin} />
            ) : (
                // If a user is logged in, show FileUpload and FileList components
                <div>
                    <p>Welcome, {user.username}!</p>
                    <FileUpload userId={user.id} />
                    <FileList userId={user.id} />
                </div>
            )}
        </div>
    );
};

export default App;
