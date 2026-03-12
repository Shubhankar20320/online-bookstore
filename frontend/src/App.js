import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { AppBar, Toolbar, Button } from "@mui/material";
import { useState } from "react";

import BookList from "./components/BookList";
import CustomerList from "./components/CustomerList";
import OrderForm from "./components/OrderForm";
import Login from "./components/Login";
import Signup from "./components/Signup";

function App() {

  const [loggedIn, setLoggedIn] = useState(
    localStorage.getItem("user") ? true : false
  );

  const handleLogout = () => {
    localStorage.removeItem("user");
    setLoggedIn(false);
  };

  return (
    <Router>

      <AppBar position="static">
        <Toolbar>

          {loggedIn ? (
            <>
              <Button color="inherit" component={Link} to="/books">Books</Button>
              <Button color="inherit" component={Link} to="/customers">Customers</Button>
              <Button color="inherit" component={Link} to="/orders">Orders</Button>
              <Button color="inherit" onClick={handleLogout}>Logout</Button>
            </>
          ) : (
            <>
              <Button color="inherit" component={Link} to="/login">Login</Button>
              <Button color="inherit" component={Link} to="/signup">Signup</Button>
            </>
          )}

        </Toolbar>
      </AppBar>


      <Routes>

        {!loggedIn ? (
          <>
            <Route path="/" element={<Login setLoggedIn={setLoggedIn} />} />
            <Route path="/login" element={<Login setLoggedIn={setLoggedIn} />} />
            <Route path="/signup" element={<Signup />} />
          </>
        ) : (
          <>
            <Route path="/books" element={<BookList />} />
            <Route path="/customers" element={<CustomerList />} />
            <Route path="/orders" element={<OrderForm />} />
          </>
        )}

      </Routes>

    </Router>
  );
}

export default App;