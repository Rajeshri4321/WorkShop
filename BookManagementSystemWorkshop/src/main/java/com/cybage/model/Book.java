package com.cybage.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Book 
{
	private int bookId;
	@NotBlank(message="Book name cannot be blank!")
	private String bookName;
	@NotBlank
	@Size(min=4,max=20)
	private String bookAuthor;
	private String bookDescription;
	public Book() {
		super();
	}
	public Book(int bookId, String bookName, String bookAuthor, String bookDescription) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookDescription="
				+ bookDescription + "]";
	}
	
	
}
