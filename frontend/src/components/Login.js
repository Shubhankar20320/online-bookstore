import React, { useState } from "react";
import { loginUser } from "../services/api";
import { TextField, Button, Paper } from "@mui/material";
import { useNavigate } from "react-router-dom";

function Login({ setLoggedIn }) {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    email: "",
    password: ""
  });

  const handleSubmit = (e) => {
    e.preventDefault();

    loginUser(user)
      .then(res => {

        localStorage.setItem("user", JSON.stringify(res.data));

        setLoggedIn(true);

        navigate("/books");
      })
      .catch(err => alert("Invalid login"));
  };

  return (
    <Paper style={{margin:20, padding:20}}>
      <h2>Login</h2>

      <form onSubmit={handleSubmit}>

        <TextField
          label="Email"
          fullWidth
          margin="normal"
          onChange={e => setUser({...user, email:e.target.value})}
        />

        <TextField
          label="Password"
          type="password"
          fullWidth
          margin="normal"
          onChange={e => setUser({...user, password:e.target.value})}
        />

        <Button type="submit" variant="contained">
          Login
        </Button>

      </form>
    </Paper>
  );
}

export default Login;