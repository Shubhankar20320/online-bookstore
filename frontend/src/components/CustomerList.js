import React, { useEffect, useState } from "react";
import { getCustomers } from "../services/api";
import { Table, TableBody, TableCell, TableHead, TableRow, Paper } from "@mui/material";

function CustomerList() {
  const [customers, setCustomers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getCustomers()
      .then(res => {
        console.log("Fetched customers:", res.data);  // Debug print
        setCustomers(res.data);
      })
      .catch(err => {
        console.error("Error fetching customers:", err);
        setError("Failed to load customers");
      });
  }, []);

  return (
    <Paper style={{ margin: 20, padding: 20 }}>
      <h2>Customers</h2>
      {error && <div style={{color: "red"}}>{error}</div>}

      <Table>
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>Email</TableCell>
          </TableRow>
        </TableHead>

        <TableBody>
          {customers.length === 0 ? (
            <TableRow>
              <TableCell colSpan={3} style={{ textAlign: "center" }}>
                No customers found
              </TableCell>
            </TableRow>
          ) : (
            customers.map(c => (
              <TableRow key={c.id}>
                <TableCell>{c.id}</TableCell>
                <TableCell>{c.name}</TableCell>
                <TableCell>{c.email}</TableCell>
              </TableRow>
            ))
          )}
        </TableBody>
      </Table>
    </Paper>
  );
}

export default CustomerList;