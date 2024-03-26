import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault(); // Prevent default form submission behavior

    // Implement form submission logic here
    // This might involve making an API call to a backend service
    // to authenticate the user credentials.

    console.log('Email:', email);
    console.log('Password:', password);

    setEmail('');
    setPassword('');
  };

  return (
    <div className="signin-container">
      <form onSubmit={handleSubmit} className="signin-form">
        <h1>Sign In</h1>
        <label htmlFor="email"></label>
        <input
          type="email"
          id="email"
          name="email"
          placeholder='Email address'
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <label htmlFor="password"></label>
        <input
          type="password"
          id="password"
          name="password"
          placeholder='Password'
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <div className="forgot-password">
          <a href="#">Forgot your password?</a>
        </div>
        <Link to="/"><button type="submit">SIGN IN</button></Link>
        <div className="create-account">
          <span>Don't have an account?</span>
          <Link to="/signup">Create one</Link>
        </div>
      </form>
    </div>
  );
}

export default Login;
