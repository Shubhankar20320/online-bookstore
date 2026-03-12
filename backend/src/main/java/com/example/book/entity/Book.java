package com.example.book.entity;
import jakarta.persistence.*;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private double price;
	private int stock;
	
	//Getter
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	
	//Setter
	public void setId(Long id) {
		this.id=id;
		
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
		
	}
	public void setPrice(double price) {
		this.price=price;
		
	}
	public void setStock(int stock) {
		this.stock=stock;
	}

}
