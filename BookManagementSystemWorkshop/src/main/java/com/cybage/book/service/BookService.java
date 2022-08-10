package com.cybage.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.book.model.Book;

@Service
public class BookService {
	List<Book> bookList = new ArrayList<>();

	public BookService() {
		bookList.add(new Book(1001, "The Nature", "Sneha", "nature"));
		bookList.add(new Book(1002, "Incredible India", "Sanjay Dixit", "Garuda"));
		bookList.add(new Book(1003, "India That is Bharat", "J Sai Deepak", "Bloomsberry"));
		bookList.add(new Book(1004, "The Blood Island", "Deep Halder", "Bloomsberry"));
		bookList.add(new Book(1005, "Sixteen Stormy Days", "Tripudaman Singh", "Penguin"));
		bookList.add(new Book(1006, "Wings of Fire", "APJ Abdul Kalam", "Bloomsberry"));
		bookList.add(new Book(1007, "In the Service of Republic", "Vijay Kelkar", "Penguin"));
		bookList.add(new Book(1008, "An Era of Darkness", "Shashi Tharoor", "Bloomsberry"));
		bookList.add(new Book(1009, "Why the west rules, For Now ?", "Ian Morris", "Bloomsberry"));
		bookList.add(new Book(1010, "Essays on Indic History", "Vijendar Sharma", "Bloomsberry"));
	}

	public List<Book> getBooks() {
		return bookList;
	}

	public void addBook(Book book) {
		bookList.add(book);
		System.out.println(book);
	}

	public Book getBookById(int id) {
		return bookList.stream().filter(book -> book.getId() == id).findAny().orElse(null);
	}

	public boolean ifBookExist(int id) {
		if (getBookById(id) == null)
			return false;
		return true;
	}

	public void deleteBook(int id) {
		bookList.remove(getBookById(id));

	}

	public void editBook(Book book) {
		deleteBook(book.getId());
		bookList.add(book);
		System.out.println(book);

	}
}
