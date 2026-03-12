import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const getBooks = () => API.get("/books");
export const getCustomers = () => API.get("/customers");
export const placeOrder = (order) => API.post("/orders", order);

// authentication
export const loginUser = (user) => API.post("/auth/login", user);
export const registerUser = (user) => API.post("/auth/register", user);