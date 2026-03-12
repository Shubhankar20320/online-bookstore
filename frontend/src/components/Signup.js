import React, { useState } from "react";
import { registerUser } from "../services/api";
import { TextField, Button, Paper } from "@mui/material";
import { useNavigate } from "react-router-dom";

function Signup() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    email: "",
    password: ""
  });

  const handleSubmit = (e) => {
    e.preventDefault();

    registerUser(user)
      .then(() => {
        alert("Signup successful");
        navigate("/login");
      })
      .catch(err => alert("Error registering user"));
  };

  return (
    <Paper style={{margin:20, padding:20}}>

      <h2>Signup</h2>

      <form onSubmit={handleSubmit}>

        <TextField
          label="Name"
          fullWidth
          margin="normal"
          onChange={e => setUser({...user, name:e.target.value})}
        />

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
          Signup
        </Button>

      </form>

    </Paper>
  );
}

export default Signup;