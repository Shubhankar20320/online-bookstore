package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.entity.Book;
import com.example.book.exception.ResourceNotFoundException;
import com.example.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    // Get all books
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // Get book by id
    public Book getBookById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }

    // Add a new book
    public Book addBook(Book book) {
        return repo.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setPrice(bookDetails.getPrice());
        existingBook.setStock(bookDetails.getStock());

        return repo.save(existingBook);
    }

    // Delete a book
    public void deleteBook(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        repo.deleteById(id);
    }
}