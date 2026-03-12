import React, { useEffect, useState } from "react";
import { getBooks } from "../services/api";
import { Table, TableBody, TableCell, TableHead, TableRow, Paper } from "@mui/material";

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    getBooks()
      .then(res => {
        setBooks(res.data);
      })
      .catch(err => console.error("Error fetching books:", err));
  }, []);

  return (
    <Paper style={{ margin: 20, padding: 20 }}>
      <h2>Books</h2>

      <Table>
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Title</TableCell>
            <TableCell>Author</TableCell>
            <TableCell>Price</TableCell>
            <TableCell>Stock</TableCell>
          </TableRow>
        </TableHead>

        <TableBody>
          {books.length === 0 ? (
            <TableRow>
              <TableCell colSpan={5} align="center">
                No books available
              </TableCell>
            </TableRow>
          ) : (
            books.map(book => (
              <TableRow key={book.id}>
                <TableCell>{book.id}</TableCell>
                <TableCell>{book.title}</TableCell>
                <TableCell>{book.author}</TableCell>
                <TableCell>{book.price}</TableCell>
                <TableCell>{book.stock}</TableCell>
              </TableRow>
            ))
          )}
        </TableBody>
      </Table>

    </Paper>
  );
}

export default BookList;