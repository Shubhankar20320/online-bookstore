import React, { useState } from "react";
import { placeOrder } from "../services/api";
import { TextField, Button, Paper } from "@mui/material";

function OrderForm() {
  const [order, setOrder] = useState({ status: "", quantity: 0, customerId: "", bookId: "" });

  const handleSubmit = (e) => {
    e.preventDefault();
    placeOrder({
      status: order.status,
      quantity: order.quantity,
      customer: { id: order.customerId },
      book: { id: order.bookId }
    })
    .then(() => alert("Order placed successfully!"))
    .catch(err => alert("Error: " + err.response.data));
  };

  return (
    <Paper style={{margin:20, padding:20}}>
      <h2>Place Order</h2>
      <form onSubmit={handleSubmit}>
        <TextField label="Status" fullWidth margin="normal" onChange={e => setOrder({...order, status: e.target.value})} />
        <TextField label="Quantity" type="number" fullWidth margin="normal" onChange={e => setOrder({...order, quantity: e.target.value})} />
        <TextField label="Customer ID" type="number" fullWidth margin="normal" onChange={e => setOrder({...order, customerId: e.target.value})} />
        <TextField label="Book ID" type="number" fullWidth margin="normal" onChange={e => setOrder({...order, bookId: e.target.value})} />
        <Button type="submit" variant="contained" color="primary">Place Order</Button>
      </form>
    </Paper>
  );
}

export default OrderForm;